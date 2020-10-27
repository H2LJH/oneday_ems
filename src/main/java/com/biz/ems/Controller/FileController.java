package com.biz.ems.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.DTO.EmsVO;
import com.biz.ems.Service.EmsService;
import com.biz.ems.Service.FileService;

@RequestMapping("/file")
@Controller
public class FileController 
{
	@Autowired
	@Qualifier("fileServiceV1")
	private FileService fileService;
	
	@Autowired
	private EmsService emsService;
	
	@RequestMapping(value={"/save", "/save/"}, method=RequestMethod.POST)
	public void save(EmsVO emsVO, @RequestPart List<MultipartFile> files)
	{
		 String[] strUUIDfileName = fileService.save(files); 
			/*
			 * emsVO.setS_file1("1"); emsVO.setS_file2("1");
			 */
		 emsService.insert(emsVO);
	}
}
