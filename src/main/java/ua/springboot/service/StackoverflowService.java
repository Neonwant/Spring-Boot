package ua.springboot.service;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ua.springboot.model.SiteDto;
import ua.springboot.model.StackoverflowWebsite;
import ua.springboot.persistence.StackoverflowWebsiteRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class StackoverflowService {
    @Autowired
    private StackoverflowWebsiteRepository repository;
    @Autowired
    private StackExchangeClient stackExchangeClient;

    public List<StackoverflowWebsite> findAll() {
        return stackExchangeClient.getSites().stream()
                .map(this::toStackoverflowWebsite)
                .filter(this::ignoreMeta)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(@NonNull StackoverflowWebsite stackoverflowWebsite) {
        return !stackoverflowWebsite.getId().startsWith("meta.");
    }

    private StackoverflowWebsite toStackoverflowWebsite(@NonNull SiteDto input) {
        return new StackoverflowWebsite(
                input.getSite_url().substring("http://".length() + 1, input.getSite_url().length() - ".com".length()),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());
    }
    // for initial database
    /*private static List<StackoverflowWebsite> items = new ArrayList<>();
    static {
        items.add(new StackoverflowWebsite("stackoverflow", "http://stackoverflow.com", "http://www.iconsdb.com/icons/download/orange/stackoverflow-6-64.ico", "Stack Overflow", "for programmers"));
        items.add(new StackoverflowWebsite("superuser", "http://superuser.com", "http://www.iconsdb.com/icons/download/color/CFFF30/linkedin-3-64.ico", "Super User", "for power user"));
    }
    @PostConstruct
    public void init() {
        repository.save(items);
    }*/


    /*public List<StackoverflowWebsite> findAll() {
        return repository.findAll();
    }*/
}
