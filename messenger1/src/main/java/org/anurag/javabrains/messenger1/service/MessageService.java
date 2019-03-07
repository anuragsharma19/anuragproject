package org.anurag.javabrains.messenger1.service;

import java.util.ArrayList;
import java.util.List;

import org.anurag.javabrains.messenger1.model.message;


public class MessageService {
	
	public List<message> getAllMessage()
	{
		message m1=new message(1L,"Hello world","Anurag");
		message m2=new message(2L,"Hello Jersy","Avinash");
		List<message> list=new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
		
	}

}
