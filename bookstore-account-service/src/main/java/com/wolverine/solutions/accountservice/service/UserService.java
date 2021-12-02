package com.wolverine.solutions.accountservice.service;

import com.wolverine.solutions.accountservice.web.CreateUserRequest;
import com.wolverine.solutions.accountservice.web.GetUserInfoResponse;
import com.wolverine.solutions.accountservice.web.GetUserResponse;
import com.wolverine.solutions.accountservice.web.UpdateUserRequest;
import com.wolverine.solutions.accountservice.web.UpdateUserRequestFromAdmin;

import java.util.List;


public interface UserService {

  String createUser(CreateUserRequest createUserRequest);

  GetUserResponse getUserByUserName(String userName);

  GetUserResponse getUserByUserId(String userId);

  GetUserInfoResponse getUserInfo();

  void updateUserInfo(UpdateUserRequest updateUserRequest);

  void deleteUserById(String userId);

  List<GetUserResponse> getAllUsers();

  void updateUser(String userId, UpdateUserRequestFromAdmin updateUserRequestFromAdmin);
}
