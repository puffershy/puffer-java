package com.puffer.java.util;

/**
 * @author buyi
 * @date 2019年01月10日 11:06:22
 * @since
 */
public final class Pair<F, S> {
    private F first;
    private S second;

    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static <F, S> Pair<F, S> of(F first, S second) {
        return new Pair(first, second);
    }

    public F first() {
        return this.first;
    }

    public S second() {
        return this.second;
    }
}
