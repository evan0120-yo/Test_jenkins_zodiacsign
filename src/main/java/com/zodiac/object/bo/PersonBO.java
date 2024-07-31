package com.zodiac.object.bo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonBO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String personId;
	
	private LocalDate birthDay;
}
