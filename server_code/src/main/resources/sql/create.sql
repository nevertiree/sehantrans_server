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

#记录用于登录的安全信息
CREATE TABLE IF NOT EXISTS `userSecurity` (
  `no`          CHAR(64)    NOT NULL  PRIMARY KEY ,  #用户id
  `loginName`   varchar(32) NOT NULL  UNIQUE ,  #用于登录的名字（通常是邮箱）
  `pwd`         varchar(32) NOT NULL,
  `token`       CHAR(64)    NOT NULL,  #本设备口令
  `ip`          CHAR(16)    NOT NULL   #本设备IP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#用户的地理位置
CREATE TABLE IF NOT EXISTS userSite(
  no       CHAR(64)    PRIMARY KEY,#用户No
  province VARCHAR(16) NOT NULL DEFAULT "未知",#用户省
  city     VARCHAR(16) NOT NULL DEFAULT "未知",#用户市
  county   VARCHAR(32) NOT NULL DEFAULT "未知",#用户区县
  district VARCHAR(32) NOT NULL DEFAULT "未知",#用户街区
  street   VARCHAR(64) NOT NULL DEFAULT "未知",#用户街道
  school   VARCHAR(64) NOT NULL DEFAULT "未知" #用户学校
)CHARACTER SET =utf8;

#用户的基本信息
#用户的个性信息 包括用户头像+用户个人介绍
#在本地文件系统中存储用户的头像二进制文件和个人介绍长文本，在数据库中记录地址
#图片的名字、个人简介文字txt的标题内容和用户的ID相同
CREATE TABLE IF NOT EXISTS userPersonInfo(
  no             CHAR(64)       PRIMARY KEY,
  name           VARCHAR(16)    NOT NULL ,             #用户昵称
  gender         SET("男","女","保密") DEFAULT "保密",   #用户性别
  birth          DATETIME       DEFAULT now(),         #用户生日
  mobile         INT(16)        UNSIGNED,   #用户手机号
  email          VARCHAR(32)    NOT NULL ,             #用户邮箱（注册的时候绑定）
  portrait       VARCHAR(100)   DEFAULT "/var/www/data/portrait/default.png",#用户照片的存储地址
  introduction   VARCHAR(100)   DEFAULT "/var/www/data/introduction/default.txt", #用户个人介绍的存储地址
  registerTime   DATETIME       DEFAULT now()          #注册时间 系统自动生成
)CHARACTER SET =utf8;

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
CREATE TABLE IF NOT EXISTS order(
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

SHOW CREATE TABLE userSecurity;