[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/0mhnc0uZ)

# RESTful WebPOS

请参考[spring-petclinic/spring-petclinic-rest](https://github.com/spring-petclinic/spring-petclinic-rest)
将aw03的webpos项目改为REST架构风格的应用系统。具体要求包括：

- 请使用OpenAPI的定义REST接口，参考[api.yml](src/main/resources/api.yml)；
- 请`client`目录下给大家提供的客户端与你所写的RESTfulWebPOS接起来
    - 当前`client`目录下的客户端可以与一个[假的后端服务](https://github.com/typicode/json-server)
      对接，具体请看[client/README.md](client/README.md)
- 请编写README.md，详细介绍你所写的RESTfulWebPOS;
- 请着重理解**应用状态**与**资源状态**两个概念，特别是如何实现客户端与服务器的无状态交互，并代码实现中予以体现，并README.md中写下你的理解。

RESTfulWebPOS的实现可分为几大模块：

1. model模块：定义了相关的模型
2. mapper模块：定义了相关的mapper，基于mybatis-plus用来进行与数据库的交互
3. blz模块：定义了相关的service，用来进行业务逻辑的处理
4. controller模块：定义了相关的controller，用来进行与前端的交互

相关理解：

**应用状态**指的是应用程序的状态，应用当前所处的状态，这种状态是由客户端进行维护的。
**资源状态**指的是资源的状态，客户端可获取的资源的状态，这种状态是由服务器进行维护的。
通过这两种状态的分离，使得客户端和服务端之间的交互无状态，客户端来维护自己的状态，
服务端负责和数据库的交互，维护资源的状态。在这种情况下，客户端可以与多个服务端进行交互而不需要担心状态的问题，
因为客户端的状态是由客户端自己维护的，而服务端只负责相关的与数据库交互的逻辑，本身没有状态，成为了客户端的一个工具。
