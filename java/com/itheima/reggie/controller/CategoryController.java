package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author  分类管理
 * @Date 2024/5/30 12:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 新增分类
	 * @param category
	 * @return
	 */
	@PostMapping
	public R<String> save(@RequestBody Category category){
		log.info("category:{}",category);
		categoryService.save(category);
		return R.success("新增分类成功");
	}

	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/page")
	public R<Page> page(int page,int pageSize){
		Page<Category> pageInfo = new Page<>(page,pageSize);
		LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.orderByAsc(Category::getSort);
		categoryService.page(pageInfo,queryWrapper);
		return R.success(pageInfo);
	}

//	@GetMapping("/page")
//	public R page(Integer page,Integer pageSize){
//		Page<Category> categoryPage = new Page<>();
//		QueryWrapper<Category> wr = new QueryWrapper<>();
//		wr.orderByDesc("sort");
//		categoryService.page(categoryPage, wr);
//		return R.success(categoryPage);
//	}
}
