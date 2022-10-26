package com.apex.parallelApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetaData {
    public int current_page;
    public int from;
    public int last_page;
    public String path;
    public int per_page;
    @JsonProperty("to")
    public int myto;
    public int total;
}
