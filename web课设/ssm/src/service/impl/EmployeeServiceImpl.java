package service.impl;


import  vo.Employee;
import vo.EmployeeQueryObject;
import vo.PageResult;

import java.util.List;

import dao.IEmployeeDao;
import service.IEmployeeService;


public class EmployeeServiceImpl implements IEmployeeService {
   
    private IEmployeeDao employeeMapper;

 
    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    @Override
    public PageResult query(EmployeeQueryObject qo) {

        int totalCount =  employeeMapper.queryForCount(qo);

        if(totalCount == 0){
            return PageResult.EMPTY_PAGE_RESULT;
        }

        List<Employee> list = employeeMapper.queryForList(qo);
        return new PageResult(list, totalCount, qo.getCurrentPage(), qo.getPageSize());
    }
}
