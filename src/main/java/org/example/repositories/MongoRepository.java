package org.example.repositories;


import com.mongodb.client.result.UpdateResult;
import org.example.models.Inmate;
import org.example.models.Property;
import org.example.models.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

@Repository
public class MongoRepository {

    @Autowired
    MongoTemplate mongoTemplate;


    public Inmate createOrUpdateInmate(Inmate inmate) {
        return mongoTemplate.insert(inmate);
    }

    public Long updateInmate(Inmate inmate) {
        UpdateResult updateResult = mongoTemplate.updateFirst(Query.query(where("inmateId").is(inmate.getInmateId())),
                update("status", inmate.getStatus()), Inmate.class);
        return  updateResult.getMatchedCount();
    }

    public List<Staff> getStaffByPropertyId(String propertyId) {
        Query query = new Query(where("propertyId").is(propertyId));
        return  mongoTemplate.find(query, Staff.class);
    }

    public List<Inmate> getInmates(String propertyId) {
        Query query = new Query(where("propertyId").is(propertyId));
        return mongoTemplate.find(query, Inmate.class);
    }
    public <T> T createEntity(T entity) {
        return mongoTemplate.insert(entity);
    }
    public <T>  T getEntityById(String id, Class<T> entityClass) {
        return mongoTemplate.findById(id, entityClass);
    }
}
