本目录用于处理用户的注册

    1.1.1 邮箱
    
        用户输入注册邮箱，
        
        客户端用正则表达式检验字符串是否符合邮箱规范
        
        服务器检查该邮箱是否已经注册过
        
        如果没有就发送激活邮件，否则报错
        
    1.1.2 密码
    
        在邮箱符合规范的情况下
    
        用户输入密码，密码长度至少六位而且必须而且只能含英文与数字，
        
        客户端用正则表达式验证密码

        如果密码合乎规范就返回给服务器，否则提示报错