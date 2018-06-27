package com.tva.fe.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tva.fe.bll.CalendarService;
import com.tva.fe.model.Calendar;
import com.tva.fe.req.CalendarReq;
import com.tva.fe.rsp.SingleRsp;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	// region -- Fields --

	@Autowired
	private CalendarService calendarService;

	// end

	// region -- Methods --

	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody CalendarReq req) {
		SingleRsp res = new SingleRsp();

		try {
			// Get data
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate = dateFormat.format(req.getFromDate());
			String toDate = dateFormat.format(req.getToDate());
			Date newFromDate = dateFormat.parse(fromDate);
			Date newToDate = dateFormat.parse(toDate);

			// Handle
			List<Calendar> tmp = calendarService.getDate(newFromDate, newToDate);

			// Set data
			res.setResult(tmp);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}