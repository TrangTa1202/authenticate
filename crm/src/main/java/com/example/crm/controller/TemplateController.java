package com.example.crm.controller;

import com.example.crm.entity.Template;
import com.example.crm.payload.FileResponse;
import com.example.crm.repository.TemplateRepository;
import com.example.crm.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    TemplateService templateService;
    @Autowired
    TemplateRepository templateRepository;

    @GetMapping("/paging")
    public ResponseEntity<Page<Template>> paginationTemplate(
            @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size, @RequestParam Optional<String> sortBy) {
        return new  ResponseEntity<>(templateService.paginationTemplate(page, size, sortBy), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadTemplate(/*@RequestBody Template template,*/ @RequestParam("file") MultipartFile file){ //remember to pass request body
        String message ="";
        try {
//            Template template1 = new Template();
//
//            template1.setName(file.getOriginalFilename());
//            template1.setType(file.getContentType());
//            template1.setSubject(template.getSubject());
//            template1.setContent(template.getContent());
//
//            templateRepository.save(template1);
            templateService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileResponse(message));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Template>> getAllTemplate() {
        List<Template> templates = templateRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(templates);
    }

    @GetMapping("/{filename:.+}") //url can down the template
    public ResponseEntity<Resource> getTemplate(@PathVariable String filename) {
        Resource template = templateService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + template.getFilename() + "\"")
                .body(template);
    }

    @DeleteMapping("/{filename:.+}")
    public ResponseEntity<?> deleteTemplate(@PathVariable String filename) {
        String message = "";
        try {
            boolean existed = templateService.delete(filename);
            if (existed) {
                message = "Delete the file successfully: " + filename;
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
            }
            message = "The template does not exist!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } catch (Exception e) {
            message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }
}
