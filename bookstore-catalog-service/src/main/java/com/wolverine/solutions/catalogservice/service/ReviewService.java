package com.wolverine.solutions.catalogservice.service;

import com.wolverine.solutions.catalogservice.repository.dao.Review;
import com.wolverine.solutions.catalogservice.web.CreateOrUpdateReviewRequest;

import java.util.List;


public interface ReviewService {

    void createOrUpdateReview(CreateOrUpdateReviewRequest createOrUpdateReviewRequest);

    List<Review> getReviewsForProduct(String productId);

}
