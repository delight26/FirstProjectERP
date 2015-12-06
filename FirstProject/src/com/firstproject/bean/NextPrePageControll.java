package com.firstproject.bean;

public class NextPrePageControll {
private int nowPage;
private int nextPage;
private int prePage;

public NextPrePageControll(int nextPage, int prePage){
	this.nextPage = nextPage;
	this.prePage = prePage;
}

public int getNowPage() {
	return nowPage;
}
public void setNowPage(int nowPage) {
	this.nowPage = nowPage;
}
public int getNextPage() {
	return nextPage;
}
public void setNextPage(int nextPage) {
	this.nextPage = nextPage;
}
public int getPrePage() {
	return prePage;
}
public void setPrePage(int prePage) {
	this.prePage = prePage;
}


}
