package com.biz.ems.ServicImpl;

import java.util.List;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.biz.ems.DAO.EmsDAO;
import com.biz.ems.DAO.EmsFileNameDAO;
import com.biz.ems.DTO.EmsFileNameVO;
import com.biz.ems.DTO.EmsVO;
import com.biz.ems.Service.DateService;
import com.biz.ems.Service.EmsService;
import com.biz.ems.Service.FileService;

@Service("EmsServiceV1")
public class EmsServiceV1 implements EmsService 
{
	@Autowired
	private EmsDAO emsDAO;
	
	@Autowired
	private EmsFileNameDAO efileDAO;
	
	@Autowired
	private DateService DateService;

	@Autowired
	private FileService fileService;
	
	@Override
	public List<EmsVO> selectAll() 
	{
		return emsDAO.selectAll();
	}

	@Override
	public EmsVO findById(String id) 
	{
		long pk = Long.valueOf(id);
		return emsDAO.findById(pk);
	}
	
	@Override
	public int insert(EmsVO vo) 
	{
		vo.setS_date(DateService.dateTime()[0]);
		vo.setS_time(DateService.dateTime()[1]);
		int ret = emsDAO.insert(vo);
		return ret; 
	}

	@Override
	public int update(EmsVO vo) {
		return emsDAO.update(vo);
	}
	
	@Override
	public int delete(String id) 
	{
		long pk = Long.valueOf(id);
		return emsDAO.delete(pk);
	}

	@Override
	public int selected_delete(String[] pk) 
	{ 
		Long[] seqNum = new Long[pk.length];
		for(int i=0; i<pk.length; ++i)
		{
			seqNum[i] = Long.valueOf(pk[i]);
			emsDAO.delete(seqNum[i]);
			efileDAO.delete(seqNum[i]);
		}			
		return 0;
	}

	@Override
	public int flag(EmsVO vo, List<MultipartFile> files, int flag) 
	{
		String[] strUUIDfileName = fileService.save(files);	
		vo.setS_date(DateService.dateTime()[0]);
		vo.setS_time(DateService.dateTime()[1]);
		int ret = 0;
		
		switch (flag) 
		{
			case 0:
				ret = emsDAO.insert(vo);
				break;
	
			case 1:
				ret = emsDAO.update(vo);
				break;
		}
		
		if(strUUIDfileName[0] != null)
		{
			for(String one : strUUIDfileName)
			{
				EmsFileNameVO fvo = new EmsFileNameVO();
				fvo.setS_id(vo.getId());
				fvo.setS_file(one);
				efileDAO.insert(fvo);
			}
		}
		return ret;
	}





}
