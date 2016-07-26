CREATE DATABASE IF NOT EXISTS sehantrans;

USE sehantrans;

CREATE TABLE IF NOT EXISTS `userSecurity` (
  `no` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `token` varchar(64) NOT NULL,
  `ip` varchar(16) NOT NULL,
  PRIMARY KEY (`no`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#CREATE TABLE userBase(
#)ENGINE =InnoDB,
#CHARACTER SET =utf8