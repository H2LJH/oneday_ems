package com.biz.ems.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService 
{
	public String[] save(List<MultipartFile> files);
}
