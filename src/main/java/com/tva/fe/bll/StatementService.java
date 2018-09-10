package com.tva.fe.bll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.StatementDao;
import com.tva.fe.model.Statement;

@Service(value = "statementService")
@Transactional
public class StatementService {
	// region -- Fields --

	String[] groupName = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };

	@Autowired
	private StatementDao statementDao;

	// end

	// region -- Methods --

	public List<Statement> search() {
		List<Statement> res = statementDao.search();
		return res;
	}

	public String save(Statement m, int number) {
		String res = "";

		Integer id = m.getId();

		Statement m1;
		if (id == null || id == 0) {
			m.setCreateOn(new Date());

			m1 = statementDao.save(m);

			for (int i = 0; i < number; i++) {
				Statement m2 = new Statement();
				m2.setName("Group " + groupName[i]);
				m2.setParentId(m1.getId());
				statementDao.save(m2);
			}

		} else {
			m1 = statementDao.getBy(id);
			if (m1 == null) {
				res = "Id does not exist";
			} else {
				m.setModifyOn(new Date());

				m.setId(m.getId());
				m.setName(m.getName());
				m.setFromDate(m.getFromDate());
				m.setToDate(m.getToDate());
				m.setHistory(m.getHistory());
				m.setCode(m.getCode());
				m.setIsLegs(m.getIsLegs());

				statementDao.save(m1);
			}
		}

		return res;
	}

	public Statement getById(int id) {
		Statement res = statementDao.getBy(id);
		return res;
	}

	public String delete(Statement m) {
		String res = "";

		if (m == null) {
			res = "Id does not exist";
		} else {
			m.setModifyOn(new Date());

			m.setDeleted(true);

			statementDao.save(m);
		}

		return res;
	}

	// end
}