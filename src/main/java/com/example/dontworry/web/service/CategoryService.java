package com.example.dontworry.web.service;

import com.example.dontworry.domain.category.Category;
import com.example.dontworry.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> addCategory(
            List<String> categories

    ) throws Exception {
        List<Category> categoryList =new ArrayList<>();

        if(categories.isEmpty()){
            return categoryList;
        }


        for(String category : categories) {
            Category category1 = Category.builder()
                    .categoryName(category)
                    .build();
            categoryList.add(categoryRepository.save(category1));
        }

        return categoryList;
    }
}
