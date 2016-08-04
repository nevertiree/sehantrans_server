
USE sehantrans;

INSERT INTO userSite VALUE ("00001","福建省","福州市","仓山区","对湖街道","福建师大附中");

SELECT no,province,city,county,district,street from userSite where no="00001";

SELECT no,province,city,county,district,street from userSite where no="1";

SELECT count(*) from userSite where no="1";

SELECT count(*) from userSite where no="1asdfas";

ALTER TABLE map RENAME chinaMap

use sehantrans;
show tables;

DESC userBaseInfo;