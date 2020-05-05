package com.spring.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.dao.EmployeeDao;
import com.spring.dto.EmployeeDto;
import com.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Employee employee) throws Exception {
		return jdbcTemplate.update(
				"insert into employees (id, first_name, last_name, email_address) " + "values(?, ?, ?, ?)",
				new Object[] { employee.getId(), employee.getFirstName(), employee.getLastName(),
						employee.getEmailId() });
	}

	@Override
	public int insert(EmployeeDto employeeDto) throws Exception {
		String query = "insert into employee_details (first_name, last_name, email_id) " + "values(?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, new String[] { "emp_id" });
				ps.setString(1, employeeDto.getFirstName());
				ps.setString(2, employeeDto.getLastName());
				ps.setString(3, employeeDto.getEmailId());
				return ps;
			}
		}, keyHolder);
		System.out.println(keyHolder.getKey().intValue());
		Integer insertedEmployeeId = keyHolder.getKey().intValue();
		if (insertedEmployeeId != null && employeeDto.getEmployeeAddresses() != null
				&& employeeDto.getEmployeeAddresses().size() > 0) {
			for (int i = 0; i < employeeDto.getEmployeeAddresses().size(); i++) {
				jdbcTemplate.update("insert into emp_address (address_details, emp_id) " + "values(?, ?)",
						new Object[] { employeeDto.getEmployeeAddresses().get(i).getAddressDetails(), insertedEmployeeId });
			}
		}
		return 1;
	}
}
