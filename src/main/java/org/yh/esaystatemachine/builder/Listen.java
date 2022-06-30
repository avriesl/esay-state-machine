package org.yh.esaystatemachine.builder;

import org.yh.esaystatemachine.Action;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname Listen
 * @description TODO 监听
 * @date 2022/6/29 13:43
 */
public interface Listen<S, E, C> {

    /**
     * 设置状态跳转需执行的动作
     *
     * @param action 动作
     */
    void perform(Action<S, E,C > action);
}
