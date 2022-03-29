package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.web.*;

import java.util.List;


public interface UserService {

    String createUser(CreateUserRequest createUserRequest);

    GetUserResponse getUserByUserName(String userName);

    GetUserResponse getUserByUserId(String userId);

    GetUserInfoResponse getUserInfo();

    void updateUserInfo(UpdateUserRequest updateUserRequest);

    void deleteUserById(String userId);

    List<GetUserResponse> getAllUsers(boolean isDeleted);

    void updateUser(String userId, UpdateUserRequestFromAdmin updateUserRequestFromAdmin);
}