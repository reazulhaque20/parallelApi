package com.apex.parallelApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER_MACHINE_LOGS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMachineLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_MACHINE_LOGS_id_gen")
    @SequenceGenerator(name = "USER_MACHINE_LOGS_id_gen", sequenceName = "SEQ_INNO_LOG_SERIAL", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "THREAD_ID", nullable = false)
    private Long threadId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "LOG_DATE", nullable = false)
    private String logDate;

    @Column(name = "MC_TYPE", nullable = false, length = 10)
    private String mcType;

    @Column(name = "DEVICE_IDENTIFIER")
    private Long deviceIdentifier;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "STATUS")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getMcType() {
        return mcType;
    }

    public void setMcType(String mcType) {
        this.mcType = mcType;
    }

    public Long getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public void setDeviceIdentifier(Long deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}