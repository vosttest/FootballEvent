package com.tva.fe.controller;

import java.util.Date;
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

import com.tva.fe.bll.StatementService;
import com.tva.fe.model.Statement;
import com.tva.fe.req.StatementReq;
import com.tva.fe.rsp.BaseRsp;
import com.tva.fe.rsp.SingleRsp;

@RestController
@RequestMapping("/statement")
public class StatementController {
	// region -- Fields --

	@Autowired
	private StatementService statementService;

	// end

	// region -- Methods --

	@GetMapping("/search")
	public ResponseEntity<?> search() {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			List<Statement> tmp = statementService.search();

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
	public ResponseEntity<?> save(@RequestBody StatementReq req) {
		BaseRsp res = new BaseRsp();

		try {
			// Get data
			int id = req.getId();
			String name = req.getName();
			Date fromDate = req.getFromDate();
			Date toDate = req.getToDate();
			String history = req.getHistory();
			String code = req.getCode();
			Boolean isLegs = req.getIsLegs();
			int number = req.getNumber();

			// Convert data
			Statement m = new Statement();

			m.setId(id);
			m.setName(name);
			m.setFromDate(fromDate);
			m.setToDate(toDate);
			m.setHistory(history);
			m.setCode(code);
			m.setIsLegs(isLegs);

			// Handle
			statementService.save(m, number);
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
			Statement m = statementService.getById(id);

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
			Statement m = statementService.getById(id);

			statementService.delete(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}