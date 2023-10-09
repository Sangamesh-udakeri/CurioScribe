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

	@Override
	public String toString() {
		return "problemId=" + problemId + "\n" +
		           "ProblemName=" + problemName + "\n" +
		           "ProblemType=" + problemType + "\n" +
		           "ProblemLevel=" + problemLevel + "\n" +
		           "Acceptance=" + acceptance + "\n" +
		            problemBody.getDescription() +"\n" +
		            "Exmp1=" + problemBody.getExmp1() + "\n"+
					"Exmp2=" + problemBody.getExmp2() + "\n"+
					"Constrainsts=" + problemBody.getConstrainsts();
	}

}
