# Android 对接 OAuth2 授权服务器（基于 Spring Security OAuth2+内存 H2 数据库）

# 操作方式

### 1. 启动 mobile_authserver，端口 8080

### 2. 在 Android Studio 中启动 AuthCodeApp

### 3. 更新授权服务器 ip 地址

AuthCodeApp\app\src\main\java\spring2go\io\authcodeapp\client\ClientAPI 中的 BASE_URL 地址为 mobile_authserver 的 ip 地址

### 4. 校验

1. 校验 h2 内存数据库生成的访问令牌 http://localhost:8080/h2-console
2. Android Studio 中的 Device File Explorer 查看

```
data\data\spring2go.io.authcodeapp\shared_prefs
```
