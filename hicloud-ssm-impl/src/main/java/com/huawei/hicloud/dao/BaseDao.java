package com.huawei.hicloud.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huawei.hicloud.utils.PageModel;

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
	 * 查询所有符合条件的记录
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 查找by id
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * 查找表中全部数据(没有条件)
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 分页查找
	 * @param entity
	 * @param pageModel
	 * @return
	 */
	public List<T> findByPage(@Param("0") T entity, @Param("1") PageModel pageModel);
	
}
