package com.tva.fe.bll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.TeamDao;
import com.tva.fe.model.Team;

@Service(value = "teamService")
@Transactional
public class TeamService {
	// region -- Fields --

	@Autowired
	private TeamDao teamDao;

	// end

	// region -- Methods --

	public List<Team> search() {
		List<Team> res = teamDao.search();
		return res;
	}

	public String save(Team m) {
		String res = "";

		Integer id = m.getId();

		Team m1;
		if (id == null || id == 0) {

			m.setCreateOn(new Date());

			m1 = teamDao.save(m);

		} else {
			m1 = teamDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				m.setModifyOn(new Date());

				m.setName(m.getName());
				m.setCountry(m.getCountry());
				m.setContinent(m.getContinent());
				m.setCoach(m.getCoach());
				m.setLogo(m.getLogo());
				m.setHistory(m.getHistory());

				teamDao.save(m1);
			}
		}

		return res;
	}

	public Team getById(int id) {
		Team res = teamDao.getBy(id);
		return res;
	}

	public String delete(Team m) {
		String res = "";

		if (m == null) {
			res = "Id does not exist";
		} else {
			m.setModifyOn(new Date());

			m.setDeleted(true);

			teamDao.save(m);
		}

		return res;
	}

	// end
}