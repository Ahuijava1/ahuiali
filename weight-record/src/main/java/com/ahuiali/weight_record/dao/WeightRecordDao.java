package com.ahuiali.weight_record.dao;

import com.ahuiali.weight_record.entity.WeightRecordEntity;
import com.ahuiali.weight_record.vo.WeightRecordTimeVo;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * WeightRecordDto
 *
 * @author ZhengChaoHui
 * @date 2021/8/3 22:35
 */
@Component
public class WeightRecordDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *
     * @param weightRecordEntity
     * @return
     */
    public WeightRecordEntity addOneRecord(WeightRecordEntity weightRecordEntity) {
        // 保存
        return mongoTemplate.save(weightRecordEntity);
    }

    public List<WeightRecordEntity> addRecords(List<WeightRecordEntity> weightRecordEntities) {
        return (List<WeightRecordEntity>) mongoTemplate.insertAll(weightRecordEntities);
    }

    public UpdateResult update(WeightRecordEntity weightRecordEntity) {
        Query query = Query.query(Criteria.where("id").is(weightRecordEntity.getId()));
        Update update = new Update();
        update.set("weightRecord", weightRecordEntity.getWeightRecord());
        update.set("type", weightRecordEntity.getType());
        update.set("recordTime", weightRecordEntity.getRecordTime());
        update.set("unit", weightRecordEntity.getUnit());
        return mongoTemplate.upsert(query, update, WeightRecordEntity.class);
    }

    public WeightRecordEntity getRecord(String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, WeightRecordEntity.class);
    }

    public List<WeightRecordEntity> getRecords(WeightRecordTimeVo weightRecordTimeVo, Integer userId) {
        Criteria criteria = Criteria.where("user_id").is(userId);
        criteria.and("record_time").lte(weightRecordTimeVo.getEndTime()).gte(weightRecordTimeVo.getStartTime());
        Query query = new Query(criteria);
        return mongoTemplate.find(query, WeightRecordEntity.class);
    }
}
