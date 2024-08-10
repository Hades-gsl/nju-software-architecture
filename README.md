[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/E58oe981)
# POS in Shell

The demo shows a simple POS system with command line interface. 

To run

```shell
mvn clean spring-boot:run
```

Currently, it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.4)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome. 

Please use asciinema (https://asciinema.org) to record a demo and submit the url in QQ group. 

And please elaborate your understanding in layered systems via this homework in your README.md.

在分层系统中，系统被分为多个不同的层，将功能进行模块化的划分，这种设计利于管理和重用。
同时，每一层只需要负责自己的功能，不需要关心其他层的实现细节，这样可以降低耦合度，提高系统的可维护性。
但是，在具体实现是，也存在问题，例如，在本次实现中，cli负责相关的输入输出，但是有时也会负责一定的边界条件判断，
而在biz层也会负责边界条件判断，这种交叉有可能会造成功能的不清晰和重复。还有就是层之间的通信，一定要划分明确，
在此次的biz有一个total函数用来计算总价，但是返回为void，此时就只能在biz层中进行total的输出，这样是违背功能的模块化的。
