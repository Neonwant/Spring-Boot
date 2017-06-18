package ua.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ua.springboot.model.StackoverflowWebsite;
import ua.springboot.persistence.StackoverflowWebsiteRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class StackoverflowService {
    @Autowired
    private StackoverflowWebsiteRepository repository;

    private static List<StackoverflowWebsite> items = new ArrayList<>();
//    static {
//        items.add(new StackoverflowWebsite("stackoverflow", "http://stackoverflow.com", "http://www.iconsdb.com/icons/download/orange/stackoverflow-6-64.ico", "Stack Overflow", "for programmers"));
//        items.add(new StackoverflowWebsite("superuser", "http://superuser.com", "http://www.iconsdb.com/icons/download/color/CFFF30/linkedin-3-64.ico", "Super User", "for power user"));
//    }

//    @PostConstruct
//    public void init() {
//        repository.save(items);
//    }

    public List<StackoverflowWebsite> findAll() {
        return repository.findAll();
    }
}
