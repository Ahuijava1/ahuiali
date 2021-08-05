package com.ahuiali.weight_record.service.impl;

import com.ahuiali.resp.Response;
import com.ahuiali.utils.ListBeanUtils;
import com.ahuiali.weight_record.dao.WeightRecordDao;
import com.ahuiali.weight_record.dto.WeightRecordDto;
import com.ahuiali.weight_record.entity.WeightRecordEntity;
import com.ahuiali.weight_record.service.WeightRecordService;
import com.ahuiali.weight_record.vo.WeightRecordBaseVo;
import com.ahuiali.weight_record.vo.WeightRecordTimeVo;
import com.ahuiali.weight_record.vo.WeightRecordVo;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * WeightRecordService
 *
 * @author ZhengChaoHui
 * @date 2021/8/3 22:40
 */
@Service
public class WeightRecordServiceImpl implements WeightRecordService {

    @Autowired
    private WeightRecordDao weightRecordDao;

    @Override
    public Response<?> addOneRecord(WeightRecordBaseVo weightRecordBaseVo, Integer userId) {

        WeightRecordEntity weightRecordEntity = new WeightRecordEntity();
        BeanUtils.copyProperties(weightRecordBaseVo, weightRecordEntity);
        // TODO 先写死
        weightRecordEntity.setUserId(userId);
//        weightRecordEntity.setRecordTime(Calendar.getInstance().getTime());
        WeightRecordEntity result = weightRecordDao.addOneRecord(weightRecordEntity);
        if (result.getId() != null && !"".equals(result.getId())) return Response.success();
        // 写异常
        return null;
    }

    @Override
    public Response<?> addRecords(List<WeightRecordBaseVo> weightRecordBaseVos, Integer userId) {
        // 复制属性
        List<WeightRecordEntity> weightRecordEntities = ListBeanUtils.copyListProperties(weightRecordBaseVos, WeightRecordEntity::new);
        // 设置用户id
        weightRecordEntities.forEach(e -> e.setUserId(userId));
        List<WeightRecordEntity> result = weightRecordDao.addRecords(weightRecordEntities);
        if (result.size() > 0) return Response.success();
        return null;
    }

    @Override
    public Response<?> updateRecord(WeightRecordVo weightRecordVo) {
        WeightRecordEntity weightRecordEntity = new WeightRecordEntity();
        BeanUtils.copyProperties(weightRecordVo, weightRecordEntity);
        // AcknowledgedUpdateResult{matchedCount=1, modifiedCount=1, upsertedId=null}
        UpdateResult update = weightRecordDao.update(weightRecordEntity);
        if (update.getModifiedCount() == 1) return Response.success();
        return null;
    }

    @Override
    public Response<?> getRecord(String id) {
        WeightRecordEntity record = weightRecordDao.getRecord(id);
        if (record != null) {
            WeightRecordDto weightRecordDto = new WeightRecordDto();
            BeanUtils.copyProperties(record, weightRecordDto);
            Response<WeightRecordDto> resp = Response.success();
            resp.setData(weightRecordDto);
            return resp;
        }
        return null;
    }

    @Override
    public Response<?> getRecords(WeightRecordTimeVo weightRecordTimeVo, Integer userId) {
        List<WeightRecordEntity> weightRecordEntities = weightRecordDao.getRecords(weightRecordTimeVo, userId);
        List<WeightRecordDto> weightRecordDtos = ListBeanUtils.copyListProperties(weightRecordEntities, WeightRecordDto::new);
        if (weightRecordEntities.size() > 0)  {
            Response<List<WeightRecordDto>> response = Response.success();
            response.setData(weightRecordDtos);
            return response;
        }
        return null;
    }

    @Override
    public Response<?> deleteRecord(String id) {
        if (StringUtils.isEmpty(id)) return null;
        DeleteResult delete = weightRecordDao.delete(id);
        if (delete.getDeletedCount() > 0) return Response.success();
        return null;
    }
}
