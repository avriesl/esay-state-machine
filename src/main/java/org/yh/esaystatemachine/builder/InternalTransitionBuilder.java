package org.yh.esaystatemachine.builder;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname InternalTransitionBuilder
 * @description TODO 状态内部跳转
 * @date 2022/6/28 9:45
 */
public interface InternalTransitionBuilder<S, E, C> {

    /**
     * 设置状态跳转时的内部状态
     *
     * @param state 状态
     * @return To<S, E, C>
     */
    To<S, E, C> within(S state);

}
