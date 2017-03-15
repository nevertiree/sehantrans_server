# 服务器API详解

## 注册账户

1. 通过Email注册

注册时输入Email地址和密码

`
localhost:8080/api/user/register/email?email=example@gmail.com&password=mypassword
`

2. 通过电话号码注册

此功能尚未开放

## 登录账户

1. 正常登录

在以下网址输入邮箱和密码，密码控制只能输入字母和数字、不能有特殊符号(~!@#$%^&*()_+[]{}|\;:'",./<>?)，长度介于6-20位。

`
localhost:8080/api/user/login/common?loginName=myname&password=mypassword
`

2. 指纹登录

暂时不支持

## 修改用户信息

0. 取得用户信息

输入待查询的用户ID
`
http://localhost:8080/api/user/setting/detail?no=userno
`

1. 修改密码

在以下地址输入用户唯一No和新密码，新密码同样要准守规范。

`localhost:8080/api/user/setting/password?no=001&password=newpassword`

返回值 100 成功
返回值 200 服务器失败
返回值 300 密码格式不正确

2. 修改名字

`localhost:8080/api/user/setting/name?no=001&name=newname`

3. 修改性别

性别的值为0 1 2，分别是男、女和保密

`localhost:8080/api/user/setting/name?no=001&gender=new_gender`

4. 修改生日

生日一定要符合`yyyy-mm-dd`的格式

`localhost:8080/api/user/setting/name?no=001&birth=yyyy-mm-dd`

返回值 100 成功
返回值 200 服务器失败
返回值 300 生日格式不正确

5. 修改手机号码

`localhost:8080/api/user/setting/mobile?no=001&mobile=18911223344`

返回值 100 成功
返回值 200 服务器失败
返回值 300 手机号格式不正确，手机号一定要11位数字

6. 修改电子邮箱

`localhost:8080/api/user/setting/email?no=001&email=new_email`

返回值 100 成功
返回值 200 服务器失败
返回值 300 邮件格式不正确

## 发布商品

输入商品名字、用户ID、价格和商品种类

`http://localhost:8080/api/product/release?product=pname&seller=sellerId&price=price&catalog=catalog`

返回值 100 成功
返回值 200 服务器失败

## 修改商品信息

0. 取得商品信息

`http://localhost:8080/api/product/setting/baseinfo?no=no`

返回值 100 成功
返回值 200 服务器失败

1. 修改商品名称

`http://localhost:8080/api/product/setting/name?no=no&name=name`

返回值 100 成功
返回值 200 服务器失败

2. 修改商品数量

`http://localhost:8080/api/product/setting/quantity?no=no&quantity=quantity`

返回值 100 成功
返回值 200 服务器失败

3. 修改商品价格

`http://localhost:8080/api/product/setting/price?no=no&price=123.45`

返回值 100 成功
返回值 200 服务器失败

4. 修改商品类别

`http://localhost:8080/api/product/setting/catalog?no=no&catalog=new_catalog`

返回值 100 成功
返回值 200 服务器失败

5. 删除一个商品

`http://localhost:8080/api/product/setting/delete?no=no`

返回值 100 成功
返回值 200 服务器失败

## 订单管理