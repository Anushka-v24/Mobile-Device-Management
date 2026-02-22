package com.mdm.system.controller;

import com.mdm.system.model.*;
import com.mdm.system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DeviceRepository deviceRepo;

    @Autowired
    UpdateScheduleRepository scheduleRepo;

    // view devices
    @GetMapping("/devices")
    public List<Device> devices() {
        return deviceRepo.findAll();
    }

    // schedule update
    @PostMapping("/schedule")
    public String schedule(@RequestParam String from,
                           @RequestParam String to,
                           @RequestParam String region) {

        if(to.compareTo(from) < 0) {
            return "Downgrade not allowed";
        }

        UpdateSchedule s = new UpdateSchedule();
        s.setFromVersion(from);
        s.setToVersion(to);
        s.setRegion(region);
        s.setScheduledTime(LocalDateTime.now());

        scheduleRepo.save(s);
        return "Update Scheduled";
    }
}