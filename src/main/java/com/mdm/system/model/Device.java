package com.mdm.system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Device {

    @Id
    private String deviceId;

    private String version;
    private String region;
    private LocalDateTime lastActive;

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setLastActive(LocalDateTime lastActive) {
        this.lastActive = lastActive;
    }

    public String getVersion() {
        return version;
    }

    public String getRegion() {
        return region;
    }
}