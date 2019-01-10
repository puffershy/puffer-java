package com.puffer.java.util;

/**
 * 分表工具
 *
 * @author buyi
 * @date 2019年01月10日 10:18:36
 * @since 1.0.0
 */
public class SegmentUtil {

    /**
     * 默认分表数量值
     */
    private final static Integer SHARD_DB_COUNT = 4;

    /**
     * 计算数据源
     *
     * @param value 计算数据源值
     * @return 数据源
     * @author liangqm
     * @date 2019/1/9 15:55
     * @since v1.0.0
     */
    public static Integer calculationSegment(String value) {
        String hashCode = String.valueOf(value.hashCode());
        Long segment = Math.abs(Long.parseLong(hashCode)) % SHARD_DB_COUNT;
        return segment.intValue();
    }
}
