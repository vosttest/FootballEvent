package com.tva.fe.bll;

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

	// end
}