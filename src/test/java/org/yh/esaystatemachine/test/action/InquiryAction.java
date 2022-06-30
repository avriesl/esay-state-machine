package org.yh.esaystatemachine.test.action;/**
 * @classname InquiryAction
 * @description TODO
 * @date 2022/6/30 13:40
 * @author by YangHao
 */

import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.test.Context;
import org.yh.esaystatemachine.test.Events;
import org.yh.esaystatemachine.test.States;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test.action
 * @classname InquiryAction
 * @description TODO
 * @date 2022/6/30 13:40
 */
public class InquiryAction implements Action<States, Events, Context> {

    /**
     * 执行状态跳转
     *
     * @param from    源状态
     * @param to      目的状态
     * @param event   事件
     * @param context 上下文
     */
    @Override
    public void execute(States from, States to, Events event, Context context) {
        System.out.println(context.inquiry + " is event " + event + " from:" + from + " to:" + to);
    }
}
