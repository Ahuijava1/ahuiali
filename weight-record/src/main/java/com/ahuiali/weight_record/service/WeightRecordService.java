package com.ahuiali.weight_record.service;

import com.ahuiali.resp.Response;
import com.ahuiali.weight_record.vo.WeightRecordBaseVo;
import com.ahuiali.weight_record.vo.WeightRecordTimeVo;
import com.ahuiali.weight_record.vo.WeightRecordVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * WeightRecordService
 *
 * @author ZhengChaoHui
 * @date 2021/8/3 22:36
 */
@Service
public interface WeightRecordService {

    /**
     * 添加一条记录
     * @param weightRecordBaseVo 体重参数
     * @param userId 用户id
     * @return resp
     */
    Response<?> addOneRecord(WeightRecordBaseVo weightRecordBaseVo, Integer userId);

    /**
     * 批量添加记录
     * @param weightRecordBaseVos 记录s
     * @param userId 用户id
     * @return resp
     */
    Response<?> addRecords(List<WeightRecordBaseVo> weightRecordBaseVos, Integer userId);

    /**
     * 修改一条记录
     * @param weightRecordVo 记录
     * @return resp
     */
    Response<?> updateRecord(WeightRecordVo weightRecordVo);

    /**
     * 查询一条记录
     * @param id id
     * @return resp
     */
    Response<?> getRecord(String id);

    /**
     * 根据时间获取记录
     * @param weightRecordTimeVo 时间参数
     * @param userId 用户id
     * @return
     */
    Response<?> getRecords(WeightRecordTimeVo weightRecordTimeVo, Integer userId);
}
