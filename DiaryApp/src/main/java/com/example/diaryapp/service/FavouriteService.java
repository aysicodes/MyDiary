package com.example.diaryapp.service;


//import com.example.diaryapp.dto.FavouriteDTO;
//import com.example.diaryapp.entity.Favourite;
//import com.example.diaryapp.entity.Post;
//import com.example.diaryapp.entity.User;
//import com.example.diaryapp.repository.FavouriteRepository;
//import com.example.diaryapp.repository.PostRepository;
//import com.example.diaryapp.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class FavouriteService {
//    private final FavouriteRepository favouriteRepository;
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
//
//    public List<Favourite> getAllFavourites() {
//        return favouriteRepository.findAll();
//    }
//
//    public Favourite getFavouriteById(Long id) {
//        return favouriteRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Favourite not found"));
//    }
//
//    public Favourite createFavourite(FavouriteDTO favouriteDTO) {
//        User user = userRepository.findById(favouriteDTO.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        Post post = postRepository.findById(favouriteDTO.getPostId())
//                .orElseThrow(() -> new RuntimeException("Post not found"));
//
//        Favourite favourite = Favourite.builder()
//                .user(user)
//                .post(post)
//                .build();
//        return favouriteRepository.save(favourite);
//    }
//
//    public void deleteFavourite(Long id) {
//        favouriteRepository.deleteById(id);
//    }
//}


import com.example.diaryapp.dto.FavouriteDTO;
import com.example.diaryapp.entity.Favourite;

import java.util.List;

public interface FavouriteService {
    Favourite createFavourite(FavouriteDTO favouriteDTO);
    List<Favourite> getAllFavouritesByUser(Long userId);
    Favourite getFavouriteById(Long id);
    void deleteFavourite(Long id);
}
