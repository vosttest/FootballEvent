package com.tva.fe.bll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.RatioDao;
import com.tva.fe.model.Ratio;

@Service(value = "ratioService")
@Transactional
public class RatioService {
	// region -- Fields --

	@Autowired
	private RatioDao ratioDao;

	// end

	// region -- Methods --

	public List<Ratio> search() {
		List<Ratio> res = ratioDao.search();
		return res;
	}
	
	public List<Ratio> getByCal(int calendarId) {
		List<Ratio> res = ratioDao.getByCal(calendarId);
		return res;
	}
	
	public String save(Ratio m) {
		String res = "";

		Integer id = m.getId();

		Ratio m1;
		if (id == null || id == 0) {

			m.setCreateOn(new Date());

			m1 = ratioDao.save(m);

		} else {
			m1 = ratioDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				m.setModifyOn(new Date());

				m1.setR11(m.getR11());
				m1.setR12(m.getR12());
				m1.setR13(m.getR13());
				m1.setR21(m.getR21());
				m1.setR22(m.getR22());
				m1.setR31(m.getR31());
				m1.setR32(m.getR32());
				m1.setR33(m.getR33());
				m1.setR4(m.getR4());
				m1.setCalendarId(m.getCalendarId());
				m1.setCode(m.getCode());

				ratioDao.save(m1);
			}
		}

		return res;
	}

	public Ratio getById(int id) {
		Ratio res = ratioDao.getBy(id);
		return res;
	}

	public String delete(Ratio m) {
		String res = "";

		if (m == null) {
			res = "Id does not exist";
		} else {
			m.setModifyOn(new Date());

			m.setDeleted(true);

			ratioDao.save(m);
		}

		return res;
	}

	// end
}