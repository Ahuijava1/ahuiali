package com.ahuiali.weight_record.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * WeightRecordVo
 *
 * @author ZhengChaoHui
 * @date 2021/8/3 22:33
 */
@Data
public class WeightRecordBaseVo {

    /**
     * 体重记录
     */
    private Double weightRecord;
    /**
     * 记录时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date recordTime;

    /**
     * 单位
     */
    private String unit;

    /**
     * 类型
     */
    private String type;
}
