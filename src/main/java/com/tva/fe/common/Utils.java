package com.tva.fe.common;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tva.fe.dto.PayloadDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class Utils {
	// region -- Fields --

	// end

	// region -- Methods --

	/**
	 * Date format
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateFormat(String date) {
		Date res = null;
		SimpleDateFormat f = new SimpleDateFormat(Const.DateTime.FULL);

		try {
			res = f.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Get authorities
	 * 
	 * @param roles
	 * @return
	 */
	public static List<SimpleGrantedAuthority> getAuthorities(List<String> roles) {
		if (roles != null) {
			return roles.stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	/**
	 * Get token information
	 * 
	 * @param header
	 * @return
	 */
	public static PayloadDto getTokenInfor(HttpHeaders header) {
		String token = header.get(Const.Authentication.HEADER_STRING).get(0);
		token = token.replace(Const.Authentication.TOKEN_PREFIX, "");

		JwtParser x = Jwts.parser().setSigningKey(Const.Authentication.SIGNING_KEY);
		Claims y = x.parseClaimsJws(token).getBody();
		Object z = y.get(Const.Authentication.PAYLOAD_NAME);

		ObjectMapper mapper = new ObjectMapper();
		PayloadDto res = mapper.convertValue(z, PayloadDto.class);
		return res;
	}

	/**
	 * Function get date time, when user can guess a result of match
	 * 
	 * @param competitionDate
	 * @param type            Choose attribute to add (Calendar.MINUTE,
	 *                        Calendar.HOUR, ...)
	 * @param n               Number want to add
	 * @return
	 * @throws Exception
	 */
	public static Date getStartGuess(Date competitionDate, int type, int n) throws Exception {
		Date res = null;

		try {
			Calendar c = Calendar.getInstance();
			c.setTime(competitionDate);
			c.add(type, n);
			res = c.getTime();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return res;
	}

	/**
	 * Get UTC date time
	 * 
	 * @param type Choose attribute to add (Calendar.MINUTE, Calendar.HOUR, ...)
	 * @param n    Number want to add
	 * @return
	 * @throws Exception
	 */
	public static Date getTime(int type, int n) throws Exception {
		Date res = null;

		try {
			TimeZone t = TimeZone.getTimeZone("UTC");
			Calendar c = Calendar.getInstance(t);
			c.add(type, n);
			res = c.getTime();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return res;
	}

	/**
	 * Verify with current date
	 * 
	 * @param d Date
	 * @return
	 */
	public static boolean verify(Date d) {
		TimeZone t = TimeZone.getTimeZone("UTC");
		Calendar c = Calendar.getInstance(t);

		if (d.compareTo(c.getTime()) < 0) {
			return false;
		}

		return true;
	}

	/**
	 * Get token with 6 digits
	 * 
	 * @return
	 */
	public static String getToken() {
		int n = Const.Authentication.TOKEN_NUMBER;
		int max = (int) Math.pow(10, n) - 1;

		Random t = new Random();
		int s = t.nextInt(max);

		char[] zeros = new char[n];
		Arrays.fill(zeros, '0');
		String format = String.valueOf(zeros);
		DecimalFormat df = new DecimalFormat(format);
		String res = df.format(s);

		return res;
	}

	// end
}