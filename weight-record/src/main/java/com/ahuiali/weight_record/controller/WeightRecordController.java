package com.ahuiali.weight_record.controller;

import com.ahuiali.resp.Response;
import com.ahuiali.weight_record.service.WeightRecordService;
import com.ahuiali.weight_record.vo.WeightRecordBaseVo;
import com.ahuiali.weight_record.vo.WeightRecordTimeVo;
import com.ahuiali.weight_record.vo.WeightRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * WeightRecordController
 *  体重记录控制器
 * @author ZhengChaoHui
 * @date 2021/8/3 22:24
 */
@RestController
@RequestMapping("/api/v1/weight/record")
@Slf4j
public class WeightRecordController {

    @Autowired
    private WeightRecordService weightRecordService;

    /**
     * 添加一条数据
     * @param weightRecordBaseVo vo
     * @return resp
     */
    @RequestMapping(value = "/add", produces = "application/json;charset=utf-8;", method = RequestMethod.POST)
    public Response<?> addOneRecord(@RequestBody WeightRecordBaseVo weightRecordBaseVo) {
        // 先写死
        return weightRecordService.addOneRecord(weightRecordBaseVo, 21);
    }

    /**
     * 批量添加数据
     * @param weightRecordBaseVos vo
     * @return resp
     */
    @RequestMapping(value = "/addAll", produces = "application/json;charset=utf-8;", method = RequestMethod.POST)
    public Response<?> addRecords(@RequestBody List<WeightRecordBaseVo> weightRecordBaseVos) {
        // 先写死
        return weightRecordService.addRecords(weightRecordBaseVos, 21);
    }

    /**
     * 修改一条数据
     * @param weightRecordVo vo
     * @return resp
     */
    @RequestMapping(value = "/update", produces = "application/json;charset=utf-8;", method = RequestMethod.POST)
    public Response<?> updateRecord(@RequestBody WeightRecordVo weightRecordVo) {
        // 先写死
        return weightRecordService.updateRecord(weightRecordVo);
    }

    /**
     * 查询一条数据
     * @param id id
     * @return resp
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Response<?> get(@PathVariable String id) {
        return weightRecordService.getRecord(id);
    }

    /**
     * 按时间查询查询数据
     * @param weightRecordTimeVo 时间参数
     * @return resp
     */
    @RequestMapping(value = "/get/records", produces = "application/json;charset=utf-8;", method = RequestMethod.POST)
    public Response<?> getRecordsByTime(@RequestBody WeightRecordTimeVo weightRecordTimeVo) {
        Integer userId = 21;
        return weightRecordService.getRecords(weightRecordTimeVo, userId);
    }
}
