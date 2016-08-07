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

#用户的收货地址
CREATE TABLE IF NOT EXISTS userSite(
  no       CHAR(64)    PRIMARY KEY,#用户No
  province VARCHAR(16) NOT NULL DEFAULT "未知",#用户省
  city     VARCHAR(16) NOT NULL DEFAULT "未知",#用户市
  county   VARCHAR(32) NOT NULL DEFAULT "未知",#用户区县
  district VARCHAR(32) NOT NULL DEFAULT "未知",#用户街区
  street   VARCHAR(64) NOT NULL DEFAULT "未知" #用户街道
)CHARACTER SET =utf8;

#用户的基本信息
CREATE TABLE IF NOT EXISTS userBaseInfo(
  no             CHAR(64)    PRIMARY KEY,
  name           VARCHAR(16) NOT NULL ,
  gender         SET("男","女","保密") DEFAULT "保密",
  birth          DATETIME    DEFAULT now(),
  mobile         INT(16)     UNSIGNED DEFAULT "",#用户手机号
  registerTime   DATETIME    DEFAULT now()
)CHARACTER SET =utf8;

#用户的个性信息 包括用户头像+用户个人介绍
#在本地文件系统中存储用户的头像二进制文件和个人介绍长文本，在数据库中记录地址
#图片的名字、个人简介文字txt的标题内容和用户的ID相同
CREATE TABLE IF NOT EXISTS userPersonInfo(
  no             CHAR(64)    PRIMARY KEY,
  picture        VARCHAR(100)   DEFAULT "/var/www/data/portrait/default.png",#用户照片的存储地址
  introduction   VARCHAR(100)   DEFAULT "/var/www/data/introduction/default.txt" #用户个人介绍的存储地址
)CHARACTER SET = utf8;

#商品的基本信息
CREATE TABLE IF NOT EXISTS productBaseInfo(
  no              CHAR(64)    PRIMARY KEY,
  productName     VARCHAR(32) NOT NULL ,      #商品名称
  sellerName      VARCHAR(16) NOT NULL ,      #卖家名称


)