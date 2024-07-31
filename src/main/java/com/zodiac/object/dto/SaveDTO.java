package com.zodiac.object.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String personId;
	
	private String sunId;
	
	private LocalDate birthDay;
	
	private String moonId;
	
	private String raiseId;
	
	
}
