package org.yh.esaystatemachine;/**
 * @classname StateMachine
 * @description TODO
 * @date 2022/6/29 15:09
 * @author by YangHao
 */

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine
 * @classname StateMachine
 * @description TODO 状态机
 * @date 2022/6/29 15:09
 */
public interface StateMachine<S, E, C> {

    /**
     * 向状态机发送一个事件
     *
     * @param sourceState 源状态
     * @param event 目标状态
     * @param ctx 上下文
     * @return S
     */
    S fireEvent(S sourceState, E event, C ctx);

    /**
     * 当前状态机的机器id
     *
     * @return String
     */
    String getMachineId();

    /**
     * 展示状态机的结构
     */
    void showStateMachine();

    /**
     * 生成UML
     *
     * @return String
     */
    String generatePlantUML();
}
