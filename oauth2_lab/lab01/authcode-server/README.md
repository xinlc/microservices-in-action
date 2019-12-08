# 基于授权码模式+Spring Security OAuth2 的最简授权服务器

# 操作方式

### 1. 获取授权码

浏览器请求：

http://localhost:8080/oauth/authorize?client_id=clientapp&redirect_uri=http://localhost:9001/callback&response_type=code&scope=read_userinfo

**注意：state 参数暂忽略**

响应案例：

http://localhost:9001/callback?code=OCOzdH

### 2. 获取访问令牌

curl -X POST -u clientapp:112233 http://localhost:8080/oauth/token -H
"content-type: application/x-www-form-urlencoded" -d
"code=OCOzdH&grant_type=authorization_code&redirect_uri=http://localhost:9001/callback&scope=read_userinfo"

案例响应：

```json
{
  "access_token": "f991749b-0e68-4908-a8f4-52d39a285ddb",
  "token_type": "bearer",
  "expires_in": 43199,
  "scope": "read_userinfo"
}
```

### 3. 调用 API

curl -X GET http://localhost:8080/api/userinfo -H "authorization: Bearer f991749b-0e68-4908-a8f4-52d39a285ddb"

案例响应：

```json
{
  "name": "leo",
  "email": "leo@gmail.com"
}
```
