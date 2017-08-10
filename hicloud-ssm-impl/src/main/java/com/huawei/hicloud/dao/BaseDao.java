package com.huawei.hicloud.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * 增加
	 * @param entity
	 * @return
	 */
	public int add(T entity);
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 查找by id
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * 查询所有符合条件的记录
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 查找全部
	 * @return
	 */
	public List<T> findAll();
}
