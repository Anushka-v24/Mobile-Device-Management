package com.mdm.system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UpdateSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromVersion;
    private String toVersion;
    private String region;
    private LocalDateTime scheduledTime;

    public String getToVersion() {
        return toVersion;
    }

    public void setFromVersion(String fromVersion) {
        this.fromVersion = fromVersion;
    }

    public void setToVersion(String toVersion) {
        this.toVersion = toVersion;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}