package org.yh.esaystatemachine;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine
 * @classname Action
 * @description TODO
 * @date 2022/6/29 13:52
 */
public interface Action<S, E, C> {

    /**
     * 执行状态跳转
     *
     * @param from 源状态
     * @param to 目的状态
     * @param event 事件
     * @param context 上下文
     */
    void execute(S from, S to, E event, C context);
}
