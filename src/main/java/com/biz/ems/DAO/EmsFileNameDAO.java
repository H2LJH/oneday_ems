package com.biz.ems.DAO;


import java.util.List;

import com.biz.ems.DTO.EmsFileNameVO;

public interface EmsFileNameDAO extends GenericDAO<EmsFileNameVO, Long>
{
	public List<EmsFileNameVO> findByDetail(Long id);
}
