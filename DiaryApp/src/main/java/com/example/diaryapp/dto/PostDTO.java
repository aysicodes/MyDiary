package com.example.diaryapp.dto;

import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String content;
    private Long userId; // To associate with a User
    private String status;
    private String image;
}
