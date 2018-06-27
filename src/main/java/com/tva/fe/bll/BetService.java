package com.tva.fe.bll;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.BetDao;
import com.tva.fe.model.Bet;

@Service(value = "betService")
@Transactional
public class BetService {
	// region -- Fields --

	@Autowired
	private BetDao betDao;

	// end

	// region -- Methods --

	public String save(Bet m) {
		String res = "";

		Integer id = m.getId();
		int userId = m.getUserId();

		Bet m1;
		if (id == null || id == 0) {

			m.setCreateBy(userId);
			m.setCreateOn(new Date());

			m1 = betDao.save(m);

		} else {
			m1 = betDao.getBy(id, userId);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				m.setModifyBy(userId);
				m.setModifyOn(new Date());

				m1.setCalendarId(m.getCalendarId());
				m1.setCode(m.getCode());
				m1.setG11(m.getG11());
				m1.setG21(m.getG21());
				m1.setG22(m.getG22());
				m1.setG31(m.getG31());
				m1.setG41(m.getG41());
				m1.setAmount(m.getAmount());
				m1.setSubQuestion(m.getSubQuestion());
				m1.setStatus(m.getStatus());
				m1.setUserId(userId);

				betDao.save(m1);

			}
		}

		return res;
	}

	public Bet getById(int id) {
		Bet res = betDao.getById(id);
		return res;
	}

	public String delete(Bet m, int userId) {
		String res = "";

		if (m == null) {
			res = "Id does not exist";
		} else {
			m.setModifyBy(userId);
			m.setModifyOn(new Date());

			m.setIsDeleted(true);

			betDao.save(m);
		}

		return res;
	}

	// end
}