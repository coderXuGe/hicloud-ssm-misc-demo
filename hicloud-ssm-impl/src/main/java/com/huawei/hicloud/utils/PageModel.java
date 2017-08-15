package com.huawei.hicloud.utils;

/**
 * Page Model
 * 
 * @author dell
 *
 * @param <T>
 */
public class PageModel {

	/* 分页参数,需确定后计算其它值 */
	// 数据总数
	private int totalRecords;
	// 每页数据数目
	private int pageSize;
	// 当前页码
	private int pageNumber;

	// 记录起始值
	private int startIndex;
	// 记录结束值
	private int endIndex;
	// 上一页
	private int prevPageNumber;
	// 下一页
	private int nextPageNumber;
	// 总页数
	private int totalPageNumber;

	// 起始页码
	private int startPage;
	// 结束页码
	private int endPage;

	public PageModel() {
		super();
	}

	public PageModel(int totalRecords, int pageSize, int pageNumber) {
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		this.pageNumber = pageNumber;

		// 计算分页参数的其他属性
		// > 计算记录起始/结束值
		startIndex = (pageNumber - 1) * pageSize;
		endIndex = pageNumber * pageSize - 1;
		// 总页数
		totalPageNumber = (totalRecords % pageSize == 0) ? (totalRecords / pageSize) : (totalRecords / pageSize + 1);
		// 计算上一页
		if (pageNumber == 1) {
			prevPageNumber = 1;
		} else {
			prevPageNumber = pageNumber - 1;
		}
		// 计算下一页
		if (pageNumber >= totalPageNumber) {
			nextPageNumber = totalPageNumber;
		} else {
			nextPageNumber = pageNumber + 1;
		}

		// 计算起始页码和结束 页码
		startPage = pageNumber - 4; //
		endPage = pageNumber + 4; //
		// 看看总页数够不够9页
		if (totalPageNumber > 9) {
			// 超过了9页
			if (startPage < 1) {
				startPage = 1;
				endPage = startPage + 8;
			}
			if (endPage > totalPageNumber) {
				endPage = totalPageNumber;
				startPage = endPage - 8;
			}
		} else {
			// 不够9页
			startPage = 1;
			endPage = totalPageNumber;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getPrevPageNumber() {
		return prevPageNumber;
	}

	public void setPrevPageNumber(int prevPageNumber) {
		this.prevPageNumber = prevPageNumber;
	}

	public int getNextPageNumber() {
		return nextPageNumber;
	}

	public void setNextPageNumber(int nextPageNumber) {
		this.nextPageNumber = nextPageNumber;
	}

	public int getTotalPageNumber() {
		return totalPageNumber;
	}

	public void setTotalPageNumber(int totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageModel [totalRecords=" + totalRecords + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber
				+ ", startIndex=" + startIndex + ", endIndex=" + endIndex + ", prevPageNumber=" + prevPageNumber
				+ ", nextPageNumber=" + nextPageNumber + ", totalPageNumber=" + totalPageNumber + ", startPage="
				+ startPage + ", endPage=" + endPage + "]";
	}

}
