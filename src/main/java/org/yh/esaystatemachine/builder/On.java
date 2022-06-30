package org.yh.esaystatemachine.builder;

import org.yh.esaystatemachine.Condition;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname On
 * @description TODO 事件 Event
 * @date 2022/6/29 13:26
 */
public interface On<S, E, C> extends When<S, E, C> {

    /**
     * 设置状态跳转中条件
     *
     * @param condition 条件
     * @return When<S, E, C>
     */
    When<S, E, C> when(Condition<C> condition);
}
