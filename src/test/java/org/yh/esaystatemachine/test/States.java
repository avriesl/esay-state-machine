package org.yh.esaystatemachine.test;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test
 * @classname States
 * @description TODO
 * @date 2022/6/30 13:29
 */
public enum States {
    NONE, WAIT_SUBMITTED, SUBMITTED, TRIAGING, TRIAGE_END, WAIT_INQUIRY,
    INQUIRING, INQUIRY_END, INQUIRY_COMPLETE
}
