package org.yh.esaystatemachine.test.config;

import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.builder.StateMachineBuilder;
import org.yh.esaystatemachine.config.EventsConfig;
import org.yh.esaystatemachine.test.Context;
import org.yh.esaystatemachine.test.Events;
import org.yh.esaystatemachine.test.States;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test.config
 * @classname InquiryEventsConfig
 * @description TODO NONE_TO_WAIT_SUBMITTED 事件配置
 * @date 2022/7/8 8:45
 */
public class ToWaitSubmitted implements EventsConfig<States, Events, Context>{

    /**
     * 事件条件
     *
     * @return Condition<C>
     */
    @Override
    public Condition<Context> condition() {
        return context -> true;
    }

    /**
     * 事件动作
     *
     * @return Action<S, E, C>
     */
    @Override
    public Action<States, Events, Context> action() {
        return (from, to, event, context) -> System.out.println(context.inquiry + " is event " + event + " from:" + from + " to:" + to);
    }

    /**
     * 事件监控
     *
     * @return Monitor<S, E, C>
     */
    @Override
    public Monitor<States, Events, Context> monitor() {
        return (from, to, event, context) -> System.out.println("source: " + context.inquiry
                + " trigger event:[" + event.toString()
                + "] state from:[" + from.toString()
                + "] to:[" + to.toString() + "]");
    }

    /**
     * 事件构建
     *
     * @param builder 状态机 builder
     */
    @Override
    public void build(StateMachineBuilder<States, Events, Context> builder) {
        builder.externalTransition()
                .from(States.NONE)
                .to(States.WAIT_SUBMITTED)
                .on(Events.NONE_TO_WAIT_SUBMITTED)
                .when(condition())
                .listen(monitor())
                .perform(action());;
    }
}
