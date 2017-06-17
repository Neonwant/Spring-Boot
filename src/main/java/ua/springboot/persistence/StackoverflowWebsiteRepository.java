package ua.springboot.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ua.springboot.model.StackoverflowWebsite;

import java.util.List;

@Repository
public class StackoverflowWebsiteRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public List<StackoverflowWebsite> findAll() {
        return mongoTemplate.findAll(StackoverflowWebsite.class);
    }
}
