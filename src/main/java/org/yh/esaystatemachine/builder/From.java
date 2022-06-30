package org.yh.esaystatemachine.builder;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname From
 * @description TODO 源状态 StateEnum
 * @date 2022/6/29 13:25
 */
public interface From<S, E, C> {

    /**
     * 设置状态跳转目的状态
     *
     * @param state 状态
     * @return To<S, E, C>
     */
    To<S, E, C> to(S state);
}
