# 实验四、Zuul 网关对接 Apollo

### 实验步骤

#### 1. 在 Eclipse 中启动 lab05 的 Student 服务

[Student Service](https://github.com/spring2go/zuul_lab/tree/master/lab05/student-service)

#### 2. 启用 Apollo 配置中心本地版

```
./demo.sh start
```

[参考 Apollo Quick Start](https://github.com/ctripcorp/apollo/wiki/Quick-Start)

#### 3. 在 Eclipse 中启动 Zuul+Tomcat 服务器

修改服务器端口为`9000`，避免和 Apollo 的 Config Service 端口(8080)冲突

通过 Postman 校验

```
http://localhost:9000/s2g-zuul-mobile/healthcheck
```

#### 4. 通过 Apollo 调整配置项

Apollo 管理界面

```
http://localhost:8070
```

动态配置项

```
zuul.could.set.debug=false
zuul.routing_table_string=student@http://localhost:9700&testapi@http://localhost:9700
```

#### 5. 校验

1. 通过 Postman 校验

```
http://localhost:9000/s2g-zuul-mobile/api/testapi/echoStudentName/bobo
```

2. 通过 Eclipse 控制台输出查看过滤器调试日志

3. 通过 InfoBoard 工具校验

```
http://localhost:8077
```
