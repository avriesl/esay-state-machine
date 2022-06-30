package org.yh.esaystatemachine;/**
 * @classname State
 * @description TODO
 * @date 2022/6/29 14:02
 * @author by YangHao
 */

import java.util.Collection;
import java.util.List;
import org.yh.esaystatemachine.Impl.TransitionType;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine
 * @classname State
 * @description TODO 状态
 * @date 2022/6/29 14:02
 */
public interface State<S, E, C> {

    /**
     * 获取当前状态
     *
     * @return S
     */
    S getId();

    /**
     * 添加状态跳转
     *
     * @param event 事件
     * @param target 目标状态
     * @param transitionType 跳转类型
     * @return Transition<S,E,C>
     */
    Transition<S,E,C> addTransition(E event, State<S, E, C> target, TransitionType transitionType);

    /**
     * 通过事件获取状态跳转集
     *
     * @param event 事件
     * @return List<Transition<S,E,C>>
     */
    List<Transition<S,E,C>> getEventTransitions(E event);

    /**
     * 获取全部状态跳转集
     *
     * @return Collection<Transition<S,E,C>>
     */
    Collection<Transition<S,E,C>> getAllTransitions();
}
