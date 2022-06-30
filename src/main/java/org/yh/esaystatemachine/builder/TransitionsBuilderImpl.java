package org.yh.esaystatemachine.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.Impl.StateHelper;
import org.yh.esaystatemachine.Impl.TransitionType;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.State;
import org.yh.esaystatemachine.Transition;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname TransitionsBuilderImpl
 * @description TODO
 * @date 2022/6/29 14:28
 */
public class TransitionsBuilderImpl<S, E, C> extends TransitionBuilderImpl<S,E,C> implements ExternalTransitionsBuilder<S,E,C> {

    /**
     * 源状态集
     */
    private List<State<S, E, C>> sources = new ArrayList<>();

    /**
     * 状态跳转集
     */
    private List<Transition<S, E, C>> transitions = new ArrayList<>();

    public TransitionsBuilderImpl(Map<S, State<S, E, C>> sStateMap,
            TransitionType transitionType) {
        super(sStateMap, transitionType);
    }

    /**
     * 设置状态跳转中源状态集
     *
     * @param states 状态集
     * @return From<S, E, C>
     */
    @Override
    public From<S, E, C> fromAmong(S... states) {
        for (S stateId : states) {
            sources.add(StateHelper.getState(super.stateMap, stateId));
        }
        return this;
    }

    @Override
    public On<S, E, C> on(E event) {
        for (State<S, E, C> source : sources) {
            Transition<S, E, C> transition = source.addTransition(event, super.target, super.transitionType);
            transitions.add(transition);
        }
        return this;
    }

    @Override
    public When<S, E, C> when(Condition<C> condition) {
        for (Transition<S, E, C> transition : transitions) {
            transition.setCondition(condition);
        }
        return this;
    }

    @Override
    public Listen<S, E, C> listen(Monitor<S, E, C> monitor) {
        for (Transition<S, E, C> transition : transitions) {
            transition.setMonitor(monitor);
        }
        return this;
    }

    @Override
    public void perform(Action<S, E, C> action) {
        for (Transition<S, E, C> transition : transitions) {
            transition.setAction(action);
        }
    }
}
