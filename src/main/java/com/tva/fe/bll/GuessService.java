package com.tva.fe.bll;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.GuessDao;
import com.tva.fe.model.Guess;

@Service(value = "guessService")
@Transactional
public class GuessService {
	// region -- Fields --

	@Autowired
	private GuessDao guessDao;

	// end

	// region -- Methods --

	public String save(Guess m) {
		String res = "";

		Integer id = m.getId();
		String phone = m.getPhoneNo();

		Guess m1;
		if (id == null || id == 0) {

			m.setCreateOn(new Date());

			m1 = guessDao.save(m);

		} else {
			m1 = guessDao.getBy(id, phone);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				m.setModifyBy(id);
				m.setModifyOn(new Date());

				m1.setChampionId(m.getChampionId());
				m1.setTop4Id(m.getTop4Id());
				m1.setPhoneNo(m.getPhoneNo());
				m1.setSubQuestion(m.getSubQuestion());

				guessDao.save(m1);

			}
		}

		return res;
	}

	// end
}