package com.example.dontworry.web.service;
//
//import com.example.dontworry.domain.category.Category;
//import com.example.dontworry.domain.category.CategoryRepository;
import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.domain.posts.PostsRepository;
import com.example.dontworry.domain.user.User;
import com.example.dontworry.web.dto.MainResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostsRepository postsRepository;


//    private final CategoryRepository categoryRepository;
    public Posts addPosts(Posts posts){
        return postsRepository.save(posts);
    }

    public List<MainResDto> findAllByUser(User user) {

        List<Long> allById = postsRepository.SearchAllById(user).orElseThrow();

        List<MainResDto> result = new ArrayList<>();

        for (Long id : allById){
            MainResDto mainResDto = postsRepository.findAllByUser(user,id).orElseThrow();
            result.add(mainResDto);
        }
        return result;
    }

    public List<MainResDto> searchAllByIdAndCategory(User user, String Category){
        List<Long> allById = postsRepository.SearchAllById(user).orElseThrow();

        List<MainResDto> result = new ArrayList<>();

        for (Long id : allById){
            MainResDto mainResDto = postsRepository.searchAllByIdAndCategory(user,Category,id).orElseThrow();
            result.add(mainResDto);
        }
        return result;
    }


//
//    public List<Category> createPostAndCategories(List<String> list) {
//
//            List<Category> categories = new ArrayList<>();
//
//            for(String categoryName : list) {
//                Category category = Category.builder()
//                        .categoryName(categoryName)
//                        .build();
//
//                categories.addCategory(category);
//            }
//
//            return categories;
//    }
}
