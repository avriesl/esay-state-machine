package org.yh.esaystatemachine.test.condition;/**
 * @classname InquiryCondition
 * @description TODO
 * @date 2022/6/30 13:40
 * @author by YangHao
 */

import org.yh.esaystatemachine.Condition;
import org.yh.esaystatemachine.test.Context;

/**
 * @author by YangHao
 * @package org.yh.esaystatemachine.test.condition
 * @classname InquiryCondition
 * @description TODO
 * @date 2022/6/30 13:40
 */
public class InquiryCondition implements Condition<Context> {

    /**
     * 是否满足条件
     *
     * @param context 上下文
     * @return boolean
     */
    @Override
    public boolean isSatisfied(Context context) {
        return true;
    }

    /**
     * 类名
     *
     * @return String
     */
    @Override
    public String name() {
        return getClass().getName();
    }
}
