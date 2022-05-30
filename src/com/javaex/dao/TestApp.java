package com.javaex.dao;

import java.util.List;

import com.javaex.vo.GuestVo;

public class TestApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		GuestVo guestVo = new GuestVo();
		List<GuestVo> guestList = bookDao.getGuestList();
		
		System.out.println(guestList.get(15).getRegDate());
		System.out.println(bookDao.getGuestList());
	}

}
