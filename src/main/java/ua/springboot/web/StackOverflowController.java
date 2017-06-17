package ua.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.springboot.model.StackoverflowWebsite;
import ua.springboot.service.StackoverflowService;

import java.util.List;

@RestController
@RequestMapping("/api/stackoverflow")
public class StackOverflowController {
    @Autowired
    private StackoverflowService stackoverflowService;

    @RequestMapping
    public List<StackoverflowWebsite> getListOfProviders() {
        return stackoverflowService.findAll();
    }
}
