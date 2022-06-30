package org.yh.esaystatemachine.Impl;/**
 * @classname StateMachineImpl
 * @description TODO
 * @date 2022/6/29 15:12
 * @author by YangHao
 */

import java.util.List;
import java.util.Map;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.State;
import org.yh.esaystatemachine.StateMachine;
import org.yh.esaystatemachine.Transition;
import org.yh.esaystatemachine.exception.StateMachineException;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.Impl
 * @classname StateMachineImpl
 * @description TODO 状态机实现
 * @date 2022/6/29 15:12
 */
public class StateMachineImpl<S, E, C> implements StateMachine<S, E, C> {

    /**
     * 机器id
     */
    private String machineId;

    /**
     * 状态集
     */
    private final Map<S, State<S, E, C>> stateMap;

    /**
     * ready
     */
    private boolean ready;

    public StateMachineImpl(Map<S, State<S, E, C>> stateMap) {
        this.stateMap = stateMap;
    }

    /**
     * 向状态机发送一个事件
     *
     * @param sourceState 源状态
     * @param event       目标状态
     * @param ctx         上下文
     * @return S
     */
    @Override
    public S fireEvent(S sourceState, E event, C ctx) {
        isReady();
        Transition<S, E, C> transition = routeTransition(sourceState, event, ctx);
        if (transition == null) {
            return sourceState;
        }
        return transition.transit(ctx, false).getId();
    }

    /**
     * 状态跳转路由
     *
     * @param sourceStateId 源状态
     * @param event       目标状态
     * @param ctx         上下文
     * @return Transition<S, E, C>
     */
    private Transition<S, E, C> routeTransition(S sourceStateId, E event, C ctx) {
        State<S, E, C> sourceState = getState(sourceStateId);
        List<Transition<S, E, C>> transitions = sourceState.getEventTransitions(event);
        if (transitions == null || transitions.size() == 0) {
            return null;
        }
        Transition<S, E, C> transit = null;
        for (Transition<S, E, C> transition : transitions) {
            if (transition.getCondition() == null) {
                transit = transition;
            } else if (transition.getCondition().isSatisfied(ctx)) {
                transit = transition;
                break;
            }
        }
        return transit;
    }

    /**
     * 当前状态机的机器id
     *
     * @return String
     */
    @Override
    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    /**
     * 展示状态机的结构
     */
    @Override
    public void showStateMachine() {
    }

    /**
     * 生成UML
     *
     * @return String
     */
    @Override
    public String generatePlantUML() {
        return null;
    }

    /**
     * 是否可执行
     */
    private void isReady() {
        if (!ready) {
            throw new StateMachineException("State machine is not built yet, can not work");
        }
    }

    /**
     * 获取当前状态
     *
     * @param currentStateId 当前状态id
     * @return State<S, E, C>
     */
    private State<S, E, C> getState(S currentStateId) {
        State<S, E, C> state = StateHelper.getState(stateMap, currentStateId);
        if (state == null) {
            showStateMachine();
            throw new StateMachineException(currentStateId + " is not found, please check state machine");
        }
        return state;
    }
}
