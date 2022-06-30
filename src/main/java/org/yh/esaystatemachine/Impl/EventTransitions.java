package org.yh.esaystatemachine.Impl;/**
 * @classname EventTransitions
 * @description TODO
 * @date 2022/6/29 15:30
 * @author by YangHao
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.yh.esaystatemachine.Transition;
import org.yh.esaystatemachine.exception.StateMachineException;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.Impl
 * @classname EventTransitions
 * @description TODO 同一个Event可以触发多个Transitions
 * @date 2022/6/29 15:30
 */
public class EventTransitions<S,E,C> {
    private HashMap<E, List<Transition<S,E,C>>> eventTransitions;
    public EventTransitions(){
        eventTransitions = new HashMap<>();
    }

    /**
     * put
     *
     * @param event 事件
     * @param transition 状态跳转
     */
    public void put(E event, Transition<S, E, C> transition){
        if(eventTransitions.get(event) == null){
            List<Transition<S,E,C>> transitions = new ArrayList<>();
            transitions.add(transition);
            eventTransitions.put(event, transitions);
        }
        else{
            List<Transition<S,E,C>> existingTransitions = eventTransitions.get(event);
            verify(existingTransitions, transition);
            existingTransitions.add(transition);
        }
    }

    /**
     * 对于一个源和目标状态，只允许一个转换
     * @param existingTransitions
     * @param newTransition
     */
    private void verify(List<Transition<S,E,C>> existingTransitions, Transition<S,E,C> newTransition) {
        for (Transition<S,E,C> transition : existingTransitions) {
            if (transition.equals(newTransition)) {
                throw new StateMachineException(transition + " already Exist, you can not add another one");
            }
        }
    }

    public List<Transition<S,E,C>> get(E event){
        return eventTransitions.get(event);
    }

    public List<Transition<S,E,C>> allTransitions(){
        List<Transition<S,E,C>> allTransitions = new ArrayList<>();
        for(List<Transition<S,E,C>> transitions : eventTransitions.values()){
            allTransitions.addAll(transitions);
        }
        return allTransitions;
    }
}
