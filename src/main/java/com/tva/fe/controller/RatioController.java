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

import com.tva.fe.bll.RatioService;
import com.tva.fe.model.Ratio;
import com.tva.fe.req.RatioReq;
import com.tva.fe.rsp.BaseRsp;
import com.tva.fe.rsp.SingleRsp;

@RestController
@RequestMapping("/ratio")
public class RatioController {
	// region -- Fields --

	@Autowired
	private RatioService ratioService;

	// end

	// region -- Methods --

	@GetMapping("/search")
	public ResponseEntity<?> search() {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			List<Ratio> tmp = ratioService.search();

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
	
	@RequestMapping(value = "/search-by-calendar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> searchByCal(@PathVariable("id") int id) {
		SingleRsp res = new SingleRsp();

		try {
			// Handle
			List<Ratio> m = ratioService.getByCal(id);

			// Set data
			res.setResult(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody RatioReq req) {
		BaseRsp res = new BaseRsp();

		try {
			// Get data
			int id = req.getId();
			int calendarId = req.getCalendarId();
			String code = req.getCode();
			Float r11 = req.getR11();
			Float r12 = req.getR12();
			Float r13 = req.getR13();
			Float r21 = req.getR21();
			Float r22 = req.getR22();
			Float r31 = req.getR31();
			Float r32 = req.getR32();
			Float r33 = req.getR33();
			int r4 = req.getR4();

			// Convert data
			Ratio m = new Ratio();

			m.setR11(r11);
			m.setR12(r12);
			m.setR13(r13);
			m.setR21(r21);
			m.setR22(r22);
			m.setR31(r31);
			m.setR32(r32);
			m.setR33(r33);
			m.setR4(r4);
			m.setCalendarId(calendarId);
			m.setId(id);
			m.setCode(code);

			// Handle
			ratioService.save(m);
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
			Ratio m = ratioService.getById(id);

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
			Ratio m = ratioService.getById(id);

			ratioService.delete(m);
		} catch (Exception ex) {
			res.setError(ex.getMessage());
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// end
}