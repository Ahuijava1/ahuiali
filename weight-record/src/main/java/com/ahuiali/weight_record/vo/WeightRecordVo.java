package com.ahuiali.weight_record.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * WeightRecordVo
 *
 * @author ZhengChaoHui
 * @date 2021/8/5 19:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WeightRecordVo extends WeightRecordBaseVo {
    /**
     * 记录的id（mongo生成）
     */
    private String id;
}
