package org.analysis.core.launch.constant;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/27 11:44
 */
public interface AppConstant {

    /**
     * 应用版本
     */
    String APPLICATION_VERSION = "1.1.0";

    /**
     * 基础包
     */
    String BASE_PACKAGES = "org.analysis";

    /**
     * 应用名前缀
     */
    String APPLICATION_NAME_PREFIX = "suilin-";

    /**
     * 应用名前缀
     */
    String APPLICATION_COMMUNITY_NAME_PREFIX = APPLICATION_NAME_PREFIX + "community-";
    /**
     * 网关模块名称
     */
    String APPLICATION_GATEWAY_NAME = APPLICATION_NAME_PREFIX + "gateway";

    /**
     * 系统模块名称
     */
    String APPLICATION_SYSTEM_NAME = APPLICATION_NAME_PREFIX + "system";

    /**
     * 日志模块名称(未开发)
     */
    String APPLICATION_LOG_NAME = APPLICATION_NAME_PREFIX + "log";

    /**
     * 开发环境
     */
    String DEV_CODE = "dev";
    /**
     * 生产环境
     */
    String PROD_CODE = "prod";
    /**
     * 测试环境
     */
    String TEST_CODE = "test";

    /**
     * 代码部署于 linux 上，工作默认为 mac 和 Windows
     */
    String OS_NAME_LINUX = "LINUX";
}
