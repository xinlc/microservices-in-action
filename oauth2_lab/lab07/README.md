# 跨站点请求伪造(CSRF)安全实验

# 操作方式

### 1. 安装 Firefox 浏览器和 NoRedirect Add on for Firefox

- [Firefox Browser](http://ftp.mozilla.org/pub/firefox/releases/47.0.2/win64/zh-CN/)
- [NoRedirect Add on for Firefox](https://addons.thunderbird.net/en-us/firefox/addon/noredirect/)

将`http://localhost:8080`加入 NoRedirect 设置的规则列表，选中`来源`，并将该规则置顶。

### 2. 启动授权服务器 state-oauth2server，端口 8080

### 3. 启动 Web 客户端应用 state-client，端口 9000

### 4. 使用 Firefox 浏览器获取授权码

使用黑客账号`attacker/xyz`进行登录认证，注意请求不带**state**

```
http://localhost:8080/oauth/authorize?client_id=clientapp&redirect_uri=http
://localhost:9000/resource&response_type=code&scope=read+write
```

获取授权码返回链接被 NoRedirect 截获，复制该链接

```
http://localhost:9000/resource?code=So3A96
```

### 5. 使用 Chrome 浏览器登录`http://loalhost:9000`

使用正常用户账号`bobo/xyz`进行登录认证

在浏览器地址栏粘贴上面复制的授权码返回链接，并请求，Spring Security OAuth2 client 会进行 state 校验并报错：

```
Possible CSRF detected - state parameter was required but no state could be found
```
