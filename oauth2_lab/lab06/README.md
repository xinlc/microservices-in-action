# Github 社交联合登录实验

# 操作方式

### 1. 在 github 上注册开发者应用获取 Client Credentials

Authorization callback URL:

http://localhost:8080/connect/github

### 2. 更新 social-github 应用配置文件

根据上一步获得的 Client Credentials 替换你的**app-id**和**app-secret**

```
spring.social.github.app-id=YOUR_APP_ID
spring.social.github.app-secret=YOUR_APP_SECRET
```