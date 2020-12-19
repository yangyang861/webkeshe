package service.impl;

import java.util.List;

import dao.IDepartmentDao;
import service.IDepartmentService;
import vo.Department;
import vo.PageResult;
import vo.QueryObject;


public class DepartmentServiceImpl implements IDepartmentService {

    private IDepartmentDao departmentdao;

   
    @Override
    public PageResult query(QueryObject qo) {

        int totalCount =  departmentdao.queryForCount(qo);

        if(totalCount == 0){
            return PageResult.EMPTY_PAGE_RESULT;
        }

        List<Department> list = departmentdao.queryForList(qo);
        return new PageResult(list, totalCount, qo.getCurrentPage(), qo.getPageSize());
    }


	@Override
	public List<Department> list() {
		// TODO Auto-generated method stub
		return null;
	}
}
