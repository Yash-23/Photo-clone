package com.jetbrains.yash.Photoclone.Service;

import com.jetbrains.yash.Photoclone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosService {
    private static Map<String, Photo> db = new HashMap<>(){{
        put("1",new Photo("1","hello.jpg"));
    }};

    public static Photo get(String id) {
        return db.get(id);
    }

    public static Photo remove(String id) {
        return db.remove(id);
    }

    public static Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }

    public Collection<Photo> get() {
        return db.values();
    }
}
