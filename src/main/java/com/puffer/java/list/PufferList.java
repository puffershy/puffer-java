package com.puffer.java.list;

import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.testng.collections.Lists;

import java.awt.*;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义List，学会List扩展
 *
 * @author buyi
 * @date 2018年12月26日 09:33:35
 * @since 1.0.0
 */
public class PufferList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //存储信息不序列化
    transient Object[] elementData;

    private int size = 0;

    public PufferList() {
        this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }

    /**
     * 新增元素
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULT_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        //修改操作+1

        if (minCapacity - elementData.length > 0) {
            //如果最小容量大于当前容量，则增加容量
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity < 0) {
            //如果新的容量小于传参的最小容量
            newCapacity = minCapacity;
        }

        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 计算大容量
     *
     * @param minCapacity
     * @return
     */
    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }

        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    public E set(int index, E e) {
        //检查位标
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = e;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size:" + size;
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    public E remove(int index) {
        rangeCheck(index);

        //修改次数+1
        E oldValue = elementData(index);

        //需要移动的数量
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            //复制值
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null;

        return oldValue;
    }

    public int size() {
        return size;
    }
}
