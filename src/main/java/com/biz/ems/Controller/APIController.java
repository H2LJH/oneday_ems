package com.biz.ems.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.DTO.EmsVO;
import com.biz.ems.Service.EmsService;

@RequestMapping("/api")
@Controller
public class APIController 
{
	
	@Autowired
	private EmsService emsService;
	
	@ResponseBody
	@RequestMapping(value={"/insert", "/insert/"}, method=RequestMethod.POST)
	public boolean insert(EmsVO emsVO, @RequestPart List<MultipartFile> files)
	{				
		if(emsService.flag(emsVO, files, 0) >= 1)
			return true;
		
		return false;
	}
	
	
	@ResponseBody
	@RequestMapping(value= {"/detail/delete", "/detail/delete/"}, method=RequestMethod.POST)
	public void delete(@RequestParam("id") String id)
	{
		emsService.delete(id);
	}
	
	
	@ResponseBody
	@RequestMapping(value= {"/send/delete", "/send/delete/"}, method=RequestMethod.POST)
	public void delete(@RequestParam String delete_seq[])
	{
		System.out.println(delete_seq.length);
		emsService.selected_delete(delete_seq);
	}
	
	@ResponseBody
	@RequestMapping(value= {"/update", "/update/"}, method=RequestMethod.POST)
	public boolean update(EmsVO emsVO, @RequestPart List<MultipartFile> files)
	{
		  if(emsService.flag(emsVO, files, 1) >= 1) 
			  return true;
		  		  
		  return false;
	}
}
