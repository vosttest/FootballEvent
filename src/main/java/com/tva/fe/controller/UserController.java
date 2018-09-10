package com.tva.fe.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tva.fe.bll.UserService;
import com.tva.fe.common.Const;
import com.tva.fe.common.Utils;
import com.tva.fe.config.JwtTokenUtil;
import com.tva.fe.dto.PayloadDto;
import com.tva.fe.dto.ProfileDto;
import com.tva.fe.model.AuthToken;
import com.tva.fe.model.Users;
import com.tva.fe.req.UserSignInReq;
import com.tva.fe.req.UserVerifyPhoneReq;
import com.tva.fe.rsp.SingleRsp;

@RestController
@RequestMapping("/user")
public class UserController {
	// region -- Fields --

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// end

	// region -- Methods --

	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody UserSignInReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			String userName = req.getUserName();
			String password = req.getPassword();

			// Handle
			Users m = userService.getBy(userName);
			if (m == null) {
				res.setError("User name doesn't exist!");
			} else {
				UsernamePasswordAuthenticationToken x;
				x = new UsernamePasswordAuthenticationToken(userName, password);
				Authentication y = authenticationManager.authenticate(x);
				SecurityContextHolder.getContext().setAuthentication(y);
				int userId = m.getId();

				// Set data
				List<SimpleGrantedAuthority> z = userService.getRole(userId);
				String t3 = jwtTokenUtil.doGenerateToken(m, z);

				res.setResult(t3);
			}
		} catch (AuthenticationException e) {
			res.setError("Invalid user name or password!");
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// @PostMapping("/sign-up")
	// public ResponseEntity<?> signUp(@RequestBody UserSignUpReq req) {
	// SingleRsp res = new SingleRsp();
	//
	// try {
	// // Get data
	// String userName = req.getUserName();
	// String firstName = req.getFirstName();
	// String lastName = req.getLastName();
	// String phoneNo = req.getPhoneNo();
	// String address = req.getAddress();
	// String remarks = req.getRemarks();
	//
	// String password = req.getPassword();
	// password = bCryptPasswordEncoder.encode(password);
	//
	// // Convert data
	// Users m = new Users();
	// m.setUserName(userName);
	// m.setFirstName(firstName);
	// m.setLastName(lastName);
	// m.setPhoneNo(phoneNo);
	// m.setAddress(address);
	// m.setRemarks(remarks);
	// m.setPasswordHash(password);
	//
	// // Handle
	// String tmp = userService.save(m);
	//
	// if (tmp.isEmpty()) {
	// List<SimpleGrantedAuthority> z = userService.getRole(m.getId());
	// String token = jwtTokenUtil.doGenerateToken(m, z);
	//
	// // Set Data
	// res.setResult(token);
	// } else {
	// res.setError("User name has already been registed!");
	// }
	// } catch (Exception ex) {
	// res.setError(ex.getMessage());
	// }
	//
	// return new ResponseEntity<>(res, HttpStatus.OK);
	// }

	@PostMapping("/verify-phone")
	public ResponseEntity<?> verifyPhone(@RequestBody UserVerifyPhoneReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			String userName = req.getUserName(); // phone no
			String password = req.getUserName();
			String clientKey = req.getClienKey();
			String token = req.getToken();
			boolean sendToken = req.isSendToken();

			// Handle
			Map<String, Object> data = new LinkedHashMap<>();
			Users m = userService.getBy(userName);
			if (m == null) {
				m = new Users();
				m.setUserName(userName);
				m.setPhoneNo(userName);
				userName = bCryptPasswordEncoder.encode(userName);
				m.setPasswordHash(userName);

				// Handle
				Users tmp = userService.save(m);
				AuthToken m1 = userService.generateToken(Const.Module.SIGN_IN, tmp.getId());
				String t3 = m1.getClientKey();
				t3 = m1.getClientKey();

				// Send SMS
				// String t4 = m.getUserName();
				// String t5 = m1.getToken();
				// MessageService.send(t4, t5);

				data.put("authen", "SignUp Success");
				data.put("key", t3);
			} else {
				UsernamePasswordAuthenticationToken x;
				x = new UsernamePasswordAuthenticationToken(userName, password);
				Authentication y = authenticationManager.authenticate(x);
				SecurityContextHolder.getContext().setAuthentication(y);
				int userId = m.getId();

				// Set data
				if (sendToken) {
					AuthToken m1 = userService.generateToken(Const.Module.SIGN_IN, userId);
					String t3 = m1.getClientKey();
					t3 = m1.getClientKey();

					// Send SMS
					// String t4 = m.getUserName();
					// String t5 = m1.getToken();
					// MessageService.send(t4, t5);

					data.put("authen", "SignIn Success");
					data.put("key", t3);
				} else {
					userService.verifyToken(clientKey, userId, token, m.getUuid());

					List<SimpleGrantedAuthority> z = userService.getRole(m.getId());
					String t1 = jwtTokenUtil.doGenerateToken(m, z);
					data.put("key", t1);
				}
			}
			res.setResult(data);
		} catch (AuthenticationException e) {
			res.setError("Invalid user name or password!");
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<?> view(@RequestHeader HttpHeaders header) {
		SingleRsp res = new SingleRsp();

		try {
			PayloadDto pl = Utils.getTokenInfor(header);
			int id = pl.getId();

			// Handle
			ProfileDto m = userService.getProfile(id);

			// Set data
			res.setResult(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	// end
}