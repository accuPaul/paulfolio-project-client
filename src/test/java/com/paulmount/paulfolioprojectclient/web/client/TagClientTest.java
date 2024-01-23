package com.paulmount.paulfolioprojectclient.web.client;

import com.paulmount.paulfolioprojectclient.web.model.TagDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TagClientTest {

    @Autowired
    TagClient client;

    @Test
    void getTagById() {
        TagDto tagDto = client.getTagById(UUID.randomUUID());

        assertNotNull(tagDto);
    }

    @Test
    void saveNewTag() {
        TagDto tagDto = TagDto.builder().id(UUID.randomUUID()).name("TEST TAG").build();
        URI uri = client.saveNewTag(tagDto);

        assertNotNull(uri);
    }

    @Test
    void updateTag() {
        TagDto tagDto = TagDto.builder().id(UUID.randomUUID()).name("UPDATED TAG").build();
        client.updateTag(tagDto.getId(), tagDto);
    }

    @Test
    void deleteTag() {
        client.deleteTag(UUID.randomUUID());
    }
}