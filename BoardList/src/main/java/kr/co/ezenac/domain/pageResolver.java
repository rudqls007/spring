package kr.co.ezenac.domain;

public class pageResolver {

	private int totalCnt;				//게시물 중 갯수
	private int pageSize = 10;			//한 페이지당 게시물 갯수
	public final int NAV_SIZE = 10;		//page navigation size
	
	private int totalPage;				//전체 페이지 갯수
	private int	page;					//현재 페이지
	
	private int beginPage;				//화면에 보여줄 첫 페이지
	private int endPage;				//화면에 보여줄 마지막 페이지
	private boolean showNext = false;	//이 후를 보야줄 지 여부(endPage==totalPage 이면 showNext는 false)
	private boolean showPrev = false;	//이 전을 보여줄 지 여부(beginPage==1이 아니면 showPrev true)
	 
	
	public pageResolver(int totalCnt, Integer page) {
		this(totalCnt, page, 10);
	}
	
	public pageResolver(int totalCnt, Integer page, Integer pagesize) {
		this.totalCnt = totalCnt;
		this.page = page;
		this.pageSize = pageSize;
		
		this.totalPage = (int)Math.ceil(totalCnt / (double)pageSize);						// 전체 패이지 갯수
		this.beginPage = (page-1) / NAV_SIZE * NAV_SIZE +1;								// 첫 페이지 숫자
		this.endPage = Math.min(this.beginPage + this.NAV_SIZE -1, totalPage); 		
		this.showPrev = beginPage != 1;
		this.showNext = endPage != totalPage;
		
	}
	
	public void print() {
		System.out.println(" page = " + page);
		System.out.print(showPrev ? "PREV " : "");
		
		for(int i=beginPage; i<=endPage; i++) {
			System.out.print(i + " ");
			
		}
		
		System.out.println(showNext ? " NEXT" : "");
	}

	
	@Override
	public String toString() {
		return "pageResolver [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", NAV_SIZE=" + NAV_SIZE
				+ ", totalPage=" + totalPage + ", page=" + page + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ ", showNext=" + showNext + ", showPrev=" + showPrev + "]";
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public int getNAV_SIZE() {
		return NAV_SIZE;
	}
		
	
}
