CREATE TABLE IF NOT EXISTS `product`
(
    `id`       INTEGER          NOT NULL auto_increment,
    `name`     VARCHAR(255)     NOT NULL,
    `price`    DOUBLE PRECISION NOT NULL,
    `img`      VARCHAR(255)     NOT NULL,
    `category` VARCHAR(255)     NOT NULL,
    `stock`    INTEGER          NOT NULL,
    `quantity` INTEGER          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `settings`
(
    `id`          INTEGER          NOT NULL auto_increment,
    `app`         VARCHAR(255)     NOT NULL,
    `store`       VARCHAR(255)     NOT NULL,
    `address_one` VARCHAR(255)     NOT NULL,
    `address_two` VARCHAR(255)     NOT NULL,
    `contact`     VARCHAR(255)     NOT NULL,
    `tax`         DOUBLE PRECISION NOT NULL,
    `symbol`      VARCHAR(255)     NOT NULL,
    `percentage`  INTEGER          NOT NULL,
    `footer`      VARCHAR(255)     NOT NULL,
    `img`         VARCHAR(255)     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `category`
(
    `id`   INTEGER      NOT NULL auto_increment,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;