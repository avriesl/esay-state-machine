package org.yh.esaystatemachine.test;

import org.junit.Assert;
import org.junit.Test;
import org.yh.esaystatemachine.Action;
import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.Monitor;
import org.yh.esaystatemachine.StateMachine;
import org.yh.esaystatemachine.StateMachineFactory;
import org.yh.esaystatemachine.builder.StateMachineBuilder;
import org.yh.esaystatemachine.builder.StateMachineBuilderFactory;
import org.yh.esaystatemachine.test.action.InquiryAction;
import org.yh.esaystatemachine.test.condition.InquiryCondition;
import org.yh.esaystatemachine.test.monitor.InquiryMonitor;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test
 * @classname StateMachineTest
 * @description TODO
 * @date 2022/6/29 15:37
 */
public class StateMachineTest {

    static String MACHINE_ID = "Test-StateMachine";

    @Test
    public void test(){
        StateMachine<States, Events, Context> stateMachine = buildStateMachine(MACHINE_ID);
        Context context = new Context();

        States target = stateMachine.fireEvent(States.NONE, Events.NONE_TO_WAIT_SUBMITTED, context);
        Assert.assertEquals(States.WAIT_SUBMITTED, target);
        target = stateMachine.fireEvent(States.WAIT_SUBMITTED, Events.WAIT_SUBMITTED_TO_WAIT_SUBMITTED, context);
        Assert.assertEquals(States.WAIT_SUBMITTED, target);
        target = stateMachine.fireEvent(States.WAIT_SUBMITTED, Events.WAIT_SUBMITTED_TO_SUBMITTED, context);
        Assert.assertEquals(States.SUBMITTED, target);
    }

    private StateMachine<States, Events, Context> buildStateMachine(String machineId) {
        InquiryCondition condition = new InquiryCondition();
        InquiryAction action = new InquiryAction();
        InquiryMonitor monitor = new InquiryMonitor();
        StateMachineBuilder<States, Events, Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
                .from(States.NONE)
                .to(States.WAIT_SUBMITTED)
                .on(Events.NONE_TO_WAIT_SUBMITTED)
                .when(condition)
                .listen(monitor)
                .perform(action);
        builder.externalTransition()
                .from(States.WAIT_SUBMITTED)
                .to(States.SUBMITTED)
                .on(Events.WAIT_SUBMITTED_TO_SUBMITTED)
                .when(condition)
                .listen(monitor)
                .perform(action);
        builder.internalTransition()
                .within(States.WAIT_SUBMITTED)
                .on(Events.WAIT_SUBMITTED_TO_WAIT_SUBMITTED)
                .when(condition)
                .listen(monitor)
                .perform(action);
        /* ... */

        builder.build(machineId);
        StateMachine<States, Events, Context> stateMachine = StateMachineFactory.get(machineId);
        stateMachine.showStateMachine();
        return stateMachine;
    }
}
