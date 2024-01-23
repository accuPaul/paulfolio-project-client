package com.paulmount.paulfolioprojectclient.web.client;

import com.paulmount.paulfolioprojectclient.web.model.ProjectDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProjectClientTest {

    @Autowired
    ProjectClient projectClient;

    @Test
    void testGetProjectById() {
        ProjectDto projectDto = projectClient.getProjectById(UUID.randomUUID());

        assertNotNull(projectDto);
    }

    @Test
    void testSaveNewProject() {
        ProjectDto projectDto = ProjectDto.builder().projectName("New Project").build();
        URI uri = projectClient.saveNewProject(projectDto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateProject() {
        ProjectDto projectDto = ProjectDto.builder().id(UUID.randomUUID()).projectName("New Project").build();
        projectClient.updateProject(projectDto.getId(), projectDto);
    }

    @Test
    void testDeleteProject() {
        projectClient.deleteProject(UUID.randomUUID());
    }
}