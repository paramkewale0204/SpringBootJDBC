package com.practice.spring.api.dao;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.practice.spring.api.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee2 (first_name, last_name, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    @Override
    public Employee findById(Long id) {
        String sql = "SELECT * FROM employee2 WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee2";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee2 SET first_name=?, last_name=?, email=? WHERE id=?";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employee2 WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    private static class EmployeeMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            return employee;
        }
    }
}
