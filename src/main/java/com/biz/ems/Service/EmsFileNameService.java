package com.biz.ems.Service;

import java.util.List;

import com.biz.ems.DTO.EmsFileNameVO;

public interface EmsFileNameService extends GenericService<EmsFileNameVO, String> 
{

	public List<EmsFileNameVO> findByDetail(String id);
}
