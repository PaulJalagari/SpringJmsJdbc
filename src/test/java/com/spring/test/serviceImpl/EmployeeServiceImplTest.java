package com.spring.test.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.spring.dao.EmployeeDao;
import com.spring.dto.EmployeeDto;
import com.spring.exceptions.InsufficientDataException;
import com.spring.model.Address;
import com.spring.model.Employee;
import com.spring.producer.MessageSender;
import com.spring.receiver.MessageReceiver;
import com.spring.serviceImpl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

	@Mock
	EmployeeDao employeeDao;

	@Mock
	MessageSender messageSender;

	@Mock
	MessageReceiver messageReceiver;

	@InjectMocks
	EmployeeServiceImpl employeeService;

	Employee employee;
	Employee employee1;
	EmployeeDto employeeDto;
	List<Address> employeeAddresses;
	Address empAddress;

	@Before
	public void setupMock() {
		employee = new Employee(876L, "fname", "lname", "fl@gmail.com");
		employee1 = new Employee();
		employee1.setEmailId("test@mail.com");
		empAddress = new Address();
		empAddress.setAddressDetails("test address");
		empAddress.setEmployeeId(2);
		employeeAddresses = new ArrayList<Address>();
		employeeAddresses.add(empAddress);
		employeeDto = new EmployeeDto();
		employeeDto.setEmailId("testEmail");
		employeeDto.setFirstName("testFristName");
		employeeDto.setLastName("testLastName");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void insert() throws Exception {
		Mockito.doNothing().when(messageSender).sendMessage(Mockito.any(Employee.class));
		assertEquals(true, employeeService.insert(employee));
	}

	@Test(expected = InsufficientDataException.class)
	public void insert_whenInsufficienDataExThrown() throws Exception {
		Mockito.doNothing().when(messageSender).sendMessage(Mockito.any(Employee.class));
		assertEquals(true, employeeService.insert(employee1));
	}

	@Test
	public void consume() throws Exception {
		Mockito.when(messageReceiver.receiveMessage()).thenReturn(employee);
		Mockito.when(employeeDao.insert(Mockito.any(Employee.class))).thenReturn(1);
		assertEquals(true, employeeService.consume());
	}

	@Test
	public void insertEmployeeInfoTest() throws Exception {
		Mockito.doNothing().when(messageSender).sendMessage(Mockito.any(EmployeeDto.class));
		assertEquals(true, employeeService.insertEmployeeInfo(employeeDto));
	}

	@Test
	public void consumeEmployeeInfo() throws Exception {
		Mockito.when(messageReceiver.receiveEmployeeInfo()).thenReturn(employeeDto);
		Mockito.when(employeeDao.insert(Mockito.any(EmployeeDto.class))).thenReturn(1);
		assertEquals(true, employeeService.consumeEmployeeInfo());
	}
}
