package com.mdm.system.controller;

import com.mdm.system.model.*;
import com.mdm.system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepo;

    @Autowired
    UpdateScheduleRepository scheduleRepo;

    @Autowired
    AuditLogRepository auditRepo;

    // register device
    @PostMapping("/register")
    public String register(@RequestParam String id,
                           @RequestParam String version,
                           @RequestParam String region) {

        Device d = new Device();
        d.setDeviceId(id);
        d.setVersion(version);
        d.setRegion(region);
        d.setLastActive(LocalDateTime.now());

        deviceRepo.save(d);
        return "Device Registered";
    }

    // device checks update
    @GetMapping("/check-update")
    public java.util.Map<String,Object> check(@RequestParam String id) {

        System.out.println("Checking device: " + id);

        Device d = deviceRepo.findById(id).orElse(null);

        if (d == null) {
            return java.util.Map.of(
                    "update", false,
                    "error", "Device not registered"
            );
        }

        System.out.println("Device version: " + d.getVersion());
        System.out.println("Device region: " + d.getRegion());

        UpdateSchedule schedule =
                scheduleRepo.findByFromVersionAndRegion(
                        d.getVersion(), d.getRegion());

        if (schedule == null) {
            return java.util.Map.of(
                    "update", false,
                    "message", "No update scheduled"
            );
        }

        return java.util.Map.of(
                "update", true,
                "newVersion", schedule.getToVersion()
        );
    }

    // device reports update status
    @PostMapping("/update-status")
    public String status(@RequestParam String deviceId,
                         @RequestParam String state) {

        AuditLog log = new AuditLog();
        log.setDeviceId(deviceId);
        log.setAction("UPDATE");
        log.setStatus(state);
        log.setTimestamp(LocalDateTime.now());

        auditRepo.save(log);

        return "Status Logged";
    }
    @GetMapping("/logs")
    public java.util.List<AuditLog> getLogs() {
        return auditRepo.findAll();
    }
    
    //@Autowired
    //AuditLogRepository auditRepo;
}