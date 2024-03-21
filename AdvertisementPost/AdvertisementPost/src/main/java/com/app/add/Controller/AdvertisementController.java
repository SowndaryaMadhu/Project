package com.app.add.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.add.Model.Advertisement;
import com.app.add.Service.AdvertisementService;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable Long id) {
        Advertisement advertisement = advertisementService.getAdvertisementById(id);
        if (advertisement != null) {
            return ResponseEntity.ok(advertisement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement createdAdvertisement = advertisementService.createAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdvertisement);
    }

 
    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateAdvertisement(@PathVariable Long id, @RequestBody Advertisement advertisementDetails) {
        Advertisement advertisement = advertisementService.getAdvertisementById(id);
        if (advertisement != null) {
            
            if (advertisementDetails.getTitle() != null) {
                advertisement.setTitle(advertisementDetails.getTitle());
            }
            if (advertisementDetails.getDescription() != null) {
                advertisement.setDescription(advertisementDetails.getDescription());
            }
            if (advertisementDetails.getContent() != null) {
                advertisement.setContent(advertisementDetails.getContent());
            }
//            if (advertisementDetails.getLikes() >= 0) {
//                advertisement.setLikes(advertisementDetails.getLikes());
//            }
            if (advertisementDetails.getImageUrl() != null) {
                advertisement.setImageUrl(advertisementDetails.getImageUrl());
            }
            Advertisement updatedAdvertisement = advertisementService.updateAdvertisement(advertisement);
            return ResponseEntity.ok(updatedAdvertisement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.ok("Advertisement with ID " + id + " deleted successfully");
    }
}

