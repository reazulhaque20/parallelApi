package com.apex.parallelApi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MACHINE_DETAILS")
@Data
public class MachineDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MACHINE_DETAILS_id_gen")
    @SequenceGenerator(name = "MACHINE_DETAILS_id_gen", sequenceName = "SEQ_MACHINE_DETAILS", allocationSize = 1)
    private Long machineId;
    private String machineCode;
    private String machineName;
    private Long brandCode;
    private String machineModel;
    private String machineSerial;
    private String machineIp;
    private Long machinePort;
    private String machineMac;
    private String machineUsername;
    private String machinePassword;
    private Long companyCode;
    private Long locationCode;
    private String floorLocation;
    private Long groupCode;
    private String status;
}
