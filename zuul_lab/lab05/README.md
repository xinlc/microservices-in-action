# 实验五、Spring Cloud Zuul 实验

### 实验步骤

#### 1. 在 Eclipse 中启动 lab05 的 Student 服务

[Student Service](https://github.com/spring2go/zuul_lab/tree/master/lab05/student-service)

#### 2. 在 Eclipse 中启动 Lab05 的 Spring Cloud Zuul 网关服务

[Spring Cloud Zuul Service](https://github.com/spring2go/zuul_lab/tree/master/lab05/zuul_gateway)

#### 3. 校验

- 通过 Postman 校验

```
http://localhost:8080/student/echoStudentName/bobo
http://localhost:8080/student/getStudentDetails/bobo
```

- 通过 Eclipse 控制台校验
