[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/o_U346wD)
# aw07 - Big data for MicroPos


[Amazon Review Data (2023)](https://amazon-reviews-2023.github.io/) 是一个包含从1996年到2023年间Amazon商品、用户和评价数据的海量数据集，概况如下：

|评论| 用户 | 商品 |
|--| -- | -- |
|571.54M|54.51M|48.19M|


请完成以下任务

- 下载至少两大类商品的元数据(metadata)和评论数据(reviews)；
  - 在云盘中提供了已下载的部分数据（https://box.nju.edu.cn/d/3e125ec5ca2f476db822/)
- 请使用spring batch将原始格式的数据分别转为User/Product/Review三类对象，包括其间关联关系，并将数据保存到数据库；
  - 请额外考虑一些复杂的处理，比如将英文翻译为中文、测试图片url是否有效等；
- 请将数据库整合进你的MicroPOS（微服务版本的POS系统）并对系统进行相应改造，要求系统使用者可以通过浏览器中的web前端看到商品列表、点击商品后可以看到商品详情和商品相关的评论列表；
- 编写README.md，着重介绍你做了那些处理步骤以及如何使得数据转化处理过程尽量快速。

# 数据处理步骤

首先使用 `ItemReader` 按行读取原始数据，同时在 `ItemReader` 中使用 `jackson` 将读取到的一行 `json` 数据进行
反序列化，得到对应的原始 `RawProduct/RawReview` 对象。

之后在 `ItemProcessor` 中对原始数据进行处理，将原始数据转化为 `Product/Review/User` 对象，做一些简单的数据处理，
即类对象的一个映射，因该处理较为简单，为模拟数据处理过程，增加了一些负载计算来模拟数据处理过程。

最后在 `ItemWriter` 中将处理后的数据写入数据库，为提高写入数据库的效率，每次写入一批的数据，而不是一条一条写入。

由于原始数据中包含的 `User` 的数据较少，故在处理 `Review` 数据时，顺带将 `User` 数据写入数据库，
且写入的信息只包括 `User` 的 `id`（只在原始数据中找到这一条用户信息）。

# `MicroPOS` 系统

此次对`MicroPOS` 做了一定的修改，增加了一个 `review-server` 服务，用于展示商品的评论信息，可通过相关接口来获取。
同时，对 `product-server` 服务做了一定的修改，将 `Product` 类改为与数据处理过程中写入数据库的 `Product` 相对应的类，
将数据库改为上述处理过程中写入的数据库。