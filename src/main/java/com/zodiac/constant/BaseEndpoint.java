package com.zodiac.constant;

public class BaseEndpoint {

	public static class Profile {
		static public String TP = "http";
		static public String IP = "localhost";
		static public String PORT = "17002";
		static public String PATH = "/profile";
		static public String BASE_ENDPOINT = TP + "://" + IP + ":" + PORT + PATH;
	}
	
	public static class ZodiacSign {
		static public String TP = "http";
		static public String IP = "localhost";
		static public String PORT = "17001";
		static public String PATH = "/zodiacSign";
		static public String BASE_ENDPOINT = TP + "://" + IP + ":" + PORT + PATH;
	}
	
	public static class Gateway {
		static public String TP = "http";
		static public String IP = "localhost";
		static public String PORT = "17003";
		static public String PATH = "/gateway";
		static public String BASE_ENDPOINT = TP + "://" + IP + ":" + PORT + PATH;
	}
}
