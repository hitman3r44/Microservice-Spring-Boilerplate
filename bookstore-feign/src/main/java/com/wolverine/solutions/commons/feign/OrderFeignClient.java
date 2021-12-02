package com.wolverine.solutions.commons.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("bookstore-order-service")
public interface OrderFeignClient {


}
