package com.huawei.hicloud.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.hicloud.dao.VolumeDao;
import com.huawei.hicloud.pojo.Volume;
import com.huawei.hicloud.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService{
	@Autowired
	private VolumeDao volumeDao;

	@Override
	public int add(Volume volume) {
		return volumeDao.add(volume);
	}

	@Override
	public int delete(Volume volume) {
		return volumeDao.delete(volume);
	}

	@Override
	public int update(Volume volume) {
		return volumeDao.update(volume);
	}

	@Override
	public Volume findById(Serializable id) {
		return volumeDao.findById(id);
	}

	@Override
	public List<Volume> findList(Volume volume) {
		return volumeDao.findList(volume);
	}
	
	/** 分页查询 */
	@Override
	public List<Volume> findPageList(Volume volume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Volume> findAll() {
		return volumeDao.findAll();
	}
	
}
