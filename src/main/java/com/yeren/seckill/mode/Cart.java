package com.yeren.seckill.mode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shopping_cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer shoppingCartId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "goods")
	private String goods;//鏍煎紡锛�(goodsId,num)&    (1001,5)&(1002,3)&        鏌愮鍟嗗搧涔颁簡澶氬皯涓�
	
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

	@Override
	public String toString() {
		return "Cart [shoppingCartId=" + shoppingCartId + ", userId=" + userId + ", goods=" + goods + ", clean=" + clean
				+ ", payed=" + payed + "]";
	}
}
