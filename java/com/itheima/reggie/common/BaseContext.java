package com.itheima.reggie.common;

/**
 * @Author 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 * @Date 2024/5/30 11:37
 * @Version 1.0
 */
public class BaseContext {
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();


	/**
	 * 设置值6
	 * @param id
	 */
	public static void setCurentId(Long id){
		threadLocal.set(id);
	}


	/**
	 * 获取值
	 * @return
	 */
	public static Long getCurrentId(){
		return threadLocal.get();
	}
}
