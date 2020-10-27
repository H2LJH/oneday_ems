package com.biz.ems.ServicImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.biz.ems.Service.DateService;

@Component("DateServiceV1")
public class DateServiceV1 implements DateService 
{
	@Override
	public String[] dateTime() 
	{
		LocalDateTime lDateTime = LocalDateTime.now();
		String strDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(lDateTime);
		String str_Time = DateTimeFormatter.ofPattern("HH:mm:SS").format(lDateTime);
		String[] arrDate = new String[] {strDate, str_Time};
		return arrDate;
	}
}
