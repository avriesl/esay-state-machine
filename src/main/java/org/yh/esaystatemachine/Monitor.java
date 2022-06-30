package org.yh.esaystatemachine;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname Monitor
 * @description TODO 监控
 * @date 2022/6/29 13:48
 */
public interface Monitor<S, E, C> {

    /**
     * 监控
     *
     * @param from 源状态
     * @param to 目的状态
     * @param event 事件
     * @param context 上下文
     */
    void monitor(S from, S to, E event, C context);

}
