USE sehantrans;

#全国地理信息
DROP TABLE IF EXISTS map;
CREATE TABLE  map (
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
  no       VARCHAR(16) PRIMARY KEY,
  province VARCHAR(16) NOT NULL DEFAULT "未知",
  city     VARCHAR(16) NOT NULL DEFAULT "未知",
  county   VARCHAR(32) NOT NULL DEFAULT "未知",
  district VARCHAR(32) NOT NULL DEFAULT "未知",
  street   VARCHAR(64) NOT NULL DEFAULT "未知"
)CHARACTER SET =utf8;