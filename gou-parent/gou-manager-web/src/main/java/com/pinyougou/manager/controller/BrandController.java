package com.pinyougou.manager.controller;

import java.util.List;

import com.pinyougou.pojo.entity.PageResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import util.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();		
	}

	@RequestMapping("/findPage")
	public PageResult findPage( int pageNum, int pagesize){
		return  brandService.pageList(null,pageNum,pagesize);

	}

	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand){
		brandService.add(brand);
		return new Result(true,"成功");
	}
}
