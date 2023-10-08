package com.project.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class Problem {

    @JsonProperty("problemId")
    private Integer problemId;

    @JsonProperty("problemName")
    private String problemName;

    @JsonProperty("problemType")
    private String problemType;

    @JsonProperty("problemLevel")
    private String problemLevel;

    @JsonProperty("acceptance")
    private String acceptance;

    @JsonProperty("problemBody")
    private ProblemBody problemBody;

}
