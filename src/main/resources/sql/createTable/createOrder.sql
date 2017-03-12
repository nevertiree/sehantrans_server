USE sehantrans;

SHOW tables;

#订单管理
CREATE TABLE IF NOT EXISTS orderinfo(
  no             CHAR(64)       PRIMARY KEY ,
  bno            CHAR(64)       NOT NULL ,
  bname          VARCHAR(16)    NOT NULL ,
  sno            CHAR(64)       NOT NULL ,
  sname          VARCHAR(16)    NOT NULL ,
  sum            DECIMAL(12,2)  NOT NULL ,
  status         ENUM('待付款','待收货','待评价','待退换','完成') DEFAULT '待付款',
  ordertime      DATETIME       DEFAULT now(),
  orderdetail    LONGTEXT       NOT NULL ,
  logisticsno    CHAR(14)              ,
  FOREIGN KEY (sno) REFERENCES userbase(no),
  FOREIGN KEY (bno) REFERENCES userbase(no)

)CHARACTER SET  = utf8;