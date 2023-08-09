package com.example.crm.service;

import com.example.crm.entity.Template;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public interface TemplateService {
    Page<Template> paginationTemplate (Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy);

    //save template directly on server
    public  void init();
    public void save(MultipartFile file);
    public Resource load(String filename);
    public boolean delete(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}
