package com.example.application.restControllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.data.document.CompanyDocument;
import com.example.application.data.document.UserDocument;
import com.example.application.dto.UserCompanyDto;
import com.example.application.service.CompanyService;
import com.example.application.service.UserService;
import com.example.application.threads.QueueExecutorThread;
import com.example.application.threads.QueueObject;

import io.swagger.codegen.v3.service.exception.BadRequestException;

@RestController
@RequestMapping("test/")
public class TestRestController {

	@Autowired
	QueueExecutorThread queueExecutorThread;

	@Autowired
	UserService userService;

	@Autowired
	CompanyService companyService;

	@RequestMapping("slow")
	public String slow() {
		long arrive = System.currentTimeMillis();
		System.out.println(new Date(arrive) + "  Arrivo richiesta");
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long done = System.currentTimeMillis();
		System.out.println(new Date(done) + "  Eseguito calcolo in: " + (done - arrive));
		return "Done";

	}

	@RequestMapping("rapid")
	public String rapid() {
		return "Done";
	}

	@RequestMapping("queue")
	public String queue() {
//		queueExecutorThread.requestQueue.add(new QueueObject());

		try {
			queueExecutorThread.requestQueue.put(new QueueObject(queueExecutorThread.counter));
			queueExecutorThread.counter++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "enqueued";
	}

	@RequestMapping(value = "transationalInsert", method = RequestMethod.PUT)
	public UserCompanyDto transationalInsert(@RequestBody UserCompanyDto pair) {
/*
		System.out.println(pair.getUser().getNome());
		try {
			UserDocument user = userService.add(pair.getUser());
			try {
				CompanyDocument company = companyService.add(pair.getCompany());
				return new UserCompanyDto(user, company);
			} catch (Exception e) {
				userService.delete(user);
				throw new BadRequestException(e.getMessage() + "\nBad Companny!!!");
			}
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage() + "\nBad User!!!");
		}*/
		return companyService.transational(pair);
	}
}
