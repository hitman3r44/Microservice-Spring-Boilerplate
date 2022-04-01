package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.enums.request.CreateUserRequest;
import com.wolverine.solutions.accountservice.enums.request.UpdateUserRequest;
import com.wolverine.solutions.accountservice.enums.request.UpdateUserRequestFromAdmin;
import com.wolverine.solutions.accountservice.enums.response.GetUserInfoResponse;
import com.wolverine.solutions.accountservice.enums.response.GetUserResponse;

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

    void restoreUserById(String userId);
}