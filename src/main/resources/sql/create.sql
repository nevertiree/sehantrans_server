USE sehantrans;

#############
# 用户登录表 #
#############
CREATE TABLE IF NOT EXISTS `userlogin` (
no         CHAR(64)    NOT NULL  PRIMARY KEY ,  #用户id
username   varchar(32) NOT NULL  UNIQUE ,  #用于登录的名字（通常是邮箱）
password   varchar(32) NOT NULL
#   `token`       CHAR(64)    NOT NULL,  #本设备口令
#   `ip`          CHAR(16)    NOT NULL   #本设备IP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

################
# 用户基本信息表 #
################
#图片的名字、个人简介文字txt的标题内容和用户的ID相同
CREATE TABLE IF NOT EXISTS userbase(
no             CHAR(64)       PRIMARY KEY,
name           VARCHAR(16)    NOT NULL ,             #用户昵称
gender         ENUM('0','1','2')     DEFAULT '2',   #用户性别:男0女1保密2
birth          DATETIME       DEFAULT now(),         #用户生日
mobile         CHAR(16)       ,   #用户手机号
email          VARCHAR(32)    NOT NULL ,             #用户邮箱（注册的时候绑定）
portrait       VARCHAR(100)   DEFAULT '/var/www/data/portrait/default.png',#用户照片的存储地址
introduction   VARCHAR(100)   DEFAULT '/var/www/data/introduction/default.txt', #用户个人介绍的存储地址
registerTime   DATETIME       DEFAULT now()          #注册时间 系统自动生成
)CHARACTER SET =utf8;

show TABLES ;

################
# 商品基本信息表 #
################
CREATE TABLE IF NOT EXISTS productbase (
no           CHAR(64) PRIMARY KEY,  #商品no
name         VARCHAR(128)  NOT NULL, #商品名称
sellerNo     CHAR(64)     NOT NULL , #卖家no
foreign key (sellerNo) REFERENCES userbase(no),
sellerName   VARCHAR(16)  NOT NULL, #卖家名称
quantity     INT(10) DEFAULT 0,
price        DECIMAL(10,2)   NOT NULL, #商品价格
catalog      VARCHAR(10)  NOT NULL, #类别*/
picture      VARCHAR(100) , #商品照片目录
introduction VARCHAR(100) , #商品简介
releaseTime  DATETIME DEFAULT now()  #发布时间,
)CHARACTER SET  = utf8;

#########
# 订单表 #
#########
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

###########
# 购物车表 #
###########
CREATE TABLE IF NOT EXISTS cartbase(
  no CHAR(64) PRIMARY KEY ,
  cartDetail LONGTEXT
)CHARACTER SET  = utf8;