package com.tva.fe.bll;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.common.Const;
import com.tva.fe.common.Enums;
import com.tva.fe.common.Utils;
import com.tva.fe.dal.AuthTokenDao;
import com.tva.fe.dal.CommonDao;
import com.tva.fe.dal.RoleDao;
import com.tva.fe.dal.UserDao;
import com.tva.fe.dto.ProfileDto;
import com.tva.fe.model.AuthToken;
import com.tva.fe.model.Common;
import com.tva.fe.model.Users;

@Service(value = "userService")
@Transactional
public class UserService implements UserDetailsService {
	// region -- Fields --

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private CommonDao commonDao;

	@Autowired
	private AuthTokenDao authTokenDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// end

	// region -- Methods --

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users u = getBy(userName);

		if (u == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		List<String> roles = roleDao.getRoleByUserId(u.getId());
		String hash = u.getPasswordHash();

		return new User(userName, hash, getAuthority(roles));
	}

	public List<SimpleGrantedAuthority> getRole(int id) {
		List<String> roles = roleDao.getRoleByUserId(id);
		List<SimpleGrantedAuthority> res = getAuthority(roles);
		return res;
	}

	private List<SimpleGrantedAuthority> getAuthority(List<String> roles) {
		return roles.stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
	}

	public Users getBy(int id) {
		Users res = userDao.getBy(id);
		return res;
	}

	public Users getBy(String userName) {
		Users res = userDao.getBy(userName);
		return res;
	}

	public Users save(Users m) {
		Integer id = m.getId();
		String userName = m.getUserName();

		Users m1;
		Common res1 = commonDao.getAmout("Amount");

		if (id == null || id == 0) {
			m1 = userDao.getBy(userName);
			if (m1 != null) {
				return null;
			} else {
				m.setUuid(UUID.randomUUID());
				m.setCreateBy(1);
				m.setCreateOn(new Date());
				m.setAmount(Float.parseFloat(res1.getText().toString()));

				return userDao.save(m);
			}
		} else {
			m1 = userDao.getBy(id);
			if (m1 == null) {
				return null;
			} else {
				m1.setModifyBy(1);
				m1.setModifyOn(new Date());

				m1.setFirstName(m.getFirstName());
				m1.setLastName(m.getLastName());
				m1.setAccountNo(m.getAccountNo());
				m1.setPhoneNo(m.getPhoneNo());
				m1.setEmail(m.getEmail());
				m1.setRemarks(m.getRemarks());

				return userDao.save(m1);
			}
		}
	}

	public ProfileDto getProfile(int id) {
		ProfileDto res = new ProfileDto();

		Users m = userDao.getBy(id);
		res.setUserName(m.getUserName());
		res.setAmount(m.getAmount());

		return res;
	}

	public String delete(int id) {
		String res = "";

		Users m = userDao.getBy(id);
		if (m != null) {
			m.setDeleted(true);
			userDao.save(m);
		}

		return res;
	}

	/**
	 * Generate token/OTP
	 * 
	 * @param module
	 *            Token/OTP of action (sign-in, transaction, ...)
	 * @param userId
	 * @param type
	 *            TOKEN or OTP or empty
	 * @return
	 * @throws Exception
	 */
	public AuthToken generateToken(String module, int userId) throws Exception {
		AuthToken m = authTokenDao.getBy("", module, userId);

		if (m == null) {
			m = new AuthToken();
		}

		m.setCreateBy(userId);
		m.setCreateOn(new Date());

		String clientKey = bCryptPasswordEncoder.encode(new Date().toString());
		m.setClientKey(clientKey);

		String token = "";
		// token = Utils.getToken();
		token = "555555";
		m.setToken(token);

		m.setModule(module);
		Date d = Utils.getTime(Calendar.MINUTE, Const.Authentication.TOKEN_MINUTE);
		m.setExpireOn(d);

		// Reset data
		m.setVerified(false);
		m.setModifyBy(null);
		m.setModifyOn(null);

		authTokenDao.save(m);

		return m;
	}

	public void verifyToken(String clientKey, int userId, String token, UUID uuid) throws Exception {
		AuthToken m = authTokenDao.getBy(clientKey, "", userId);

		if (m == null) {
			throw new Exception(Enums.Error.E201.toString());
		}

		Date t = m.getExpireOn();
		if (!Utils.verify(t)) {
			throw new Exception(Enums.Error.E202.toString());
		}

		String authKey = m.getToken();

		if (!authKey.equals(token)) {
			throw new Exception(Enums.Error.E203.toString());
		}

		m.setToken(token);
		m.setVerified(true);
		m.setModifyOn(new Date());
		m.setModifyBy(userId);

		authTokenDao.save(m);
	}

	// end
}