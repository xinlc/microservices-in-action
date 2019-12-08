# 参考

[Spring REST API + OAuth2 + AngularJS](http://www.baeldung.com/rest-api-spring-oauth2-angularjs)

[源码](https://github.com/Baeldung/spring-security-oauth)

### 实验步骤

1. 需要启动 mysql 数据库，在 oauth-server/src/main/resources/persistence.properties 设置数据库访问用户名/密码
2. 依次启动：

- 授权服务器 oauth-server(8081)
- 资源服务器 oauth-resource(8082)
- AngularJS 单页应用 oauth-ui-implicit(0803)

3. 浏览器打开http://localhost:8083 开始实验
4. 登录用户名密码在 oauth-server/.../WebSecurityConfig 中配置
