package org.yh.esaystatemachine.builder;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname ExternalTransitionBuilder
 * @description TODO 状态外部跳转
 * @date 2022/6/28 9:44
 */
public interface  ExternalTransitionBuilder<S ,E, C> {

    /**
     * 设置状态跳转中源状态
     *
     * @param state 状态
     * @return From<S, E, C>
     */
    From<S, E, C> from(S state);
}
