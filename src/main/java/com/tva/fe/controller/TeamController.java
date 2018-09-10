package com.tva.fe.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.fe.bll.TeamService;
import com.tva.fe.dto.TeamDto;
import com.tva.fe.model.Team;
import com.tva.fe.req.TeamReq;
import com.tva.fe.rsp.BaseRsp;
import com.tva.fe.rsp.MultipleRsp;
import com.tva.fe.rsp.SingleRsp;

@RestController
@RequestMapping("/team")
public class TeamController {
	// region -- Fields --

	@Autowired
	private TeamService teamService;

	// end

	// region -- Methods --

	@GetMapping("/search")
	public ResponseEntity<?> search() {
		MultipleRsp res = new MultipleRsp();

		try {
			// Handle
			List<Team> tmp = teamService.search();

			// Set data
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("count", tmp.size());
			data.put("data", tmp);
			res.setResult(data);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody TeamReq req) {
		BaseRsp res = new BaseRsp();

		try {
			// Get data
			int id = req.getId();
			String name = req.getName();
			String country = req.getCountry();
			String continent = req.getContinent();
			String coach = req.getCoach();
			String logo = req.getLogo();
			String history = req.getHistory();
			String[] condition = req.getCondition();

			// Convert data
			Team m = new Team();

			m.setId(id);
			m.setName(name);
			m.setCountry(country);
			m.setContinent(continent);
			m.setCoach(coach);
			m.setLogo(logo);
			m.setHistory(history);

			StringBuilder str = new StringBuilder();
			for (String item : condition) {
				str.append(item);
				str.append(",");
			}
			int count = str.toString().length();
			m.setCondition(str.toString().substring(0, count - 1));

			// Handle
			teamService.save(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/getByCal/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getByCal(@PathVariable("id") int id) {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			TeamDto m = teamService.getByCal(id);

			// Set data
			res.setResult(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			Team m = teamService.getById(id);

			// Set data
			res.setResult(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		BaseRsp res = new BaseRsp();

		try {
			// Handle
			Team m = teamService.getById(id);

			teamService.delete(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}