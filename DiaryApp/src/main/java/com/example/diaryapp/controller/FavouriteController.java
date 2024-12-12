package com.example.diaryapp.controller;

//import com.example.diaryapp.dto.FavouriteDTO;
//import com.example.diaryapp.entity.Favourite;
//import com.example.diaryapp.service.FavouriteService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/favourites")
//@RequiredArgsConstructor
//public class FavouriteController {
//    private final FavouriteService favouriteService;
//
//    @GetMapping
//    public List<Favourite> getAllFavourites() {
//        return favouriteService.getAllFavourites();
//    }
//
//    @GetMapping("/{id}")
//    public Favourite getFavouriteById(@PathVariable Long id) {
//        return favouriteService.getFavouriteById(id);
//    }
//
//    @PostMapping
//    public Favourite createFavourite(@RequestBody @Valid FavouriteDTO favouriteDTO) {
//        return favouriteService.createFavourite(favouriteDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFavourite(@PathVariable Long id) {
//        favouriteService.deleteFavourite(id);
//        return ResponseEntity.noContent().build();
//    }
//}


import com.example.diaryapp.dto.FavouriteDTO;
import com.example.diaryapp.entity.Favourite;
import com.example.diaryapp.service.FavouriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourites")
@RequiredArgsConstructor
public class FavouriteController {

    private final FavouriteService favouriteService;

    // Create a new favourite
    @PostMapping
    public ResponseEntity<Favourite> createFavourite(@RequestBody @Valid FavouriteDTO favouriteDTO) {
        Favourite favourite = favouriteService.createFavourite(favouriteDTO);
        return ResponseEntity.status(201).body(favourite);  // Return 201 Created status
    }

    // Get all favourites for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favourite>> getAllFavouritesByUser(@PathVariable Long userId) {
        List<Favourite> favourites = favouriteService.getAllFavouritesByUser(userId);
        return ResponseEntity.ok(favourites);  // Return list of favourites
    }

    // Get a specific favourite by ID
    @GetMapping("/{id}")
    public ResponseEntity<Favourite> getFavouriteById(@PathVariable Long id) {
        Favourite favourite = favouriteService.getFavouriteById(id);
        return ResponseEntity.ok(favourite);  // Return the favourite if found
    }

    // Delete a favourite by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavourite(@PathVariable Long id) {
        favouriteService.deleteFavourite(id);
        return ResponseEntity.noContent().build();  // Return 204 No Content status after deletion
    }
}