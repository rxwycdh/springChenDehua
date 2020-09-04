package org.analysis.config;

import lombok.AllArgsConstructor;
import org.analysis.handler.SwaggerResourceHandler;
import org.analysis.handler.SwaggerSecurityHandler;
import org.analysis.handler.SwaggerUiHandler;
import org.analysis.props.AuthProperties;
import org.analysis.props.RouteProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * swagger功能路由
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:03
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties({RouteProperties.class, AuthProperties.class})
public class RouterFunctionConfiuguration {

    private final SwaggerResourceHandler swaggerResourceHandler;
    private final SwaggerSecurityHandler swaggerSecurityHandler;
    private final SwaggerUiHandler swaggerUiHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/swagger-resources")
                .and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }
}
