package ua.springboot.service;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.springboot.model.SiteDto;
import ua.springboot.model.SitesDto;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class StackExchangeClient {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);


    public List<SiteDto> getSites() {
        String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=9999&filter=!Fn4IB7S7T4v-QOAVmFyqlc(HdV";

        try {
            SitesDto response = restTemplate.getForObject(new URI(url), SitesDto.class);
            return response.getItems();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
