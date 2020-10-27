package com.biz.ems.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.DTO.EmsVO;

public interface EmsService extends GenericService<EmsVO, String>
{
	public int flag(EmsVO vo , List<MultipartFile> files, int flag);
	public int selected_delete(String[] pk);
}
