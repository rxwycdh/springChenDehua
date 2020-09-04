package org.analysis.controller;

import api.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;


import org.analysis.core.security.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 10:26
 */
@RestController
@AllArgsConstructor
@Api(value = "用户授权认证", tags = "授权接口")
public class AuthController {

    private JwtUtil jwtUtil;

    @PostMapping("/token")
    @ApiOperation("总系统管理员获取token")
    public AjaxResult<AuthInfo> token(@RequestParam(defaultValue = "password")String grantType,
                                      @RequestParam String account,
                                      @RequestParam String password,
                                      HttpServletRequest request) {

//        String userType = Func.toStr(request.getHeader(TokenUtil.USER_TYPE_HEADER_KEY), request.getHeader(TokenUtil.DEFAULT_USER_TYPE));
        TokenParameter tokenParameter = new TokenParameter();
        String userType = "web";

        tokenParameter.getArgs()
                .set("account", account)
                .set("password", password)
                .set("grantType", grantType)
                .set("userType", userType);

        ITokenGranter granter = TokenGranterBuilder.getGranter(grantType);
        UserInfo userInfo = granter.grant(tokenParameter);

        if (userInfo == null || userInfo.getPassword() == null || userInfo.getAccount() == null) {
            return AjaxResult.error(JwtUtil.USER_NOT_FOUND);
        }

        return AjaxResult.successData(jwtUtil.create(userInfo));
    }
}
