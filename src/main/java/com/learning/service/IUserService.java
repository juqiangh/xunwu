package com.learning.service;

import com.learning.entity.User;

/**
 * 用户服务
 */
public interface IUserService {

    User findUserByName(String userName);
}
