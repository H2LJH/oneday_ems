package com.biz.ems.ServicImpl;

import java.util.List;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ems.DAO.EmsDAO;
import com.biz.ems.DTO.EmsVO;
import com.biz.ems.Service.DateService;
import com.biz.ems.Service.EmsService;

@Service("EmsServiceV1")
public class EmsServiceV1 implements EmsService 
{
	@Autowired
	EmsDAO emsDAO;
	
	@Autowired
	DateService DateService;

	@Override
	public List<EmsVO> selectAll() 
	{
		return emsDAO.selectAll();
	}

	@Override
	public EmsVO findById(String id) 
	{
		return emsDAO.findById(id);
	}

	@Override
	public int insert(EmsVO vo) 
	{
		vo.setS_date(DateService.dateTime()[0]);
		vo.setS_time(DateService.dateTime()[1]);
		emsDAO.insert(vo);
		return 0; 
	}

	@Override
	public int update(String id) {
		return emsDAO.update(id);
	}

	@Override
	public int delete(String id) 
	{
		return emsDAO.delete(id);
	}

}
