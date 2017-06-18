package ua.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class StackoverflowWebsite {
    @Id
    private String id;
    private String website;
    private String iconImageUrl;
    private String title;
    private String description;

    // @Data is used for generating getters/setter and constructors
}