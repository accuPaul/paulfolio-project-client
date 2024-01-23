package com.paulmount.paulfolioprojectclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created 2024-01-22 Paul M
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
    private UUID id;
    private String projectName;
    private String description;
    private String link;
    private String githubLink;
    private List<TagDto> tags;

    void addTag(String tag) {
        if (this.tags == null) this.tags = new ArrayList<>();
        this.tags.add(TagDto.builder().id(UUID.randomUUID()).name(tag).build());
    }
    void addTag(TagDto newTag) {
        if (this.tags == null) this.tags = new ArrayList<>();
        this.tags.add(newTag);
    }
}
