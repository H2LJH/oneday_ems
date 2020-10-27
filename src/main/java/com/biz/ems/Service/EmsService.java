package com.biz.ems.Service;

import java.util.List;

import com.biz.ems.DTO.EmsVO;

public interface EmsService 
{
	public List<EmsVO> selectAll();
	public EmsVO findById(String id);
	
	public int insert(EmsVO vo);
	public int update(String id);
	public int delete(String id);
}
