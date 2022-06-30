package org.yh.esaystatemachine.builder;

import java.util.Map;
import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.Impl.StateHelper;
import org.yh.esaystatemachine.Impl.TransitionType;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.State;
import org.yh.esaystatemachine.Transition;
import org.yh.esaystatemachine.exception.StateMachineException;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname TransitionBuilderImpl
 * @description TODO 状态跳转实现
 * @date 2022/6/29 13:58
 */
public class TransitionBuilderImpl<S, E, C> implements ExternalTransitionBuilder<S, E, C>, InternalTransitionBuilder<S, E, C>,
        From<S, E, C>, On<S, E, C>, To<S, E, C> {

    /**
     * 状态集
     */
    protected final Map<S, State<S, E, C>> stateMap;
    /**
     * 源状态
     */
    private State<S, E, C> source;
    /**
     * 目标状态
     */
    protected State<S, E, C> target;
    /**
     * 状态跳转
     */
    private Transition<S, E, C> transition;
    /**
     * 跳转类型
     */
    protected final TransitionType transitionType;

    public TransitionBuilderImpl(Map<S, State<S, E, C>> stateMap, TransitionType transitionType) {
        this.stateMap = stateMap;
        this.transitionType = transitionType;
    }

    /**
     * 设置状态跳转中源状态
     *
     * @param state 状态
     * @return From<S, E, C>
     */
    @Override
    public From<S, E, C> from(S state) {
        source = StateHelper.getState(stateMap, state);
        return this;
    }

    /**
     * 设置状态跳转目的状态
     *
     * @param state 状态
     * @return To<S, E, C>
     */
    @Override
    public To<S, E, C> to(S state) {
        target = StateHelper.getState(stateMap, state);
        return this;
    }

    /**
     * 设置状态跳转时的内部状态
     *
     * @param state 状态
     * @return To<S, E, C>
     */
    @Override
    public To<S, E, C> within(S state) {
        source = target = StateHelper.getState(stateMap, state);
        return this;
    }

    /**
     * 设置状态跳转需执行的动作
     *
     * @param action 动作
     */
    @Override
    public void perform(Action<S, E, C> action) {
        transition.setAction(action);
    }

    /**
     * 设置状态跳转中条件
     *
     * @param condition 条件
     * @return When<S, E, C>
     */
    @Override
    public When<S, E, C> when(Condition<C> condition) {
        transition.setCondition(condition);
        return this;
    }

    /**
     * 设置状态跳转事件
     *
     * @param event 事件
     * @return On<S, E, C>
     */
    @Override
    public On<S, E, C> on(E event) {
        transition = source.addTransition(event, target, transitionType);
        return this;
    }

    /**
     * 设置状态跳转中监控
     *
     * @param monitor 监听器
     * @return Listen<S, E, C>
     */
    @Override
    public Listen<S, E, C> listen(Monitor<S, E, C> monitor) {
        transition.setMonitor(monitor);
        return this;
    }
}
