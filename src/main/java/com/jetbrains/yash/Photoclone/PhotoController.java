package com.jetbrains.yash.Photoclone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@RestController
public class PhotoController {

    private final PhotosService photosService;

    public PhotoController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/photos")
    public Collection<Photo> get(){
        return photosService.get();
    }
    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = PhotosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo = PhotosService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = PhotosService.save(file.getOriginalFilename(),file.getBytes());
        return photo;
    }
}
