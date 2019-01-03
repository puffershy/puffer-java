package com.puffer.java.common;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.RandomUtils;
import org.testng.collections.Lists;

import java.util.List;
import java.util.Random;

@Data
@Builder
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer sex;
    private String phone;

    public static List<User> newList(int size) {
        List<User> list = Lists.newArrayList();
        for (int i = 0; i < size; i++) {

            User user = User.builder().id(RandomUtils.nextInt(1, 9) + 1).name("P" + i).sex((i + 1) % 2).build();
            list.add(user);
        }

        return list;
    }

}
