package ua.springboot.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.springboot.model.StackoverflowWebsite;

import java.util.List;

@Repository
public interface StackoverflowWebsiteRepository extends MongoRepository<StackoverflowWebsite, String> {
    List<StackoverflowWebsite> findAllByWebsite(String website);

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public List<StackoverflowWebsite> findAll() {
//        return mongoTemplate.findAll(StackoverflowWebsite.class);
//    }
}
