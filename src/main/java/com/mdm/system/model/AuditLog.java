package com.mdm.system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String action;
    private String status;
    private LocalDateTime timestamp;

    // ✅ REQUIRED getters

    public Long getId() {
        return id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // setters

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}