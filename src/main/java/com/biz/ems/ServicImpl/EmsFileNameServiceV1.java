package com.biz.ems.ServicImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ems.DAO.EmsFileNameDAO;
import com.biz.ems.DTO.EmsFileNameVO;
import com.biz.ems.Service.EmsFileNameService;

@Service("eFileServiceV1")
public class EmsFileNameServiceV1 implements EmsFileNameService 
{	
	@Autowired
	private EmsFileNameDAO efileDAO;
	
	@Override
	public List<EmsFileNameVO> findByDetail(String id) 
	{
		long seq = Long.valueOf(id);
		List<EmsFileNameVO> efile = efileDAO.findByDetail(seq);
		
		for(EmsFileNameVO one : efile)
			one.setS_file(one.getS_file().substring(36));
		
		return efile;
	}
	
	@Override
	public List<EmsFileNameVO> selectAll() {
		
		return efileDAO.selectAll();
	}

	@Override
	public EmsFileNameVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmsFileNameVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EmsFileNameVO id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
