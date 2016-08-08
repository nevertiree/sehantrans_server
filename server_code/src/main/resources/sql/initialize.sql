
USE sehantrans;

INSERT INTO userSite VALUE ("00001","福建省","福州市","仓山区","对湖街道","福建师大附中");

SELECT no,province,city,county,district,street from userSite where no="00001";

SELECT count(*) from userSite where no="1";

SELECT count(*) from userSite where no="1asdfas";

ALTER TABLE map RENAME chinaMap

show tables;

INSERT INTO userBaseInfo (no,name,gender,birth,mobile) VALUE ("00001","王凌霄","男","1996-09-26","189");

select * from userBaseInfo;

DESC userBaseInfo;

DESC userSecurity;

DROP TABLE userSecurity;

DROP TABLE userSite;

DROP TABLE userBaseInfo;

DROP TABLE userPersonInfo;