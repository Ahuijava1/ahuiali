package com.ahuiali.weight_record.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * UnitEnum
 * 单位枚举
 * @author ZhengChaoHui
 * @date 2021/8/2 19:33
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum  UnitEnum {
    KG("kg", "千克"),
    LB("lb", "磅");

    /**
     * 单位
     */
    private String unit;
    /**
     * 描述
     */
    private String desc;

    // TODO换算
}
