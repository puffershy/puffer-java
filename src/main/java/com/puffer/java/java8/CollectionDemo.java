package com.puffer.java.java8;

import com.puffer.java.common.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 集合类demo
 *
 * @author buyi
 * @date 2018年12月25日 15:09:07
 * @since 1.0.0
 */
public class CollectionDemo {

    /**
     * 按某个属性分组，将相同的放在一起
     *
     * @param users
     * @author buyi
     * @date 2018年12月25日 15:10:33
     * @since 1.0.0
     */
    public static  Map<String, List<User>> listToGroupMap(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getName));
    }

    /**
     * 多重分组
     *
     * @param users
     * @return java.util.Map<java.lang.Integer                               ,                               java.util.Map                               <                               java.lang.String                               ,                               java.util.List                               <                               com.puffer.java.common.User>>>
     * @author buyi
     * @date 2018年12月25日 15:40:18
     * @since 1.0.0
     */
    public static  Map<Integer, Map<String, List<User>>> multipleListToGroupMap(List<User> users) {
        //按照性别，再按照姓名多重分组
        return users.stream().collect(Collectors.groupingBy(User::getSex, Collectors.groupingBy(User::getName)));
    }

    /**
     * 提取实体某个属性，以该属性为key构建map
     *
     * @param users
     * @author buyi
     * @date 2018年12月25日 15:18:49
     * @since 1.0.0
     */
    public static  Map<Integer, User> listToMap(List<User> users) {
        return users.stream().collect(Collectors.toMap(User::getId, user -> user));
    }

    /**
     * 提取属性列表
     *
     * @param users
     * @return java.util.List<java.lang.Integer>
     * @author buyi
     * @date 2018年12月25日 15:30:20
     * @since 1.0.0
     */
    public static  List<Integer> listId(List<User> users) {
        return users.stream().map(User::getId).collect(Collectors.toList());
    }

    /**
     * 更具指定的过滤关键字，过滤列表
     *
     * @param users
     * @param filterName
     * @return java.util.List<com.puffer.java.common.User>
     * @author buyi
     * @date 2018年12月25日 15:21:22
     * @since 1.0.0
     */
    public static  List<User> filterList(List<User> users, String filterName) {
        return users.stream().filter(user -> user.getName().equals(filterName)).collect(Collectors.toList());
    }

    /**
     * 去重
     *
     * @param users
     * @return java.util.List<com.puffer.java.common.User>
     * @author buyi
     * @date 2018年12月25日 15:27:43
     * @since 1.0.0
     */
    public static  List<User> removeDuplicate1(List<User> users) {
        return users.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(User::getId))), ArrayList::new));
    }

    /**
     * 去重
     *
     * @param users
     * @return java.util.List<com.puffer.java.common.User>
     * @author buyi
     * @date 2018年12月25日 15:33:32
     * @since 1.0.0
     */
    public static  List<User> removeDuplicate2(List<User> users) {
        return users.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 列表for循环
     *
     * @param users
     * @return void
     * @author buyi
     * @date 2018年12月25日 15:32:11
     * @since 1.0.0
     */
    public static  void forList(List<User> users) {
        users.forEach(user -> {
            System.out.println(user.getName());
        });
    }
}
