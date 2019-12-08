# zuul_lab

微服务网关 Zuul 实验，极客时间微服务架构实践课程

# 课程 ppt

1. [微服务网关 Zuul 架构和实践](ppt/微服务网关Zuul架构和实践.pdf)

# 实验软件需求

1. [JDK 1.8+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. [MySQL(5.6.5+)+Workbench](https://dev.mysql.com/downloads/)
3. [Git for Windows](https://gitforwindows.org/)
4. [Postman](https://www.getpostman.com/)
5. Eclipse STS 3.9.5 下载 1[网盘](https://pan.baidu.com/s/1xqy4G_r9N24WODBBuGlIog) 下载 2[国外](https://spring.io/tools)
6. [Tomcat 8.5](https://tomcat.apache.org/)

**建议**：[s2g-zuul](https://github.com/spring2go/s2g-zuul)源码建议使用较新版本的[Eclipse IDE for Java EE Developer](https://www.eclipse.org/downloads/packages/release/2019-03/r/eclipse-ide-enterprise-java-developers)进行导入，它可以自动感知 Servlet Web 项目，可在 Eclipse+Tomcat 里头直接调试源码，方便排查问题。

# 实验目录

1. [lab01](lab01)~前置过滤器实验
2. [lab02](lab02)~路由过滤器实验
3. [lab03](lab03)~后置过滤器实验
4. [lab04](lab04)~Zuul 网关对接 Apollo
5. [lab05](lab05)~Spring Cloud Zuul 实验

# 实验前准备

建好如下目录：

```
D:\temp\scripts\pre
D:\temp\scripts\route
D:\temp\scripts\post
D:\temp\scripts\error
```

创建数据库**spring2go_zuul_filter**和表[zuul_filter](https://github.com/spring2go/s2g-zuul/blob/master/s2g-zuul-mobile/src/main/resources/db/schema.sql)

# 实验源码

[zuul 教学定制版](https://github.com/spring2go/s2g-zuul)

# 注意

1. 所有实验仅供学习参考，不是生产级
2. 实验和 ppt 采用[Mit license](LICENSE)
