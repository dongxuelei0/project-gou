package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import util.Result;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public List<TbBrand> findAll() {

		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult pageList(TbBrand brand,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		TbBrandExample tbBrandExample = new TbBrandExample();
		TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
		if(brand!=null){
			if(brand.getName()!=null && brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}


		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(tbBrandExample);
		return new PageResult(page.getTotal(),page.getResult());

	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
		redisTemplate.boundValueOps("brand").set(brand);
		Object brand1 = redisTemplate.boundValueOps("brand").get();
		System.out.println(brand1);

	}


}
