package com.biz.ems.ServicImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.Service.FileService;

@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService
{
	public String[] save(List<MultipartFile> files)
	{
		
		File saveFile;
		String[] arrNames = new String[files.size()];
		String rootPath = "C:/workspace/upload";
		int index = 0;
		
		File dir = new File(rootPath);
		
		if(!dir.exists()) 
			dir.mkdirs(); 
		
		if(files.get(index).getSize() != 0)
		{
			for(MultipartFile one : files)
			{
				arrNames[index] = one.getOriginalFilename();
				arrNames[index] = UUID.randomUUID() + one.getOriginalFilename();
				saveFile = new File(rootPath, arrNames[index]);
				try { one.transferTo(saveFile); } 
				catch (IllegalStateException | IOException e)  { e.printStackTrace(); }
				index++;
			}
		}
		
		return arrNames;
	}
	
}
