package com.ahuiali.weight_record;

import com.ahuiali.weight_record.entity.WeightRecordEntity;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

/**
 * AddTest
 *
 * @author ZhengChaoHui
 * @date 2021/8/2 19:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testAdd() {
        WeightRecordEntity weightRecordEntity = new WeightRecordEntity();
        weightRecordEntity.setRecordTime(Calendar.getInstance().getTime());
        weightRecordEntity.setType("早饭");
        weightRecordEntity.setUnit("kg");
        weightRecordEntity.setWeightRecord(47.70);
        WeightRecordEntity save = mongoTemplate.save(weightRecordEntity);
        System.out.println(save.toString());
    }

    @Test
    public void testQuery() {
        Query query = Query.query(Criteria.where("Id").is("610a8d5d290b12158f650b3f"));
        WeightRecordEntity one = mongoTemplate.findOne(query, WeightRecordEntity.class);

        System.out.println(one);
    }

    @Test
    public void testUpdate() {
        Query query = Query.query(Criteria.where("Id").is("6107fe35872e6918f5a07df7"));
        Update update = new Update();
        update.set("weight_record", 49.35);
        UpdateResult upsert = mongoTemplate.upsert(query, update, WeightRecordEntity.class);
        // 输出：AcknowledgedUpdateResult{matchedCount=1, modifiedCount=1, upsertedId=null}
        System.out.println(upsert);
    }

}

