# 基于密码模式+Spring Security OAuth2 的最简授权服务器

# 操作方式

### 1. 获取访问令牌

curl -X POST -u clientapp:112233 http://localhost:8080/oauth/token -H "accept: application/json" -H "content-type: application/x-www-form-urlencoded" -d "grant_type=password&username=bobo&password=xyz&scope=read_userinfo"

响应案例：

```json
{
  "access_token": "58a02fd5-87f5-44ff-bbdd-d429cf6a2f60",
  "token_type": "bearer",
  "expires_in": 43199,
  "scope": "read_userinfo"
}
```

### 2. 调用 API

curl -X GET http://localhost:8080/api/userinfo -H "authorization: Bearer 58a02fd5-87f5-44ff-bbdd-d429cf6a2f60"

案例响应：

```json
{
  "name": "leo",
  "email": "leo@gmail.com"
}
```
