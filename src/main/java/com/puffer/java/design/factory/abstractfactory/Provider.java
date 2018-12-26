package com.puffer.java.design.factory.abstractfactory;

import com.puffer.java.design.factory.Sender;

/**
 * 抽象工厂好处就是，如果你现在想增加一个功能：发及时信息，
 * 则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
 *
 * @author buyi
 * @date 2018年12月26日 17:30:14
 * @since 1.0.0
 */
public interface Provider {
    Sender produce();
}
