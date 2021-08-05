package com.ahuiali.weight_record.entity;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * WeightRecordEntity
 *
 * @author ZhengChaoHui
 * @date 2021/8/2 19:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "weight_record")
public class WeightRecordEntity{
    /**
     * 主键 id
     */
    @Id
    private String id;

    @Field("user_id")
    private Integer userId;

    /**
     * 体重记录
     */
    @Field("weight_record")
    private Double weightRecord;

    @Field("record_time")
    private Date recordTime;

    @Field("unit")
    private String unit;

    @Field("type")
    private String type;

}
