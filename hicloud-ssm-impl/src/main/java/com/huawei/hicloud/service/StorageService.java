package com.huawei.hicloud.service;

import java.io.Serializable;
import java.util.List;

import com.huawei.hicloud.pojo.Volume;
import com.huawei.hicloud.utils.PageModel;

public interface StorageService {
	
	public int add(Volume volume);
	
	public int delete(Volume volume);
	
	public int update(Volume volume);
	
	public Volume findById(Serializable id);
	
	/** 查询所有符合条件的记录 */
	public List<Volume> findList(Volume volume);
	
	/** 查询所有 */
	public List<Volume> findAll();

	public List<Volume> findByPage(Volume volume, PageModel pageModel);
}
