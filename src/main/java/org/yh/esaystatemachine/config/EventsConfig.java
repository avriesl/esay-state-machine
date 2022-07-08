package org.yh.esaystatemachine.config;

import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.builder.StateMachineBuilder;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.config
 * @classname EventsConfig
 * @description TODO 事件配置
 * @date 2022/7/8 8:25
 */
public interface EventsConfig<S, E, C> {

    /**
     * 事件条件
     * @return Condition<C>
     */
    Condition<C> condition();

    /**
     * 事件动作
     * @return Action<S, E, C>
     */
    Action<S, E, C> action();

    /**
     * 事件监控
     * @return Monitor<S, E, C>
     */
    Monitor<S, E, C> monitor();

    /**
     * 事件构建
     * @param builder 状态机builder
     */
    void build(StateMachineBuilder<S, E, C> builder);

}
