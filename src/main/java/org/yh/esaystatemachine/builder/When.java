package org.yh.esaystatemachine.builder;

import org.yh.esaystatemachine.Monitor;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname When
 * @description TODO 条件 Condition
 * @date 2022/6/29 13:27
 */
public interface When<S ,E, C> extends Listen<S, E, C> {

    /**
     * 设置状态跳转中监控
     *
     * @param monitor 监听器
     * @return Listen<S, E, C>
     */
    Listen<S, E, C> listen(Monitor<S, E, C> monitor);

}
