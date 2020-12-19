package service;


import java.util.List;

import vo.Department;
import vo.PageResult;
import vo.QueryObject;

public interface IDepartmentService {


  

    List<Department> list();

    PageResult query(QueryObject qo);
}
