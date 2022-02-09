<img src="https://cdn.jsdelivr.net/gh/eden-lab/eden-lab-images/readme/icon.png" align="right" />

[license-apache2.0]:https://www.apache.org/licenses/LICENSE-2.0.html
[github-action]:https://github.com/eden-lab/eden-demo-cola/actions
[sonarcloud-dashboard]:https://sonarcloud.io/dashboard?id=eden-lab_eden-demo-cola

# COLA 架构

![](https://cdn.jsdelivr.net/gh/eden-lab/eden-lab-images/readme/language-java-blue.svg) [![](https://cdn.jsdelivr.net/gh/eden-lab/eden-lab-images/readme/license-apache2.0-red.svg)][license-apache2.0] [![](https://github.com/eden-lab/eden-demo-cola/workflows/build/badge.svg)][github-action] [![](https://sonarcloud.io/api/project_badges/measure?project=eden-lab_eden-demo-cola&metric=alert_status)][sonarcloud-dashboard]

本项目使用 COLA 架构构建，COLA 架构是一个整洁的，面向对象的，分层的，可扩展的应用架构，可以帮助降低复杂应用场景的系统熵值，提升系统开发和运维效率。不管是传统的分层架构、六边形架构、还是洋葱架构，都提倡以业务为核心，解耦外部依赖，分离业务复杂度和技术复杂度等，COLA 架构在此基础上融合了 CQRS、DDD、SOLID 等设计思想，形成一套可落地的应用架构。

> 参考文档请查看 [WIKI](https://github.com/eden-lab/eden-demo-cola/wiki) 。

## 组件构成

![](https://cdn.jsdelivr.net/gh/eden-lab/eden-lab-images/eden-demo-cola/component.png)

* **eden-demo-cola-adapter**：适配层，六边形架构中的入站适配器
* **eden-demo-cola-app**：应用层，负责 CQRS 的处理工作，接收更新指令并调用领域层，对于查询视图操作直接绕过领域层调用基础设施层
* **eden-demo-cola-client**：API层，对外以 jar 包的形式提供接口
* **eden-demo-cola-domain**：领域层，业务核心实现，不同于传统的分层架构，提供防腐层接口，不依赖基础设施层的技术实现
* **eden-demo-cola-infrastructure**：基础设施层，六边形架构中的出站适配器，封装技术细节，使用依赖倒置实现 Domain
  暴露的防腐层接口
* **eden-demo-cola-start**：程序启动入口

## 运行流程

![](https://cdn.jsdelivr.net/gh/eden-lab/eden-lab-images/eden-demo-cola/sequence.png)

## 如何构建

* master 分支对应的是 `eden-demo-cola 2.4.x`，最低支持 JDK 1.8。
* 1.5.x 分支对应的是 `eden-demo-cola 1.5.x`，最低支持 JDK 1.8。
* 2.4.x 分支对应的是 `eden-demo-cola 2.4.x`，最低支持 JDK 1.8。

COLA 架构使用 Maven 来构建，最快的使用方式是将本项目 clone 到本地，然后执行以下命令：

```bash
./mvnw install
```

执行完毕后，项目将被安装到本地 Maven 仓库。

## 如何使用

### 运行应用

- 在 `项目` 目录下运行 `mvn install`（如果不想运行测试，可以加上 `-DskipTests` 参数）。
- 进入 `eden-demo-cola-start` 目录，执行 `mvn spring-boot:run` 或者启动 `Application`
  类。运行成功的话，可以看到 `Spring Boot` 启动成功的界面。
- 生成的应用中，已经实现了一个简单的 `Rest` 请求，可以在浏览器中输入 http://localhost:8080/api/users/1 进行测试。

> 请注意，我们已经把常用的依赖纳入 eden-dependencies 管理，不建议带版本号覆盖原有的依赖。

## 版本规范

项目的版本号格式为 x.x.x 的形式，其中 x 的数值类型为数字，从 0 开始取值，且不限于 0~9 这个范围。项目处于孵化器阶段时，第一位版本号固定使用
0，即版本号为 0.x.x 的格式。

由于 `Spring Boot 1.5.x` 和 `Spring Boot 2.4.x` 在架构层面有很大的变更，因此我们采取跟 Spring Boot
版本号一致的版本:

* 1.5.x 版本适用于 `Spring Boot 1.5.x`
* 2.4.x 版本适用于 `Spring Boot 2.4.x`
