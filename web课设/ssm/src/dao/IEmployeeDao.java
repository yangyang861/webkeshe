package dao;



import java.util.List;

import vo.Employee;
import vo.EmployeeQueryObject;

public interface IEmployeeDao {
  

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

   

    //分页查询：查总数
    int queryForCount(EmployeeQueryObject qo);

    //分页查询：查数据
    List<Employee> queryForList(EmployeeQueryObject qo);
}