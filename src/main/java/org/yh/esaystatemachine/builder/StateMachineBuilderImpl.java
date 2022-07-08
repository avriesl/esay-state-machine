package org.yh.esaystatemachine.builder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.yh.esaystatemachine.Impl.StateMachineImpl;
import org.yh.esaystatemachine.Impl.TransitionType;
import org.yh.esaystatemachine.State;
import org.yh.esaystatemachine.StateMachine;
import org.yh.esaystatemachine.StateMachineFactory;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname StateMachineBuilderImpl
 * @description TODO 状态机Builder实现
 * @date 2022/6/28 10:14
 */
public class StateMachineBuilderImpl<S, E, C> implements StateMachineBuilder<S, E, C> {

    private final Map<S, State< S, E, C>> stateMap = new ConcurrentHashMap<>();
    private final StateMachineImpl<S, E, C> stateMachine = new StateMachineImpl<>(stateMap);

    @Override
    public ExternalTransitionBuilder<S, E, C> externalTransition() {
        return new TransitionBuilderImpl<>(stateMap, TransitionType.EXTERNAL);
    }

    @Override
    public ExternalTransitionsBuilder<S, E, C> externalTransitions() {
        return new TransitionsBuilderImpl<>(stateMap, TransitionType.EXTERNAL);
    }

    @Override
    public InternalTransitionBuilder<S, E, C> internalTransition() {
        return new TransitionBuilderImpl<>(stateMap, TransitionType.INTERNAL);
    }

    /**
     * 构建状态机
     *
     * @param machineId 机器id
     * @return StateMachine<S, E, C>
     */
    @Override
    public StateMachine<S, E, C> build(String machineId) {
        // builder
        stateMachine.setMachineId(machineId);
        stateMachine.setReady(true);
        StateMachineFactory.register(stateMachine);
        return stateMachine;
    }
}
