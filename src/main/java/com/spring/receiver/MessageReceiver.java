package com.spring.receiver;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;

@Component
public class MessageReceiver {
	@Lazy
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	public Employee receiveMessage() {
		try {
			/*
			 * Here we receive the message.
			 */
			Message message = jmsTemplate.receive();
			Employee emp = (Employee) messageConverter.fromMessage(message);
			return emp;

		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return null;
	}

	public EmployeeDto receiveEmployeeInfo() {
		try {
			/*
			 * Here we receive the message.
			 */
			Message message = jmsTemplate.receive();
			EmployeeDto emp = (EmployeeDto) messageConverter.fromMessage(message);
			return emp;

		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return null;
	}
}
