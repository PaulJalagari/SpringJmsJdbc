package com.spring.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import com.spring.dto.EmployeeDto;
import com.spring.exceptions.InsufficientDataException;
import com.spring.model.Employee;
import com.spring.producer.MessageSender;
import com.spring.receiver.MessageReceiver;
import com.spring.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	MessageSender messageSender;

	@Autowired
	MessageReceiver messageReceiver;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Boolean insert(Employee employee) throws Exception {
		if (employee.getId() != null && employee.getEmailId() != null && employee.getFirstName() != null
				&& employee.getLastName() != null) {
			messageSender.sendMessage(employee);
			LOG.info("Message has been sent successfully...");
			// System.out.println("Message has been sent successfully...");
			return true;
		} else {
			LOG.error("Missing required Fields");
			throw new InsufficientDataException("Missing required Fields");
		}

	}

	@Override
	public Boolean consume() throws Exception {
		Employee emp = messageReceiver.receiveMessage();
		LOG.info("Message received : " + emp);
		// System.out.println("Message received : " + emp);
		int val = 0;
		val = employeeDao.insert(emp);
		if (val != 1) {
			LOG.error("Failed to insert: " + emp);
			return false;
		}
		LOG.info("Message inserted : " + emp);
		return true;
	}

	@Override
	public Boolean insertEmployeeInfo(EmployeeDto employeeDto) throws Exception {
		if (employeeDto.getEmailId() != null && employeeDto.getFirstName() != null
				&& employeeDto.getLastName() != null) {
			messageSender.sendMessage(employeeDto);
			LOG.info("Message has been sent successfully...");
			// System.out.println("Message has been sent successfully...");
			return true;
		} else {
			LOG.error("Missing required Fields");
			throw new InsufficientDataException("Missing required Fields");
		}

	}

	@Override
	public Boolean consumeEmployeeInfo() throws Exception {
		EmployeeDto emp = messageReceiver.receiveEmployeeInfo();
		LOG.info("Message received : " + emp);
		// System.out.println("Message received : " + emp);
		int val = 0;
		val = employeeDao.insert(emp);
		if (val != 1) {
			LOG.error("Failed to insert: " + emp);
			return false;
		}
		LOG.info("Message inserted : " + emp);
		return true;
	}
}
