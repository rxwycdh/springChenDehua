package org.analysis.provider;

import lombok.AllArgsConstructor;
import org.analysis.core.launch.constant.*;
import org.analysis.core.launch.enums.*;

import org.analysis.props.RouteProperties;
import org.analysis.props.RouteResource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:18
 */
@Primary
@Component
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {

    private static final String API_URI = "/v2/api-docs-ext";

    private RouteProperties routeProperties;

    private DiscoveryClient discoveryClient;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();

        CommunityEnum[] communityEnums = CommunityEnum.values();
        List<RouteResource> resourcesList = routeProperties.getResources();

        List<CommunityEnum> routeResources = new ArrayList<>(Arrays.asList(communityEnums));

        routeResources.forEach(routeResource -> resources.add(swaggerResource(routeResource)));
        resourcesList.forEach(routeResource -> resources.add(swaggerResource(routeResource)));

        SwaggerResource resource = new SwaggerResource();
        resource.setName("总系统模块");
        resource.setLocation("suilin-system/v2/api-docs");
        resource.setSwaggerVersion("2.7.0");
        resources.add(resource);
        return resources;
    }

    private <T> SwaggerResource swaggerResource(T community) {

        SwaggerResource swaggerResource = new SwaggerResource();
        if(community instanceof CommunityEnum) {
            CommunityEnum communityEnum = (CommunityEnum)community;
            List<ServiceInstance> list = discoveryClient
                    .getInstances(AppConstant.APPLICATION_COMMUNITY_NAME_PREFIX.concat(communityEnum.value));

            ServiceInstance serviceInstance = list.get(0);

            swaggerResource.setName(communityEnum.cnValue);
            swaggerResource.setLocation(serviceInstance.getServiceId().concat(API_URI));
            swaggerResource.setSwaggerVersion(AppConstant.APPLICATION_VERSION);
        }else {
            RouteResource communityResource = (RouteResource)community;
            swaggerResource.setName(communityResource.getName());
            swaggerResource.setLocation(communityResource.getLocation().concat(API_URI));
            swaggerResource.setSwaggerVersion(communityResource.getVersion());
        }

        return swaggerResource;
    }
}
