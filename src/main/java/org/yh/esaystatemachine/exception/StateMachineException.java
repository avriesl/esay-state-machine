package org.yh.esaystatemachine.exception;/**
 * @classname StateMachineException
 * @description TODO
 * @date 2022/6/29 14:44
 * @author by YangHao
 */

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.exception
 * @classname StateMachineException
 * @description TODO 状态机异常
 * @date 2022/6/29 14:44
 */
public class StateMachineException extends RuntimeException {
    public StateMachineException(String message){
        super(message);
    }
}
