package com.project.mapping;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class ProblemBody {
	private Integer bodyId;
	private String  description;
	private String  exmp1;
	private String  exmp2;
	private String  constrainsts;
}
