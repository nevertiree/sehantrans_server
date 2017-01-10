USE sehantrans;

#记录用于登录的安全信息
CREATE TABLE IF NOT EXISTS `userLogin` (
  no         CHAR(64)    NOT NULL  PRIMARY KEY ,  #用户id
  username   varchar(32) NOT NULL  UNIQUE ,  #用于登录的名字（通常是邮箱）
  password   varchar(32) NOT NULL
#   `token`       CHAR(64)    NOT NULL,  #本设备口令
#   `ip`          CHAR(16)    NOT NULL   #本设备IP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#用户的基本信息
#用户的个性信息 包括用户头像+用户个人介绍
#在本地文件系统中存储用户的头像二进制文件和个人介绍长文本，在数据库中记录地址
#图片的名字、个人简介文字txt的标题内容和用户的ID相同
CREATE TABLE IF NOT EXISTS userBase(
  no             CHAR(64)       PRIMARY KEY,
  name           VARCHAR(16)    NOT NULL ,             #用户昵称
  gender         ENUM('0','1','2')     DEFAULT '2',   #用户性别:男0女1保密2
  birth          DATETIME       DEFAULT now(),         #用户生日
  mobile         INT(16)        UNSIGNED,   #用户手机号
  email          VARCHAR(32)    NOT NULL ,             #用户邮箱（注册的时候绑定）
  portrait       VARCHAR(100)   DEFAULT "/var/www/data/portrait/default.png",#用户照片的存储地址
  introduction   VARCHAR(100)   DEFAULT "/var/www/data/introduction/defahult.txt", #用户个人介绍的存储地址
  registerTime   DATETIME       DEFAULT now()          #注册时间 系统自动生成
)CHARACTER SET =utf8;

# #用户的地理位置
# CREATE TABLE IF NOT EXISTS userSite(
# no       CHAR(64)    PRIMARY KEY,#用户No
# province VARCHAR(16) NOT NULL DEFAULT "未知",#用户省
# city     VARCHAR(16) NOT NULL DEFAULT "未知",#用户市
# county   VARCHAR(32) NOT NULL DEFAULT "未知",#用户区县
# district VARCHAR(32) NOT NULL DEFAULT "未知",#用户街区
# street   VARCHAR(64) NOT NULL DEFAULT "未知",#用户街道
# school   VARCHAR(64) NOT NULL DEFAULT "未知" #用户学校
# )CHARACTER SET =utf8;


show TABLES ;