package org.yh.esaystatemachine;
/**
 * @author by YangHao
 * @package org.yh.esaystatemachine
 * @classname Condition
 * @description TODO 条件
 * @date 2022/6/29 13:39
 */
public interface Condition<C> {

    /**
     * 是否满足条件
     *
     * @param context 上下文
     * @return boolean
     */
    boolean isSatisfied(C context);

    /**
     * 类名
     *
     * @return String
     */
    default String name() {
        return this.getClass().getSimpleName();
    }
}
