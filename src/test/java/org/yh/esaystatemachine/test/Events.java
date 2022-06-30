package org.yh.esaystatemachine.test;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test
 * @classname Ecents
 * @description TODO
 * @date 2022/6/30 13:30
 */
public enum Events {
    /* EXTERNAL */
    NONE_TO_WAIT_SUBMITTED, WAIT_SUBMITTED_TO_SUBMITTED, SUBMITTED_TO_TRIAGING, TRIAGING_TO_TRIAGE_END,
    TRIAGE_END_TO_WAIT_INQUIRY, TRIAGE_END_TO_INQUIRING, WAIT_INQUIRY_TO_INQUIRING, INQUIRING_TO_INQUIRY_END,
    INQUIRY_END_TO_INQUIRY_COMPLETE,
    /* EXTERNAL */
    WAIT_SUBMITTED_TO_WAIT_SUBMITTED
}
