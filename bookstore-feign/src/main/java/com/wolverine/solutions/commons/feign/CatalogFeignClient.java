package com.wolverine.solutions.commons.feign;

import com.wolverine.solutions.commons.web.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookstore-catalog-service")
public interface CatalogFeignClient {

    @GetMapping("/product/{productId}")
    GetProductResponse getProduct(@PathVariable("productId") String productId);

}
