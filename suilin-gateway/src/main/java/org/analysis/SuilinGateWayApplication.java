package org.analysis;

import org.analysis.core.launch.constant.*;
import org.analysis.core.launch.SuilinApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/27 11:39
 */
//@EnableHystrix
@SpringBootApplication
public class SuilinGateWayApplication {

    public static void main(String[] args) {
        SuilinApplication.run(AppConstant.APPLICATION_GATEWAY_NAME,
                SuilinGateWayApplication.class, args);
    }
}
