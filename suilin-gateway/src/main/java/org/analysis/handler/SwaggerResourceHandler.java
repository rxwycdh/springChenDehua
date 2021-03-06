package org.analysis.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:09
 */
@Component
@RequiredArgsConstructor
public class SwaggerResourceHandler implements HandlerFunction<ServerResponse> {

    private final SwaggerResourcesProvider swaggerResourcesProvider;

    /**
     * Handle the given request.
     *
     * @param request the request to handle
     * @return the response
     */
    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(swaggerResourcesProvider.get()));
    }
}
