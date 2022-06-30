package org.yh.esaystatemachine.test.monitor;/**
 * @classname InquiryMonitor
 * @description TODO
 * @date 2022/6/30 13:44
 * @author by YangHao
 */

import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.test.Context;
import org.yh.esaystatemachine.test.Events;
import org.yh.esaystatemachine.test.States;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test.monitor
 * @classname InquiryMonitor
 * @description TODO
 * @date 2022/6/30 13:44
 */
public class InquiryMonitor implements Monitor<States, Events, Context> {

    /**
     * 监控
     *
     * @param from    源状态
     * @param to      目的状态
     * @param event   事件
     * @param context 上下文
     */
    @Override
    public void monitor(States from, States to, Events event, Context context) {
        System.out.println("source: " + context.inquiry
                + " trigger event:[" + event.toString()
                + "] state from:[" + from.toString()
                + "] to:[" + to.toString() + "]");
    }
}
