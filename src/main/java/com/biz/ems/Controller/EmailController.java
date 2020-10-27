package com.biz.ems.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;import com.biz.ems.DAO.EmsFileNameDAO;
import com.biz.ems.DTO.EmsFileNameVO;
import com.biz.ems.Service.EmsFileNameService;
import com.biz.ems.Service.EmsService;

@RequestMapping("/email")
@Controller
public class EmailController 
{
	@Qualifier("EmsServiceV1")
	@Autowired
	private EmsService emsService;
	
	@Qualifier("eFileServiceV1")
	@Autowired
	private EmsFileNameService efileService;
	
	@RequestMapping(value= {"/send", "/send/"}, method = RequestMethod.GET)
	public String sendList(Model model)
	{
		model.addAttribute("BODY", "SEND_HOME");
		model.addAttribute("SEND_LIST", emsService.selectAll());
		return "home";
	}
	
	@RequestMapping(value= {"/detail", "/detail/{id}"}, method=RequestMethod.GET)
	public String detail(Model model, @PathVariable("id") String id)
	{	
		model.addAttribute("BODY", "DETAIL_HOME");
		model.addAttribute("DETAIL", emsService.findById(id));
		model.addAttribute("DETAIL_FILENAME", efileService.findByDetail(id));
		return "home";
	}
}
