[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/DUIaf6fi)

# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web
ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration).

Based on the code provided, please complete this assignment:

- Read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf or https://www.baeldung.com/tag/thymeleaf/
  and make the POS system robust and functional.
- Save data to some database, such as mysql or h2, just like
  the [petclinic project](https://github.com/spring-petclinic/spring-framework-petclinic).
- And elaborate your understanding in MVC architecture via this homework in your README.md.

MVC架构将软件分为三层：模型（Model）、视图（View）和控制器（Controller）。
其中，模型层负责管理应用程序的数据、状态和业务逻辑，视图层负责展示数据和收集用户输入，控制器负责接收用户的输入请求，调用模型进行相应的业务逻辑处理，并选择合适的视图来展示处理结果。
通过这种方式，MVC架构将应用程序的数据、业务逻辑和用户界面分离开来，使得应用程序的设计更加清晰，易于维护和扩展。