package com.jobfinder.domain;

import lombok.Data;

@Data
public class RegionVO {
    private int region_seq;
    private String region;
    private int sub_region_seq;
    private int super_region_seq;
}
