USE sehantrans;

#全国地理信息
DROP TABLE IF EXISTS chinaMap;
CREATE TABLE  chinaMap (
  `no` int(10) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '栏目名',
  `parentid` int(10) NOT NULL COMMENT '父栏目',
  `shortname` varchar(50) DEFAULT NULL,
  `areacode` int(6) DEFAULT NULL,
  `zipcode` int(10) DEFAULT NULL,
  `pinyin` varchar(100) DEFAULT NULL,
  `lng` varchar(20) DEFAULT NULL,
  `lat` varchar(20) DEFAULT NULL,
  `level` tinyint(1) NOT NULL,
  `position` varchar(255) NOT NULL,
  `sort` tinyint(3) unsigned DEFAULT '50' COMMENT '排序',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#商品的基本信息
CREATE TABLE IF NOT EXISTS productBaseInfo(
  no              CHAR(64)        PRIMARY KEY,    #商品no
  name            VARCHAR(32)     NOT NULL ,      #商品名称
  sellerNo        CHAR(64)        NOT NULL ,      #卖家no
  sellerName      VARCHAR(16)     NOT NULL ,      #卖家名称
  price           DECIMAL(2)      NOT NULL ,      #商品价格
  /*sort            VARCHAR(10)     NOT NULL ,      #类别*/
  picture         VARCHAR(100)    NOT NULL ,      #商品照片目录
  introduction    VARCHAR(100)    NOT NULL ,      #商品简介
  releaseTime     DATETIME        DEFAULT now()  #发布时间

)CHARACTER SET = utf8;

#订单管理
CREATE TABLE IF NOT EXISTS orderInfo(
  no             CHAR(64)       PRIMARY KEY ,   #订单编号
  #买家信息
  buyerNo        CHAR(64)       NOT NULL ,
  buyerName      VARCHAR(16)    NOT NULL ,
  buyerMobile    INT(16)        UNSIGNED NOT NULL ,
  #卖家信息
  sellerNo       CHAR(64)       NOT NULL ,
  sellerName     VARCHAR(16)    NOT NULL ,
  sellerMobile   INT(16)        UNSIGNED NOT NULL ,
  #订单属性
  account        DECIMAL(2)     NOT NULL ,     #总金额
  orderTime      DATETIME       DEFAULT now(), #交易时间
  logisticsNo    CHAR(64)       NOT NULL       #物流单号
#  orderStatus    SET("","","")

)CHARACTER SET  = utf8;

show TABLES ;