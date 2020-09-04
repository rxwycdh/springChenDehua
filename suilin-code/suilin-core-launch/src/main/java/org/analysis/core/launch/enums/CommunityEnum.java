package org.analysis.core.launch.enums;


/**
 * 小区统一配置
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/27 21:25
 */
public enum CommunityEnum {

    /**
     * 好时光社区
     */
    GOODTIME_COMMUNITY("goodTime",
            "小区-好时光社区",
            "jdbc:mysql://xxx:3306/sbo_suilin?useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
            "xxxx",
            "xxx",
            "8087"),
    /**
     * 聚福苑社区
     */
    FORTUNEGARDEN_COMMUNITY("fortuneGarden",
            "小区-聚福苑社区",
            "jdbc:mysql://127.0.0.1:3306/sbo_suilin?useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
            "root",
            "xxxx",
            "8088");

    /**
     * 数据库url
     */
    public String url;

    /**
     * 数据库用户名
     */
    public String username;

    /**
     * 数据库密码
     */
    public String password;

    /**
     * 社区中文名称
     */
    public String cnValue;

    /**
     * 社区英文名称
     */
    public String value;

    /**
     * 项目启动端口号
     */
    public String port;

    CommunityEnum(String value, String cnValue, String url, String username, String password, String port) {
        this.url = url;
        this.cnValue = cnValue;
        this.username = username;
        this.password = password;
        this.value = value;
        this.port = port;
    }
}
