package dao;


import java.util.List;

import vo.Department;
import vo.QueryObject;

public interface IDepartmentDao {

    //分页查询：查总数
    int queryForCount(QueryObject qo);

    //分页查询：查数据
    List<Department> queryForList(QueryObject qo);

}