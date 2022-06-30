package org.yh.esaystatemachine.Impl;/**
 * @classname StateHelper
 * @description TODO
 * @date 2022/6/29 14:11
 * @author by YangHao
 */

import java.util.Map;
import org.yh.esaystatemachine.State;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.Impl
 * @classname StateHelper
 * @description TODO 状态工具
 * @date 2022/6/29 14:11
 */
public class StateHelper {

    /**
     * 获取状态
     *
     * @param stateMap 状态集
     * @param stateId 状态id
     * @param <S> StateEnum
     * @param <E> EventEnum
     * @param <C> Context
     * @return State<S, E, C>
     */
    public static <S, E, C> State<S, E, C> getState(Map<S, State<S, E, C>> stateMap, S stateId){
        State<S, E, C> state = stateMap.get(stateId);
        if (state == null) {
            state = new StateImpl<>(stateId);
            stateMap.put(stateId, state);
        }
        return state;
    }
}
