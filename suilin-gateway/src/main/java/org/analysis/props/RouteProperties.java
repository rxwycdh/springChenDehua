package org.analysis.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块路由配置
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:23
 */
@Data
//@RefreshScope
@ConfigurationProperties("suilin.document")
public class RouteProperties {

    private final List<RouteResource> resources = new ArrayList<>();

    public List<RouteResource> getResources() {
        return resources;
    }
}
