基于SpringCloud Alibaba的分布式子系统项目，包括swagger文档自动配置，注册中心服务发现，路由转发，总系统鉴权，还不是很完善。

## 架构图

![](https://chendehuablog.oss-cn-hangzhou.aliyuncs.com/springChenDehua.jpg)

## 工程结构

```bash
SpringSuilin
├─suilin-code -- 工程核心源码模块
├─suilin-common -- 常用工程封装包
├─suilin-community -- 子系统模块
├─suilin-gateway -- Spring Cloud 网关
└─suilin-system -- 综合管理系统模块
```

## 使用说明

适用于 子系统同一个项目，但需要配置不同数据库，由网关负责转发到各个子系统，另外需要有总系统管理子系统的场景。

### 创建子系统工程

新增模块为子系统工程，引入依赖：

```xml

       <dependency>
            <groupId>org.analysis</groupId>
            <artifactId>suilin-core-launch</artifactId>
            <version>${suilin.tool.version}</version>
        </dependency>

        <!-- Nacos -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
            <version>${alibaba.cloud.version}</version>
        </dependency>

        <dependency>
            <groupId>org.analysis</groupId>
            <artifactId>suilin-core-swagger</artifactId>
            <version>${suilin.tool.version}</version>
        </dependency>
```

启动类示例，根据实际修改：

```java
package org.analysis;
import cn.hutool.core.util.StrUtil;
import org.analysis.core.launch.SuilinApplication;
import org.analysis.core.launch.enums.CommunityEnum;
import org.analysis.core.launch.constant.*;
import org.analysis.projects.suilin.SuilinSystemApplication;
import org.analysis.system.SystemApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class SpringbootOMGStart {

    public static void main(String[] args) {

        if(args == null || args.length == 0) {
            throw new RuntimeException("没有指定子系统名称，请输入子系统英文名称作为参数启动，详见suilin-common CommunityEnum");
        }
        String name = args[0];

        CommunityEnum[] communities = CommunityEnum.values();
        CommunityEnum community = null;

        for (CommunityEnum anEnum : communities) {
            if(anEnum.value.equals(name)) {
                community = anEnum;
            }
        }
        if(community == null) {
            throw new RuntimeException("找不到对应子系统！");
        }

        SuilinApplication.runCommunity(
                AppConstant.APPLICATION_COMMUNITY_NAME_PREFIX.concat(community.value),
                new Class[]{ SuilinSystemApplication.class},
                community, args);

        System.out.println("=================================");
        System.out.println(StrUtil.format("==========={}子系统启动成功，端口{}，数据库连接{}===========",
                community.cnValue, community.port, community.url) );
        System.out.println("=================================");
    }
}
```

### 为子系统配置不同数据库

### 指定启动小区

`suilin-core`模块下`org.analysis.core.launch.enums.CommunityEnum`新增小区所使用的数据库地址、数据库用户名、数据库密码、子系统中文名称、子系统英文名称及启动端口号。

### 指定小区请求地址为不经过网关鉴权

根据需求，如果子系统已经有自身的权限系统，可以不经过网关鉴权，在`suilin-gateway`模块下，`application.yml`配置文件新增如下配置:（后续考虑自动配置）

```yml
suilin:
  document:
    - name: 总系统模块
      location: /system
  secure:
    skipUrl:
      - /community-goodTime/**
      - /community-fortuneGarden/** # 对聚福苑社区的请求不鉴权
```

### 配置IDEA启动参数

启动参数输入的是**小区英文名称**，如果此小区英文名称不在`CommunityEnum`定义，则会提示找不到小区。

![](https://chendehuablog.oss-cn-hangzhou.aliyuncs.com/20200829164206.png)

最后成功启动，可以看到当前小区使用的数据库、端口号信息：

![](https://chendehuablog.oss-cn-hangzhou.aliyuncs.com/20200829164347.png)

可以通过各自小区`ip:port/login`访问管理平台

![](https://chendehuablog.oss-cn-hangzhou.aliyuncs.com/20200829164730.png)

## 文档配置

导入此依赖即刻自动注册到网关。

```xml
<!--导入此依赖即刻自动生成文档到gateway中-->
<dependency>
    <groupId>org.analysis</groupId>
    <artifactId>suilin-core-swagger</artifactId>
    <version>${suilin.tool.version}</version>
</dependency>
```



## 项目进度

### 已完成

1. 已完成网关分发功能。
2. 已完成jwt认证登录
3. 已完成文档自动配置
