package com.example.diaryapp.service.impl;

import com.example.diaryapp.dto.FavouriteDTO;
import com.example.diaryapp.entity.Favourite;
import com.example.diaryapp.entity.Post;
import com.example.diaryapp.entity.User;
import com.example.diaryapp.repository.FavouriteRepository;
import com.example.diaryapp.repository.PostRepository;
import com.example.diaryapp.repository.UserRepository;
import com.example.diaryapp.service.FavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FavouriteServiceImpl implements FavouriteService {

    private final FavouriteRepository favouriteRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public Favourite createFavourite(FavouriteDTO favouriteDTO) {
        // Fetch the user and post using the provided IDs
        User user = userRepository.findById(favouriteDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Post post = postRepository.findById(favouriteDTO.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        // Create and save the new Favourite entity
        Favourite favourite = Favourite.builder()
                .user(user)
                .post(post)
                .build();

        return favouriteRepository.save(favourite);
    }

    @Override
    public List<Favourite> getAllFavouritesByUser(Long userId) {
        // Fetch and return all favourites for a specific user
        return favouriteRepository.findByUserId(userId);
    }

    @Override
    public Favourite getFavouriteById(Long id) {
        // Fetch and return a specific favourite by its ID
        return favouriteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Favourite not found"));
    }

    @Override
    public void deleteFavourite(Long id) {
        // Delete the favourite by its ID
        if (!favouriteRepository.existsById(id)) {
            throw new IllegalArgumentException("Favourite with ID " + id + " not found");
        }
        favouriteRepository.deleteById(id);
    }
}