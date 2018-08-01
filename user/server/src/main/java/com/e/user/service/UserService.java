package com.e.user.service;

import com.e.user.dataobject.UserInfo;

public interface UserService {

	UserInfo findByOpenid(String openid);
}
