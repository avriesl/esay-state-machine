package org.yh.esaystatemachine.Impl;/**
 * @classname TransitionImpl
 * @description TODO
 * @date 2022/6/29 14:39
 * @author by YangHao
 */

import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.State;
import org.yh.esaystatemachine.Transition;
import org.yh.esaystatemachine.exception.StateMachineException;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.Impl
 * @classname TransitionImpl
 * @description TODO 状态跳转实现
 * @date 2022/6/29 14:39
 */
public class TransitionImpl<S, E, C> implements Transition<S, E, C> {

    /**
     * 源状态
     */
    private State<S, E, C> source;

    /**
     * 目的状态
     */
    private State<S, E, C> target;

    /**
     * 事件
     */
    private E event;

    /**
     * 条件
     */
    private Condition<C> condition;

    /**
     * 监听
     */
    private Monitor<S, E, C> monitor;

    /**
     * 动作
     */
    private Action<S,E,C> action;

    /**
     * 跳转类型 默认:外部
     */
    private TransitionType type = TransitionType.EXTERNAL;

    /**
     * 获取源状态
     *
     * @return State<S, E, C>
     */
    @Override
    public State<S, E, C> getSource() {
        return source;
    }

    /**
     * 设置源状态
     *
     * @param state 源状态
     */
    @Override
    public void setSource(State<S, E, C> state) {
        this.source = state;
    }

    /**
     * 获取事件
     *
     * @return E
     */
    @Override
    public E getEvent() {
        return event;
    }

    /**
     * 设置事件
     *
     * @param event 事件
     */
    @Override
    public void setEvent(E event) {
        this.event = event;
    }

    /**
     * 设置状态跳转类型
     *
     * @param type 跳转类型
     */
    @Override
    public void setType(TransitionType type) {
        this.type = type;
    }

    /**
     * 获取目的状态
     *
     * @return State<S, E, C>
     */
    @Override
    public State<S, E, C> getTarget() {
        return target;
    }

    /**
     * 设置目的状态
     *
     * @param state 目的状态
     */
    @Override
    public void setTarget(State<S, E, C> state) {
        this.target = state;
    }

    /**
     * 获取条件
     *
     * @return Condition<C>
     */
    @Override
    public Condition<C> getCondition() {
        return condition;
    }

    /**
     * 设置事件条件
     *
     * @param condition 条件
     */
    @Override
    public void setCondition(Condition<C> condition) {
        this.condition = condition;
    }

    /**
     * 获取监听器
     *
     * @return Monitor<S, E, C>
     */
    @Override
    public Monitor<S, E, C> getMonitor() {
        return monitor;
    }

    /**
     * 设置事件监听器
     *
     * @param monitor 监听器
     */
    @Override
    public void setMonitor(Monitor<S, E, C> monitor) {
        this.monitor = monitor;
    }

    /**
     * 获取动作
     *
     * @return Action<S, E, C>
     */
    @Override
    public Action<S, E, C> getAction() {
        return action;
    }

    /**
     * 设置跳转动作
     *
     * @param action 动作
     */
    @Override
    public void setAction(Action<S, E, C> action) {
        this.action = action;
    }

    /**
     * 执行跳转
     *
     * @param ctx            上下文
     * @param checkCondition 条件判断结果
     * @return State<S, E, C>
     */
    @Override
    public State<S, E, C> transit(C ctx, boolean checkCondition) {
        this.verify();
        if (!checkCondition || condition == null || condition.isSatisfied(ctx)) {
            if(action != null){
                monitor.monitor(source.getId(), target.getId(), event, ctx);
                action.execute(source.getId(), target.getId(), event, ctx);
            }
            return target;
        }
        return source;
    }

    /**
     * 验证跳转正确性
     */
    @Override
    public void verify() {
        if (type == TransitionType.INTERNAL && source != target) {
            throw new StateMachineException(String.format("Internal transition source state '%s' " +
                    "and target state '%s' must be same.", source, target));
        }
    }
    @Override
    public final String toString() {
        return source + "-[" + event.toString() +", "+type+"]->" + target;
    }

    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof Transition){
            Transition<S, E, C> other = (Transition<S, E, C>)anObject;
            return this.event.equals(other.getEvent())
                    && this.source.equals(other.getSource())
                    && this.target.equals(other.getTarget());
        }
        return false;
    }
}
