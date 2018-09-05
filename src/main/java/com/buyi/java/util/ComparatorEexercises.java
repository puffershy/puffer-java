package com.buyi.java.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.buyi.java.common.User;

/**
 * 排序练习
 * 
 * @author buyi
 * @date 2018年5月22日下午10:12:01
 * @since 1.0.0
 */
public class ComparatorEexercises {

	public static void normalSort(List<User> users) {
		List<User> list = users.stream().sorted(Comparator.comparingInt(User::getId)).collect(Collectors.toList());
	}
}
