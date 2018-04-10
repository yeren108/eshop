package com.yeren.seckill.service;

public interface RedisCache {
	public <T> boolean putCache(String key, T obj) throws Exception ;
	public <T> void putCacheWithExpireTime(String key, T obj, final long expireTime) throws Exception;
	public <T> T getCache(final String key) throws Exception;
}
