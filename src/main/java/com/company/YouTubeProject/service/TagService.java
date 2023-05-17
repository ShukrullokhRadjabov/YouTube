package com.company.YouTubeProject.service;

import com.company.YouTubeProject.entity.TagEntity;
import com.company.YouTubeProject.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Boolean isHasTag(String name) {
        Optional<TagEntity> tag = tagRepository.findByName(name);
        if (tag.isEmpty()) return false;
        else return true;
    }

    public String create(String name) {
//        if (isHasTag(name)) {
//            return "Tag already created !";
//        }
        TagEntity tagEntity = new TagEntity();
        tagEntity.setName(name);
        tagEntity.setCreatedDate(LocalDateTime.now());
        tagRepository.save(tagEntity);
        return name;
    }
}