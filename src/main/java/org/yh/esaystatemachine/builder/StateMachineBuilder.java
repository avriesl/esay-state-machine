package org.yh.esaystatemachine.builder;

import org.yh.esaystatemachine.StateMachine;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname StateMachineBuilder
 * @description TODO 状态机builder
 *                   S -> StateEnum, E -> EventEnum, C -> Context
 * @date 2022/6/28 9:41
 */
public interface StateMachineBuilder<S, E, C> {

    /**
     * 外部跳转
     * @return ExternalTransitionBuilder<S, E, C>
     */
    ExternalTransitionBuilder<S, E, C> externalTransition();

    /**
     * 多状态外部跳转
     * @return ExternalTransitionsBuilder<S, E, C>
     */
    ExternalTransitionsBuilder<S, E, C> externalTransitions();

    /**
     * 内部跳转
     * @return InternalTransitionBuilder<S, E, C>
     */
    InternalTransitionBuilder<S, E, C> internalTransition();

    /**
     * 构建状态机
     *
     * @param machineId 机器id
     * @return StateMachine<S, E, C>
     */
    StateMachine<S, E, C> build(String machineId);
}
