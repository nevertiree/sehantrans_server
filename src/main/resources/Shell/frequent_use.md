8080号端口被占用

```shell
sudo lsof -i tcp:8080
sudo kill -9 PID号
```

MyBatis Generator Windows命令

```shell
java -jar libs\\mybatis-generator-core-1.3.5.jar -configfile src\\main\\resources\\config\\generatorConfig.xml
```

MyBatis Generator Linux命令

先去修改新的配置内容
```shell
java -jar libs/mybatis-generator-core-1.3.5.jar -configfile src/main/resources/config/generatorConfig.xml
```


iptables -F
#清除预设表filter中的所有规则链的规则 
iptables -X
#清除预设表filter中使用者自定链中的规则
其次，设置只允许指定ip地址访问指定端口 

sudo iptables -A INPUT -s 172.23.72.104 -p tcp --dport 8080 -j ACCEPT 
sudo iptables -A OUTPUT -d 172.23.72.104 -p tcp --sport 8080 -j ACCEPT 
iptables -A INPUT -s 172.23.72.104 -p tcp --dport 3306 -j ACCEPT 
iptables -A OUTPUT -d 172.23.72.104 -p tcp --sport 3306 -j ACCEPT 

sudo iptables -P INPUT DROP 
sudo iptables -P OUTPUT DROP 
sudo iptables -P FORWARD DROP 