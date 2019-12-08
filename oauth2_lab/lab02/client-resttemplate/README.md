# 客户端以授权码方式访问 OAuth2 服务器案例，使用 rest template

# 实验注意事项

1. 该实验开始前需要预先安装 mysql 数据库，再使用 mysql workbench 预先执行 sql 脚本 src\main\resources\db\oauth_client.sql
2. 该案例需先启动 lab01 中的支持授权码模式的 OAuth2 服务器，端口在 8080。
3. 再运行本案例 web 应用，端口在 9001，浏览器访问http://locahost:9001， 按提示操作即可。
4. 该案例授权成功后，客户端会在数据库中缓存访问令牌（可通过 mysql workbench 查看），如果 OAuth2 服务器使用内存模式，则重启 OAuth2 服务器后原访问令牌将失效，需要清除数据库令牌再重新授权。
