package com.biz.ems.Service;

import java.util.List;

import com.biz.ems.DTO.EmsVO;

public interface GenericService<VO, PK>
{
	public List<VO> selectAll();
	public VO findById(PK id);
	public int insert(VO vo);
	public int update(VO id);
	public int delete(PK id);
}
