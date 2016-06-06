package com.water.db.service;

import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
public interface IUserService {

    String SERVICE_NAME = "com.water.db.service.impl.UserServiceImpl";

    Map<String,Object> findUserByNameAndPwd(String username, String pwd);
}
