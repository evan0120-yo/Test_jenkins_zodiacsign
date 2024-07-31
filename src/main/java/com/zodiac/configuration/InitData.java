package com.zodiac.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zodiac.constant.BaseEndpoint;


@Configuration
public class InitData {
	
	@Value("${env.profile.ip}")
	private String profileIp;
	@Value("${env.zodiacsign.ip}")
	private String zodiacsignIp;
	@Value("${env.gateway.ip}")
	private String gatewayIp;
	
	@Profile("prod")
	@Bean
	public String init() {
		BaseEndpoint.Profile.IP = profileIp;
		BaseEndpoint.Profile.BASE_ENDPOINT = BaseEndpoint.Profile.TP + "://" + BaseEndpoint.Profile.IP + ":" + BaseEndpoint.Profile.PORT + BaseEndpoint.Profile.PATH;
		BaseEndpoint.ZodiacSign.IP = zodiacsignIp;
		BaseEndpoint.ZodiacSign.BASE_ENDPOINT = BaseEndpoint.ZodiacSign.TP + "://" + BaseEndpoint.ZodiacSign.IP + ":" + BaseEndpoint.ZodiacSign.PORT + BaseEndpoint.ZodiacSign.PATH;
		BaseEndpoint.Gateway.IP = gatewayIp;
		BaseEndpoint.Gateway.BASE_ENDPOINT = BaseEndpoint.Gateway.TP + "://" + BaseEndpoint.Gateway.IP + ":" + BaseEndpoint.Gateway.PORT + BaseEndpoint.Gateway.PATH;
		return null;
	}
}
