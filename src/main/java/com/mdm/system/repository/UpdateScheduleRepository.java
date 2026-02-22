package com.mdm.system.repository;

import com.mdm.system.model.UpdateSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateScheduleRepository
        extends JpaRepository<UpdateSchedule, Long> {

    UpdateSchedule findByFromVersionAndRegion(String fromVersion, String region);
}