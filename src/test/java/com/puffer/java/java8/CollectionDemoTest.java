package com.puffer.java.java8;

import com.puffer.java.common.User;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class CollectionDemoTest {

    @Test
    public void testListToGroupMap() {
        int size = 17;

        List<User> users = User.newList(size);
        Map<String, List<User>> stringListMap = CollectionDemo.listToGroupMap(users);
        System.out.println(stringListMap);

    }

    @Test
    public void sort() {
        int size = 17;
        List<User> users = User.newList(size);

        System.out.println(users);
        users.forEach(System.out::println);
        List<Integer> userIds = users.stream().map(User::getId).sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        System.out.println(userIds);
    }

    @Test
    public void testMultipleListToGroupMap() {
    }

    @Test
    public void testListToMap() {
    }

    @Test
    public void testListId() {
    }

    @Test
    public void testFilterList() {
    }

    @Test
    public void testRemoveDuplicate1() {
    }

    @Test
    public void testRemoveDuplicate2() {
    }

    @Test
    public void testForList() {
    }
}