package com.biz.ems.DAO;

import java.util.List;

import com.biz.ems.DTO.EmsVO;

public interface EmsDAO 
{
	public List<EmsVO> selectAll();
	public EmsVO findById(String id);
	
	public int insert(EmsVO vo);
	public int update(String id);
	public int delete(String id);
}
