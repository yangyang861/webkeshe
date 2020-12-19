package vo;


import java.util.Collections;
import java.util.List;

//分页封装对象

public class PageResult {
    public static PageResult getEmptyPageResult() {
		return EMPTY_PAGE_RESULT;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public List<?> getList() {
		return list;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	//空分页对象
    public static final PageResult EMPTY_PAGE_RESULT =
                new PageResult(Collections.emptyList(), 0, 1, 3);

    //页面传入
    private int currentPage;
    private int pageSize;

    //sql查询
    private int totalCount;
    private List<?> list;

    //计算
    private int prevPage; //上一页
    private int nextPage; //下一页
    private int totalPage; //总页数


    public PageResult(List<?> list, int totalCount, int currentPage, int pageSize){
        this.list = list;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        if(totalCount <= pageSize){
            this.prevPage = 1;
            this.nextPage = 1;
            this.totalPage = 1;
            return;
        }

        this.totalPage = totalCount % pageSize == 0 ?
                    totalCount / pageSize : totalCount / pageSize + 1;

        this.prevPage = currentPage - 1 > 0 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;

    }
}
