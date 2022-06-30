package org.yh.esaystatemachine.builder;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname To
 * @description TODO 目的状态 StateEnum
 * @date 2022/6/29 13:25
 */
public interface To<S, E, C> {

    /**
     * 设置状态跳转事件
     *
     * @param event 事件
     * @return On<S, E, C>
     */
    On<S, E, C> on(E event);
}
