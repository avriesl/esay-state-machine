package org.yh.esaystatemachine.test;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test
 * @classname States
 * @description TODO
 * @date 2022/6/30 13:29
 */
public enum States {
    // 无状态
    NONE,
    // 待提交
    WAIT_SUBMITTED,
    // 已提交
    SUBMITTED,
    // 分诊中
    TRIAGING,
    // 等待咨询
    WAIT_INQUIRY,
    // 咨询中
    INQUIRING,
    // 咨询完成
    INQUIRY_END,
    // 已结束
    INQUIRY_COMPLETE,
    // 咨询取消
    INQUIRY_CANCEL,
    // 转线下
    INQUIRY_OFFLINE
}
