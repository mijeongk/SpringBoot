package kr.top2blue.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import kr.top2blue.jpa.vo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
