package org.analysis;


import org.analysis.core.launch.SuilinApplication;
import org.analysis.core.launch.constant.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:35
 */
@SpringBootApplication
public class SuilinSystemApplication {

    public static void main(String[] args) {
        SuilinApplication.run(AppConstant.APPLICATION_SYSTEM_NAME,
                SuilinSystemApplication.class, args);
    }
}
