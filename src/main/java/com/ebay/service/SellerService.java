package com.ebay.service;

import com.ebay.dataobject.SellerInfo;

public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
