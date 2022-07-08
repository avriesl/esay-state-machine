package org.yh.esaystatemachine.test.machine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.yh.esaystatemachine.StateMachine;
import org.yh.esaystatemachine.builder.StateMachineBuilder;
import org.yh.esaystatemachine.builder.StateMachineBuilderFactory;
import org.yh.esaystatemachine.test.Context;
import org.yh.esaystatemachine.test.Events;
import org.yh.esaystatemachine.test.States;
import org.yh.esaystatemachine.test.config.ToWaitSubmitted;
import org.yh.esaystatemachine.test.config.WaitSubmittedToSubmitted;
import org.yh.esaystatemachine.test.config.WaitSubmittedToWaitSubmitted;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test.machine
 * @classname StateMachine
 * @description TODO 状态机工厂
 * @date 2022/7/8 8:16
 */
public class StateMachineFactory {

    private final static Map<String, StateMachine<States, Events, Context>> machineMap = new ConcurrentHashMap<>();

    private static StateMachine<States, Events, Context> instance;

    private StateMachineFactory(){}

    public synchronized static StateMachine<States, Events, Context> getInstance(String machineId) {
        instance = machineMap.get(machineId);
        if (instance == null) {
            instance = buildStateMachine(machineId);
            machineMap.put(machineId, instance);
        }
        return instance;
    }

    private static StateMachine<States, Events, Context> buildStateMachine(String machineId) {
        ToWaitSubmitted noneToWS = new ToWaitSubmitted();
        WaitSubmittedToWaitSubmitted wsTows = new WaitSubmittedToWaitSubmitted();
        WaitSubmittedToSubmitted wsTos = new WaitSubmittedToSubmitted();
        StateMachineBuilder<States, Events, Context> builder = StateMachineBuilderFactory.create();
        noneToWS.build(builder);
        wsTows.build(builder);
        wsTos.build(builder);
        builder.build(machineId);
        StateMachine<States, Events, Context> stateMachine = org.yh.esaystatemachine.StateMachineFactory.get(machineId);
        stateMachine.showStateMachine();
        return stateMachine;
    }

}
