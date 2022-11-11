package kr.co.heart.domain;

import org.springframework.web.util.UriComponentsBuilder;
import static java.util.Objects.requireNonNullElse;
import static java.lang.Math.*;

public class SearchItem {

	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int MIN_PAGE_SIZE = 5;
	public static final int MAX_PAGE_SIZE = 50;
	
	private Integer page = 1;
	private Integer pageSize = DEFAULT_PAGE_SIZE;
	private String option = "";
	private String keyword = "";
	private Integer offset;
	
	public SearchItem() {
		// TODO Auto-generated constructor stub
	}
	
	public SearchItem(Integer page, Integer pageSize) {
		this(page, pageSize, "", "");
	}

	public SearchItem(Integer page, Integer pageSize, String option, String keyword
//			Integer offset
			) {
//		super();
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
	}

	public String getQueryString() {
		return getQueryString(page);			// 밑에 있는 메서드 불러온다.
	}
	
	// uri 다음 ?page=10&pageSize=10&option=A&keyword=title
	public String getQueryString(Integer page) {
		return UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("pageSize", pageSize)
				.queryParam("option", option)
				.queryParam("keyword", keyword)
				.build().toString();
	}

	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = requireNonNullElse(pageSize, DEFAULT_PAGE_SIZE);		//	pageSize가 정의 되어 있지 않다면 기본 페이지 사이즈로 정의한다.
	
		// MIN_PAGE_SIZE <= pageSize <= MAX_PAGE_SIZE
		this.pageSize = max(MIN_PAGE_SIZE, min(this.pageSize, MAX_PAGE_SIZE) );
	}


	public String getOption() {
		return option;
	}


	public void setOption(String option) {
		this.option = option;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public Integer getOffset() {
		return (page-1)*pageSize;
	}

//
//	public void setOffset(Integer offset) {
//		this.offset = offset;
//	}


	@Override
	public String toString() {
		return "SerachItem [page=" + page + ", pageSize=" + pageSize + ", option=" + option + ", keyword=" + keyword
				+ ", offset=" + offset + "]";
	}
	
	
	
}
