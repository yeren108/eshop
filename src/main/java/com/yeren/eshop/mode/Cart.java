package com.yeren.eshop.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "shopping_cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer shoppingCartId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "goods")
	private String goods;//格式：(goodsId,num)&    (1001,5)&(1002,3)&        某种商品买了多少个
	
	@Column(name = "clean")
	private Boolean clean;
	
	@Column(name = "payed")
	private Boolean payed;

	public Integer getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Boolean getClean() {
		return clean;
	}

	public void setClean(Boolean clean) {
		this.clean = clean;
	}

	public Boolean getPayed() {
		return payed;
	}

	public void setPayed(Boolean payed) {
		this.payed = payed;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
