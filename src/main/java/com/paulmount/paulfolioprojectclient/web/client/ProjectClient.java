package com.paulmount.paulfolioprojectclient.web.client;

import com.paulmount.paulfolioprojectclient.web.model.ProjectDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 *  Created 2024-01-23 Paul M
 */
@Component
@ConfigurationProperties(value = "paulfolio.project", ignoreUnknownFields = false)
public class ProjectClient {

    private final String PROJECT_PATH = "/api/project";
    private String apiHost;
    private final RestTemplate restTemplate;

    public ProjectClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ProjectDto getProjectById(UUID uuid) {
        return restTemplate.getForObject(apiHost + PROJECT_PATH +"/"+uuid.toString(), ProjectDto.class);
    }

    public URI saveNewProject(ProjectDto projectDto) {
        return restTemplate.postForLocation(apiHost+PROJECT_PATH, projectDto);
    }

    public void updateProject(UUID uuid, ProjectDto projectDto) {
        restTemplate.put(apiHost + PROJECT_PATH + "/" + uuid.toString(), projectDto);
    }

    public void deleteProject(UUID uuid) {
        restTemplate.delete(apiHost + PROJECT_PATH + "/" + uuid.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
