package org.yh.esaystatemachine.Impl;/**
 * @classname StateImpl
 * @description TODO
 * @date 2022/6/29 14:13
 * @author by YangHao
 */

import java.util.Collection;
import java.util.List;
import org.yh.esaystatemachine.State;
import org.yh.esaystatemachine.Transition;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.Impl
 * @classname StateImpl
 * @description TODO 状态实现
 * @date 2022/6/29 14:13
 */
public class StateImpl<S, E, C> implements State<S, E, C> {

    /**
     * 状态id
     */
    protected final S stateId;
    private EventTransitions<S,E,C> eventTransitions = new EventTransitions<>();

    StateImpl(S stateId){
        this.stateId = stateId;
    }

    /**
     * 获取当前状态
     *
     * @return S
     */
    @Override
    public S getId() {
        return stateId;
    }

    /**
     * 添加状态跳转
     *
     * @param event          事件
     * @param target         目标状态
     * @param transitionType 跳转类型
     * @return Transition<S, E, C>
     */
    @Override
    public Transition<S, E, C> addTransition(E event, State<S, E, C> target,
            TransitionType transitionType) {
        Transition<S, E, C> newTransition = new TransitionImpl<>();
        newTransition.setSource(this);
        newTransition.setTarget(target);
        newTransition.setEvent(event);
        newTransition.setType(transitionType);

        eventTransitions.put(event, newTransition);
        return newTransition;
    }

    /**
     * 通过事件获取状态跳转集
     *
     * @param event 事件
     * @return List<Transition < S, E, C>>
     */
    @Override
    public List<Transition<S, E, C>> getEventTransitions(E event) {
        return eventTransitions.get(event);
    }

    /**
     * 获取全部状态跳转集
     *
     * @return Collection<Transition < S, E, C>>
     */
    @Override
    public Collection<Transition<S, E, C>> getAllTransitions() {
        return eventTransitions.allTransitions();
    }

    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof State){
            State<S, E, C> other = (State<S, E, C>)anObject;
            return this.stateId.equals(other.getId());
        }
        return false;
    }

    @Override
    public String toString(){
        return stateId.toString();
    }
}
