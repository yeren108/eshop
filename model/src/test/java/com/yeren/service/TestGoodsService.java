package com.yeren.service;

import com.yeren.seckill.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yeren.seckill.mode.Goods;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class TestGoodsService {
	
	@Autowired
	GoodsService goodsService;
	
	@Test
	public void testSave() {
		Goods goods=new Goods();
		goods.setGoodsName("iphonex");
		goods.setGoodsNumber(100);
		goods.setGoodsPrice(8000.00);
		boolean save = goodsService.save(goods);
		System.out.println("保存商品結果："+save);
	}
	
	@Test
	public void testFindById() {
		Goods goods = goodsService.findById(1);
		System.out.println("商品名称:"+goods.getGoodsName());
	}
	
	@Test
	public void testUpdate() {
		Goods goods = goodsService.findById(1);
		goods.setGoodsNumber(99);
		boolean update = goodsService.update(goods);
		System.out.println("更新是否完成:"+update);
		
	}
	
	@Test
	public void testDelete() {
		boolean delete = goodsService.delete(1);
		System.out.println("删除:"+delete);
		
	}
}
