package org.yh.esaystatemachine.test.config;/**
 * @classname WaitSubmittedToWaitSubmitted
 * @description TODO
 * @date 2022/7/8 8:54
 * @author by YangHao
 */

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
 * @classname WaitSubmittedToWaitSubmitted
 * @description TODO WAIT_SUBMITTED_TO_WAIT_SUBMITTED
 * @date 2022/7/8 8:54
 */
public class WaitSubmittedToWaitSubmitted implements EventsConfig<States, Events, Context> {

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
     * @param builder 状态机builder
     */
    @Override
    public void build(StateMachineBuilder<States, Events, Context> builder) {
        builder.externalTransition()
                .from(States.WAIT_SUBMITTED)
                .to(States.SUBMITTED)
                .on(Events.WAIT_SUBMITTED_TO_SUBMITTED)
                .when(condition())
                .listen(monitor())
                .perform(action());
    }
}
