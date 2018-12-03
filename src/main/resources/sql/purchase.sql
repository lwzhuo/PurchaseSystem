CREATE DATABASE purchase;
USE purchase;
-- 部门表 
CREATE TABLE apartment(
	`id` INT NOT NULL auto_increment,
    `name` VARCHAR(40) NOT NULL,
    PRIMARY KEY(`id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 员工表
CREATE TABLE employee(
	`id` INT NOT NULL auto_increment,
    `name` VARCHAR(40) NOT NULL,
    `password` VARCHAR(40) NOT NULL,
	`address` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    `apartment_id` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY (apartment_id) REFERENCES apartment(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 供应商表
CREATE TABLE supplier(
	`supplier_id` INT NOT NULL auto_increment,
    `supplier_name` VARCHAR(30) NOT NULL,
    `supplier_address` VARCHAR(50) NOT NULL,
    `supplier_phone` BIGINT NOT NULL,
    PRIMARY KEY(`supplier_id`)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 商品表
CREATE TABLE goods(
	`id` INT NOT NULL auto_increment,
    `goods_name` VARCHAR(20) NOT NULL,
    `goods_price` double NOT NULL,
    `supplier_id` INT NOT NULL,
    `goods_type_id` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id),
    FOREIGN KEY (goods_type_id) REFERENCES goods_type(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 商品类别表
CREATE TABLE goods_type(
  `id` INT NOT NULL auto_increment,
  `type_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 需求计划单表
CREATE TABLE needplan_form(
	`id` BIGINT NOT NULL auto_increment,
    `name` VARCHAR(30) NOT NULL,
    `status` INT NOT NULL,
    `comment` VARCHAR(200) NOT NULL,
    `make_date` DATETIME NOT NULL,
    `receive_date` DATETIME NULL DEFAULT NULL,
    `maker_id` INT NOT NULL,
    `apartment_id` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY (maker_id) REFERENCES supplier(supplier_id),
    FOREIGN KEY (apartment_id) REFERENCES apartment(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 需求计划单-物品详情表    
CREATE TABLE needform_detail(
	`id` BIGINT NOT NULL auto_increment,
    `form_id` BIGINT NOT NULL,
    `goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(form_id) REFERENCES needplan_form(id),
    FOREIGN KEY(goods_id) REFERENCES goods(id)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 需求订单表
CREATE TABLE order_form  (
  `id` BIGINT NOT NULL auto_increment,
  `name` VARCHAR(30) NOT NULL,
  `status` INT NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  `make_date` DATETIME NOT NULL,
  `supplier_id` INT NOT NULL,
  `amount` DOUBLE NOT NULL,
  `auditor_id` INT NOT NULL,
  `contract_path` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (auditor_id) REFERENCES employee(id),
  FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 需求订单-物品详情表
CREATE TABLE orderform_detail  (
    `id` BIGINT NOT NULL auto_increment,
    `form_id` BIGINT NOT NULL,
    `goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(form_id) REFERENCES order_form(id),
    FOREIGN KEY(goods_id) REFERENCES goods(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 采购计划单表
CREATE TABLE purchaseplan_form  (
  `id` BIGINT NOT NULL auto_increment,
  `name` VARCHAR(30) NOT NULL,
  `status` INT NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  `make_date` DATETIME NOT NULL,
  `maker_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (maker_id) REFERENCES employee(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 采购计划单-物品详情表
CREATE TABLE `purchaseplan_detail`  (
   `id` BIGINT NOT NULL auto_increment,
    `form_id` BIGINT NOT NULL,
    `goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(form_id) REFERENCES purchaseplan_form(id),
    FOREIGN KEY(goods_id) REFERENCES goods(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 收货单表
CREATE TABLE `receipt_form`  (
  `id` BIGINT NOT NULL auto_increment,
  `name` VARCHAR(30) NOT NULL,
  `status` INT NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  `make_date` DATETIME NOT NULL,
  `order_id` BIGINT NOT NULL,
  `auditor_id` INT NOT NULL,
  `receive_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (order_id) REFERENCES order_form(id),
  FOREIGN KEY (auditor_id) REFERENCES employee(id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 收货单表-物品详情表
CREATE TABLE `receiptform_detail`  (
	`id` BIGINT NOT NULL auto_increment,
    `form_id` BIGINT NOT NULL,
    `goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(form_id) REFERENCES receipt_form(id),
    FOREIGN KEY(goods_id) REFERENCES goods(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
-- 仓库库存表
CREATE TABLE store(
	`goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
	FOREIGN KEY (goods_id) REFERENCES goods(id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
-- 出库单
CREATE TABLE outstore_form(
  `id` BIGINT NOT NULL auto_increment,
  `name` VARCHAR(30) NOT NULL,
  `status` INT NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  `make_date` DATETIME NOT NULL,
  `auditor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (auditor_id) REFERENCES employee(id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 出库单-物品详情表
CREATE TABLE `outstoreform_detail`  (
	`id` BIGINT NOT NULL auto_increment,
    `form_id` BIGINT NOT NULL,
    `goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(form_id) REFERENCES outstore_form(id),
    FOREIGN KEY(goods_id) REFERENCES goods(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 入库单
CREATE TABLE instore_form(
  `id` BIGINT NOT NULL auto_increment,
  `name` VARCHAR(30) NOT NULL,
  `status` INT NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  `make_date` DATETIME NOT NULL,
  `auditor_id` INT NOT NULL,
  `receipt_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (auditor_id) REFERENCES employee(id),
  FOREIGN KEY (receipt_id) REFERENCES receipt_form(id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 入库单-物品详情表
CREATE TABLE `instoreform_detail`  (
	`id` BIGINT NOT NULL auto_increment,
    `form_id` BIGINT NOT NULL,
    `goods_id` INT NOT NULL,
    `goods_num` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY(form_id) REFERENCES instore_form(id),
    FOREIGN KEY(goods_id) REFERENCES goods(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;