package org.yh.esaystatemachine.builder;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.builder
 * @classname StateMachineBuilderFactory
 * @description TODO 状态机builder工厂
 * @date 2022/6/28 9:39
 */
public class StateMachineBuilderFactory {
    public static <S, E, C> StateMachineBuilder<S, E, C> create(){
        return new StateMachineBuilderImpl<>();
    }
}
