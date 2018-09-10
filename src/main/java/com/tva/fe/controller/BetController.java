package com.tva.fe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.fe.bll.BetService;
import com.tva.fe.bll.GuessService;
import com.tva.fe.common.Utils;
import com.tva.fe.dto.PayloadDto;
import com.tva.fe.model.Bet;
import com.tva.fe.model.Guess;
import com.tva.fe.req.BetReq;
import com.tva.fe.req.GuessReq;
import com.tva.fe.rsp.BaseRsp;

@RestController
@RequestMapping("/bet")
public class BetController {
	// region -- Fields --

	@Autowired
	private BetService betService;

	@Autowired
	private GuessService guessService;

	// end

	// region -- Methods --

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestHeader HttpHeaders header, @RequestBody BetReq req) {
		BaseRsp res = new BaseRsp();

		try {
			PayloadDto pl = Utils.getTokenInfor(header);
			int userId = pl.getId();

			Integer id = req.getId();
			Integer calendarId = req.getCalendarId();
			String code = req.getCode();
			Integer g11 = req.getG11();
			Integer g21 = req.getG21();
			Integer g22 = req.getG22();
			Integer g31 = req.getG31();
			Integer g41 = req.getG41();
			Float amount = req.getAmount();
			Integer subQuestion = req.getSubQuestion();
			String status = req.getStatus();

			Bet m = new Bet();
			m.setId(id);
			m.setCalendarId(calendarId);
			m.setCode(code);
			m.setG11(g11);
			m.setG21(g21);
			m.setG22(g22);
			m.setG31(g31);
			m.setG41(g41);
			m.setAmount(amount);
			m.setSubQuestion(subQuestion);
			m.setStatus(status);
			m.setUserId(userId);

			betService.save(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/saveGuess")
	public ResponseEntity<?> saveGuess(@RequestHeader HttpHeaders header, @RequestBody GuessReq req) {
		BaseRsp res = new BaseRsp();

		try {

			int champion = req.getChampionId();
			String top4 = req.getTop4Id();
			String phone = req.getPhoneNo();
			int subQuestion = req.getSubQuestion();

			Guess m = new Guess();
			m.setChampionId(champion);
			m.setTop4Id(top4);
			m.setPhoneNo(phone);
			m.setSubQuestion(subQuestion);

			guessService.save(m);

		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestHeader HttpHeaders header, @PathVariable("id") int id) {
		BaseRsp res = new BaseRsp();

		try {
			PayloadDto pl = Utils.getTokenInfor(header);
			int userId = pl.getId();

			Bet m = betService.getById(id);

			betService.delete(m, userId);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}