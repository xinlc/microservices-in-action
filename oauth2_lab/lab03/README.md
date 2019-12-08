# 基于密码模式+Spring Security OAuth2+JWT 的最简授权服务器

# 操作方式

### 1. 启动 jwt-authserver，端口 8080

### 2. 启动 jwt-resourceserver，端口 8081

### 3. 获取 JWT 令牌

建议用 postman

curl -X POST --user clientapp:112233 http://localhost:8080/oauth/token -H "accept: application/json" -H "content-type: application/x-www-formurlencoded" -d "grant_type=password&username=richard&password=123456&scope=read_userinfo"

响应案例：

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzAyMzkyODAsInVzZXJfbmFtZSI6InJpY2hhcmQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiOTU4NTI1YTUtODA4ZS00Yzk1LWI4OTItZjM1YzYwOGI2NDRhIiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZF91c2VyaW5mbyJdfQ.6vHNKZaDgRweKvZNPg5aM_bmNzAiiCuOX0j3Wwc16S8",
  "token_type": "bearer",
  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJyaWNoYXJkIiwic2NvcGUiOlsicmVhZF91c2VyaW5mbyJdLCJhdGkiOiI5NTg1MjVhNS04MDhlLTRjOTUtYjg5Mi1mMzVjNjA4YjY0NGEiLCJleHAiOjE1NzI3ODgwODAsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI4YzMzZmUxZC1iNWIxLTQ0YjUtOWFiMy02Mzk0MjE0ZGU4ZjYiLCJjbGllbnRfaWQiOiJjbGllbnRhcHAifQ.IHRwZitAyWGeZbpp6urQI8vG8uBiOToqhIxUl2vUAJg",
  "expires_in": 43199,
  "scope": "read_userinfo",
  "jti": "958525a5-808e-4c95-b892-f35c608b644a"
}
```

### 4. 调用 API

curl -X GET http://localhost:8081/api/userinfo -H "authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzAyMzkyODAsInVzZXJfbmFtZSI6InJpY2hhcmQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiOTU4NTI1YTUtODA4ZS00Yzk1LWI4OTItZjM1YzYwOGI2NDRhIiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZF91c2VyaW5mbyJdfQ.6vHNKZaDgRweKvZNPg5aM_bmNzAiiCuOX0j3Wwc16S8"

案例响应：

```json
{
  "name": "richard",
  "email": "richard@gmail.com"
}
```
