package com.paulmount.paulfolioprojectclient.web.client;

import com.paulmount.paulfolioprojectclient.web.model.TagDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "paulfolio.project", ignoreUnknownFields = false)
public class TagClient {

    private final String TAG_PATH = "/api/tag";
    private String apiHost;
    private final RestTemplate restTemplate;


    public TagClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public TagDto getTagById(UUID uuid) {
        return restTemplate.getForObject(apiHost + TAG_PATH +"/"+uuid.toString(), TagDto.class);
    }

    public URI saveNewTag(TagDto tagDto) {
        return restTemplate.postForLocation(apiHost+TAG_PATH, tagDto);
    }

    public void updateTag(UUID uuid, TagDto tagDto) {
        restTemplate.put(apiHost+TAG_PATH+"/"+uuid.toString(), tagDto);
    }

    public void deleteTag(UUID uuid) {
        restTemplate.delete(apiHost+TAG_PATH+"/"+uuid.toString());
    }
}
