package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.entity.PageResult;
import util.Result;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {
	/**
	 * cha
	 * @return
	 */
	public List<TbBrand> findAll();

	/**
	 * 分页
	 * @param pageNum
	 * @param pagesize
	 * @return
	 */
	public PageResult pageList(TbBrand brand,int pageNum,int pagesize);

	/**
	 * add
	 * @param brand
	 * @return
	 */
	public void add(TbBrand brand);
	
}
