package service;


import java.util.List;

import vo.Employee;
import vo.EmployeeQueryObject;
import vo.PageResult;

public interface IEmployeeService {

    Employee get(Long id);

    List<Employee> list();

    PageResult query(EmployeeQueryObject qo);
}
