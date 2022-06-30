package org.yh.esaystatemachine;/**
 * @classname Transition
 * @description TODO
 * @date 2022/6/29 14:01
 * @author by YangHao
 */

import org.yh.esaystatemachine.Impl.TransitionType;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine
 * @classname Transition
 * @description TODO 转换
 * @date 2022/6/29 14:01
 */
public interface Transition<S, E, C> {

    /**
     * 获取源状态
     *
     * @return State<S,E,C>
     */
    State<S,E,C> getSource();

    /**
     * 设置源状态
     *
     * @param state 源状态
     */
    void setSource(State<S, E, C> state);

    /**
     * 获取事件
     *
     * @return E
     */
    E getEvent();

    /**
     * 设置事件
     *
     * @param event 事件
     */
    void setEvent(E event);

    /**
     * 设置状态跳转类型
     *
     * @param type 跳转类型
     */
    void setType(TransitionType type);

    /**
     * 获取目的状态
     *
     * @return State<S,E,C>
     */
    State<S,E,C> getTarget();

    /**
     * 设置目的状态
     *
     * @param state 目的状态
     */
    void setTarget(State<S, E, C> state);

    /**
     * 获取条件
     *
     * @return Condition<C>
     */
    Condition<C> getCondition();

    /**
     * 设置事件条件
     *
     * @param condition 条件
     */
    void setCondition(Condition<C> condition);

    /**
     * 获取监听器
     *
     * @return Monitor<S, E, C>
     */
    Monitor<S, E, C> getMonitor();

    /**
     * 设置事件监听器
     *
     * @param monitor 监听器
     */
    void setMonitor(Monitor<S, E, C> monitor);

    /**
     * 获取动作
     *
     * @return Action<S,E,C>
     */
    Action<S,E,C> getAction();

    /**
     * 设置跳转动作
     *
     * @param action 动作
     */
    void setAction(Action<S, E, C> action);

    /**
     * 执行跳转
     *
     * @param ctx 上下文
     * @param checkCondition 条件判断结果
     * @return State<S, E, C>
     */
    State<S, E, C> transit(C ctx, boolean checkCondition);

    /**
     * 验证跳转正确性
     */
    void verify();
}
