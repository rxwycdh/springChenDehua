package org.analysis.core.launch.constant;

/**
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/26 21:17
 */
public interface NacosConstant {

    /**
     * nacos 地址
     */
    String NACOS_ADDR = "127.0.0.1:8848";

    /**
     * nacos json配置文件类型
     */
    String NACOS_CONFIG_JSON_FORMAT = "json";

    /**
     * nacos 是否刷新
     */
    String NACOS_CONFIG_REFRESH = "true";

    /**
     * nacos 分组
     */
    String NACOS_CONFIG_GROUP = "DEFAULT_GROUP";


    /**
     * nacos 组配置后缀
     */
    String NACOS_GROUP_SUFFIX = "-group";

}
