package org.yh.esaystatemachine.builder;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname ExternalTransitionsBuilder
 * @description TODO 多状态外部跳转
 * @date 2022/6/28 9:51
 */
public interface ExternalTransitionsBuilder<S, E, C> {

    /**
     * 设置状态跳转中源状态集
     *
     * @param states 状态集
     * @return From<S, E, C>
     */
    From<S, E, C> fromAmong(S... states);

}
