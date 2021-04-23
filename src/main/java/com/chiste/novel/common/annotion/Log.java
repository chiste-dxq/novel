package com.chiste.novel.common.annotion;

import com.chiste.novel.common.enums.BusinessType;

import java.lang.annotation.*;

/*
 * @Author: daixq
 * @Date: 2021/4/2 14:36
 * @Description:
 **/
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
	/**
	 * 模块
	 */
	public String title() default "";

	/**
	 * 功能
	 */
	public BusinessType businessType() default BusinessType.OTHER;
}
