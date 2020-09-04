package org.analysis.props;

import lombok.Data;
import org.analysis.core.launch.constant.*;

/**
 * 文档模块配置
 * @author ChenDehua  597701764@qq.com
 * @date 2020/8/28 10:25
 */
@Data
public class RouteResource {

    /**
     * 文档名
     */
    private String name;

    /**
     * 文档所在服务地址
     */
    private String location;

    /**
     * 文档版本
     */
    private String version = AppConstant.APPLICATION_VERSION;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

