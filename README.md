# learning-mybatis

## 数据库与表
#### jdbc与java类型转换
> 摘录自mysql官方文档: https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-reference-type-conversions.html

|jdbc type name|java type name|
|:-------------|:-------------|
|INT [UNSIGNED]|java.lang.Integer, if UNSIGNED java.lang.Long|
|TINYINT|java.lang.Boolean if the configuration property tinyInt1isBit is set to true (the default) and the storage size is 1, or java.lang.Integer if not.|
|CHAR(M)|ava.lang.String (unless the character set for the column is BINARY, then byte[] is returned.|
|DATETIME|java.sql.Timestamp|

#### user用户表
``` java
# user表结构
DROP TABLE IF EXISTS user;
CREATE TABLE user(
  id INT NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  name CHAR(50) NOT NULL COMMENT '用户名',
  password CHAR(50) NOT NULL COMMENT '用户密码',
  sex CHAR(8) NOT NULL COMMENT '性别',
  is_vip TINYINT NOT NULL COMMENT '权限 0-普通,1-vip',
  gmt_create DATETIME NOT NULL COMMENT '创建时间',
  gmt_modified DATETIME NOT NULL COMMENT '最后一次更改时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# user表数据
INSERT INTO user(name, password, sex, is_vip, gmt_create, gmt_modified)
VALUES('小明', '123456', '男', 1, now(), now());
INSERT INTO user(name, password, sex, is_vip, gmt_create, gmt_modified)
VALUES('小红', '123456', '女', 1, now(), now());
INSERT INTO user(name, password, sex, is_vip, gmt_create, gmt_modified)
VALUES('张三', '123456', '男', 0, now(), now());
INSERT INTO user(name, password, sex, is_vip, gmt_create, gmt_modified)
VALUES('李四', '123456', '男', 0, now(), now());
INSERT INTO user(name, password, sex, is_vip, gmt_create, gmt_modified)
VALUES('王五', '123456', '女', 0, now(), now());
```

#### product
``` java
# product表结构
DROP TABLE IF EXISTS product;
CREATE TABLE product(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '产品表id',
  name CHAR(50) NOT NULL COMMENT '产品名',
  price INT NOT NULL COMMENT '产品价格',
  stock INT UNSIGNED NOT NULL COMMENT '库存数量',
  gmt_create DATETIME NOT NULL COMMENT '创建时间',
  gmt_modified DATETIME NOT NULL COMMENT '最后一次更改时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# product表数据
INSERT INTO product(name, price, stock, gmt_create, gmt_modified)
VALUES('手表', 30000, 100, now(), now());
INSERT INTO product(name, price, stock, gmt_create, gmt_modified)
VALUES('iphone', 30000, 100, now(), now());
INSERT INTO product(name, price, stock, gmt_create, gmt_modified)
VALUES('衣服', 200, 300, now(), now());
INSERT INTO product(name, price, stock, gmt_create, gmt_modified)
VALUES('香水', 500, 50, now(), now());
INSERT INTO product(name, price, stock, gmt_create, gmt_modified)
VALUES('牛奶', 5, 500, now(), now());
```
