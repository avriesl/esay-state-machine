package org.yh.esaystatemachine.test;

import org.junit.Assert;
import org.junit.Test;
import org.yh.esaystatemachine.StateMachine;
import org.yh.esaystatemachine.test.machine.StateMachineFactory;

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
        StateMachine<States, Events, Context> stateMachine = StateMachineFactory.getInstance(MACHINE_ID);
        Context context = new Context();

        States target = stateMachine.fireEvent(States.NONE, Events.NONE_TO_WAIT_SUBMITTED, context);
        Assert.assertEquals(States.WAIT_SUBMITTED, target);
        target = stateMachine.fireEvent(States.WAIT_SUBMITTED, Events.WAIT_SUBMITTED_TO_WAIT_SUBMITTED, context);
        Assert.assertEquals(States.WAIT_SUBMITTED, target);
        target = stateMachine.fireEvent(States.WAIT_SUBMITTED, Events.WAIT_SUBMITTED_TO_SUBMITTED, context);
        Assert.assertEquals(States.SUBMITTED, target);
    }


}
