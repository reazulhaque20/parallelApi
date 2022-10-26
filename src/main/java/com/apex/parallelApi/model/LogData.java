package com.apex.parallelApi.model;

import lombok.Data;

@Data
public class LogData {
    public String sync_time;
    public String logged_time;
    public String type;
    public String uid;
    public String device_identifier;
    public String location;
    public String person_identifier;
    public String rfid;
    public String primary_display_text;
    public String secondary_display_text;
}
