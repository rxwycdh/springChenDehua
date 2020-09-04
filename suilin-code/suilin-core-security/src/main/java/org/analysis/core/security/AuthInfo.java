package org.analysis.core.security;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/29 11:32
 */
@Data
public class AuthInfo {

    @ApiModelProperty("令牌")
    private String accessToken;
    @ApiModelProperty("令牌类型")
    private String tokenType;
    @ApiModelProperty("用户ID")
    @JsonSerialize(
            using = ToStringSerializer.class
    )
    private String userId;
    @ApiModelProperty("第三方系统ID")
    private String oauthId;
    @ApiModelProperty("头像")
    private String avatar = "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png";
    @ApiModelProperty("角色名")
    private String authority;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("账号名")
    private String account;
    @ApiModelProperty("过期时间")
    private long expiresIn;
    @ApiModelProperty("许可证")
    private String license = "powered by SpringSuilin";
}
