package com.tva.fe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tva.fe.bll.TeamService;
import com.tva.fe.model.Team;
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
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			List<Team> data = teamService.search();

			// Set data
			res.setResult(data);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}