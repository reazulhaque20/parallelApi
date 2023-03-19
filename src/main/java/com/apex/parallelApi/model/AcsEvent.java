package com.apex.parallelApi.model;

import lombok.Data;

import java.util.List;

@Data
public class AcsEvent {
    private String searchID;
    private int totalMatches;
    private String responseStatusStrg;
    private int numOfMatches;
    private List<InfoList> InfoList;
}
