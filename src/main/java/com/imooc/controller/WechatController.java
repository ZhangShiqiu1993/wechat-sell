package com.imooc.controller;

import com.imooc.config.WechatMpConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/auth")
    public void authorize(@RequestParam("returnUrl") String returnUrl) {
        WxMpService wxMpService = new WxMpServiceImpl();

        wxMpService.oauth2buildAuthorizationUrl(returnUrl ,WxConsts.OAUTH2_SCOPE_USER_INFO, null);

    }

    @GetMapping("/userInfo")
    public void userInfo() {

    }
}

