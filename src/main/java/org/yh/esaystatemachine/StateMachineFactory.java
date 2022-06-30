package org.yh.esaystatemachine;/**
 * @classname StateMachineFactory
 * @description TODO
 * @date 2022/6/29 15:25
 * @author by YangHao
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.yh.esaystatemachine.exception.StateMachineException;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine
 * @classname StateMachineFactory
 * @description TODO 状态机工厂
 * @date 2022/6/29 15:25
 */
public class StateMachineFactory {
    static Map<String, StateMachine> stateMachineMap = new ConcurrentHashMap<>();

    public static <S, E, C> void register(StateMachine<S, E, C> stateMachine){
        String machineId = stateMachine.getMachineId();
        if(stateMachineMap.get(machineId) != null){
            throw new StateMachineException("The state machine with id ["+machineId+"] is already built, no need to build again");
        }
        stateMachineMap.put(stateMachine.getMachineId(), stateMachine);
    }

    public static <S, E, C> StateMachine<S, E, C> get(String machineId){
        StateMachine<S, E, C> stateMachine = stateMachineMap.get(machineId);
        if(stateMachine == null){
            throw new StateMachineException("There is no stateMachine instance for "+machineId+", please build it first");
        }
        return stateMachine;
    }
}
