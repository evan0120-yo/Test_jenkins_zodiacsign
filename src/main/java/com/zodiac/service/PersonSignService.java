package com.zodiac.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.zodiac.constant.BaseEndpoint;
import com.zodiac.constant.PersonSignConstant;
import com.zodiac.mapper.PersonSignMapper;
import com.zodiac.model.PersonSign;
import com.zodiac.model.Sign;
import com.zodiac.object.bo.PersonBO;
import com.zodiac.object.dto.SaveDTO;

@Service
public class PersonSignService {

	@Autowired
	private PersonSignMapper personSignMapper;
	
	@Autowired
	private SignService signService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Transactional
	public void save(SaveDTO saveDTO) {
		String personId = saveDTO.getPersonId();
		LocalDate birthDay = saveDTO.getBirthDay();
		// add personSign
		List<PersonSign> personSignList = new ArrayList<>();
		Sign sun = null;
		Sign moon = null;
		Sign raise = null;
		Sign nearSign = null;
		// 2. find sign for sun
		if(birthDay != null) {
			Integer year = 2000;
			if(birthDay.getMonthValue() == 12 && birthDay.getDayOfMonth() >= 22) {
				year = 1999;
			}
			LocalDate signBirthDay = LocalDate.of(year, birthDay.getMonthValue(), birthDay.getDayOfMonth());
			sun = signService.findByBirthDay(signBirthDay);
			// create nearsign
			PersonSign personSignSunNear = PersonSign.builder().personId(personId).build();
			// 計算百分比
			Integer forBorderDay = null;
			Integer serialNumber = sun.getSerialNumber();
			Integer nextSerialNumber = null;
			if(signBirthDay.isAfter(sun.getMiddleDate())) {
				// 代表日期要往後看
				forBorderDay = Period.between(signBirthDay, sun.getEndDate()).getDays();
				nextSerialNumber = serialNumber + 1;
			} else {
				// 代表日期要往前看
				forBorderDay = Period.between(sun.getStartDate(), signBirthDay).getDays();
				nextSerialNumber = serialNumber - 1;
			}
			
			Integer percent = (100 - ((forBorderDay * 100) / 30))-50;
			
			if(nextSerialNumber <= 0) {
				nextSerialNumber = 12;
			} else if (nextSerialNumber >= 13) {
				nextSerialNumber = 1;
			}
			// create sun
			PersonSign personSignSun = PersonSign.builder().personId(personId).signId(sun.getSignId())
					.personSignNumber(PersonSignConstant.Type.SUN)
					.percent(100-percent)
					.build();
			personSignList.add(personSignSun);
			// create nearSign
			nearSign = signService.findBySerialNumber(nextSerialNumber);
			personSignSunNear.setSignId(nearSign.getSignId());
			personSignSunNear.setPersonSignNumber(PersonSignConstant.Type.SUN_NEAR_SIGN);
			personSignSunNear.setPercent(percent);
			personSignList.add(personSignSunNear);
		} else {
			sun = signService.findById(saveDTO.getSunId());
			PersonSign personSignSun = PersonSign.builder().personId(personId).signId(sun.getSignId())
					.personSignNumber(PersonSignConstant.Type.SUN)
					.build();
			personSignList.add(personSignSun);
		}
//		 3. find sign for moon and raise
		if(saveDTO.getMoonId() != null) {
			moon = signService.findById(saveDTO.getMoonId());
			PersonSign personSignMoon = PersonSign.builder().personId(personId).signId(moon.getSignId())
					.personSignNumber(PersonSignConstant.Type.MOON)
					.build();
			personSignList.add(personSignMoon);
		}
		if(saveDTO.getRaiseId() != null) {
			raise = signService.findById(saveDTO.getRaiseId());
			PersonSign personSignRaise = PersonSign.builder().personId(personId).signId(raise.getSignId())
					.personSignNumber(PersonSignConstant.Type.RAISE)
					.build();
			personSignList.add(personSignRaise);
		}
		// 4. save personSign
		if(!personSignList.isEmpty()) {
			saveList(personSignList);
		}
		// 5. send profile to update profile
		if(birthDay != null) {
			PersonBO personBO = PersonBO.builder().personId(personId).birthDay(saveDTO.getBirthDay()).build();
			String url = BaseEndpoint.Profile.BASE_ENDPOINT + "/person";
			restTemplate.put(url, personBO);
		}
	}
	
	public void delete(String personSignId) {
		personSignMapper.delete(personSignId);
	}
	
	private void saveList(List<PersonSign> personSignList) {
		personSignMapper.saveAll(personSignList);
	}
}
