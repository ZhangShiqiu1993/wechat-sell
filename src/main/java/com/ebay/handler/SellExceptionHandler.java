package com.ebay.handler;

import com.ebay.VO.ResultVO;
import com.ebay.config.ProjectUrlConfig;
import com.ebay.exception.SellException;
import com.ebay.exception.SellerAuthorizeException;
import com.ebay.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException() {
        String redirect = "redirect:"
                            .concat(projectUrlConfig.getWechatOpenAuthorize())
                            .concat("/sell/wechat/qrAuthorize")
                            .concat("?returnUrl=")
                            .concat(projectUrlConfig.getSell())
                            .concat("/sell/seller/login");
        return new ModelAndView(redirect);
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

}
