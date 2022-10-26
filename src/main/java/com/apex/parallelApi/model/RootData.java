package com.apex.parallelApi.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RootData {
    public ArrayList<LogData> data;
    public LinksData links;
    public MetaData meta;
    public ProjectData project;
}
