package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.attach.AttachDTO;
import com.company.YouTubeProject.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/attach")
public class AttachController {
    @Autowired
    private AttachService attachService;

    @PostMapping("/public/get")
    public ResponseEntity<byte[]> getById(@RequestParam("id") String id) {
        byte[] byId = attachService.getById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping("/public/upload")
    public ResponseEntity<AttachDTO> upload(@RequestParam("file") MultipartFile file) {
        AttachDTO res = attachService.upload(file);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping(value = "/open_general/{fileName}", produces = MediaType.ALL_VALUE)
    public byte[] open_general(@PathVariable("fileName") String fileName) {
        return attachService.open_general(fileName);
    }

}
