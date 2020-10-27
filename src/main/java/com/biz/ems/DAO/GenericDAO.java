package com.biz.ems.DAO;

import java.util.List;

import com.biz.ems.DTO.EmsVO;

public interface GenericDAO<VO, PK>
{
	public List<VO> selectAll();
	public VO findById(PK id);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
}
