package com.appsdeveloperblog.ws.security;

import org.springframework.core.env.Environment;

import com.appsdeveloperblog.ws.SpringApplicationContext;

public class SecurityConstants {
	
	public static final long EXPIRATION_TIME=864000000;
	public static final String TOKEN_PREFIX="Bearer";
	public static final String HEADER_STRING="Authorization";
	public static final String SIGN_UP_URL="/users";
    public static final String TOKEN_SECRET="baguyasgdjhbfduwaegfjnwbefyuawbejgwjedbwugdshbLIQWUasdhgqsjyewubaxduiqhdxbqiwjdhxciwqHDIQUWEYQ82671723T3NSJKAHDIAULWIUQ2316782537611";
	public static long getExpirationTime() {
		return EXPIRATION_TIME;
	}
	public static String getTokenPrefix() {
		return TOKEN_PREFIX;
	}
	public static String getHeaderString() {
		return HEADER_STRING;
	}
	public static String getSignUpUrl() {
		return SIGN_UP_URL;
	}

	
	public static String getTokenSecret() {
		Environment environment=(Environment) SpringApplicationContext.getBean("environment");
		return environment.getProperty("tokenSecret");
	}
}
