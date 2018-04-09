package com.yeren.seckill.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name="username")
	private String userName;//用户名

	@Column(name="password")
	private String password;//密码

	@Column(name="mobile")
	private String mobile;//手机号，下订单要用

	@Column(name="address")//地址，下订单要用
	private String address;
	
	@Column(name="login")//是否在线，用与模拟用户在线行为   1表示在线    0表示下线
	private Integer login;
	
	@Column(name="seckill")//是否参与秒杀，用于模拟用户行为，自动秒杀    1表示参与秒杀    0表示不参与秒杀
	private Integer seckill;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	public Integer getSeckill() {
		return seckill;
	}

	public void setSeckill(Integer seckill) {
		this.seckill = seckill;
	}

	
	

}
