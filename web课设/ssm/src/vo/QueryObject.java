package vo;




public class QueryObject {
    private int currentPage = 1;
    private int pageSize = 5;

    public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex(){
        return pageSize * (currentPage - 1);
    }
}
