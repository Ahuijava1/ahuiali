package com.ahuiali.weight_record.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * WeightRecordDto
 *
 * @author ZhengChaoHui
 * @date 2021/8/5 19:52
 */
@Data
public class WeightRecordDto {

    /**
     * 主键 id
     */
    private String id;

    /**
     * 体重记录
     */
    private Double weightRecord;

    /**
     * 记录时间
     */
    private Date recordTime;

    /**
     * 体重单位
     */
    private String unit;

    /**
     * 类型
     */
    private String type;
}
