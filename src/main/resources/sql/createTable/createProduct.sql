use sehantrans;

#商品的基本信息
CREATE TABLE IF NOT EXISTS productbase (
  no           CHAR(64) PRIMARY KEY,  #商品no
  name         VARCHAR(32)  NOT NULL, #商品名称
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

DROP TABLE productbase;
show create table productbase;

#商品的详细信息
# CREATE TABLE IF NOT EXISTS productdetail(
#   no           CHAR(64) PRIMARY KEY, #商品no
#
# )CHARACTER SET  = utf8;