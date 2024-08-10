INSERT INTO `product` (`name`, `price`, `img`, `category`, `stock`, `quantity`)
VALUES ('cola', 3, 'Cola.jpg', 'drink', 1, 16),
       ('sprite', 4, 'Sprite.png', 'drink', 1, 12),
       ('red bull', 5, 'Redbull.jpg', 'drink', 1, 5),
       ('Milk', 5, 'Milk.jpg', 'drink', 1, 5);

INSERT INTO `settings` (`app`, `store`, `address_one`, `address_two`, `contact`, `tax`, `symbol`, `percentage`,
                        `footer`, `img`)
VALUES ('Standalone Point of Sale', 'Store-Pos', '10086', '10087', '15968774896', 0, '$', 10, '', '');

INSERT INTO `category` (`name`)
VALUES ('drink');