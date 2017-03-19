# 常用Linux命令行

## 端口占用

以8080号端口被占用为例

```shell
# 查询占用8080号端口的进程号
sudo lsof -i tcp:8080
# 杀死该进程
sudo kill -9 PID号
```

## MyBatis文件自动生成

注意要先修改新的配置内容

MyBatis Generator Windows命令

```shell
java -jar libs\\mybatis-generator-core-1.3.5.jar -configfile src\\main\\resources\\config\\generatorConfig.xml
```

MyBatis Generator Linux命令

```shell
java -jar libs/mybatis-generator-core-1.3.5.jar -configfile src/main/resources/config/generatorConfig.xml
```

## 赋予特定IP访问权限

```shell
#清除预设表filter中的所有规则链的规则 
sudo iptables -F
#清除预设表filter中使用者自定链中的规则
sudo iptables -X

# 只允许指定ip地址访问指定端口 
sudo iptables -A INPUT -s 172.23.72.104  -p tcp --dport 8080 -j ACCEPT 
sudo iptables -A OUTPUT -d 172.23.72.104  -p tcp --sport 8080 -j ACCEPT 

# 关闭全部网络访问权限
sudo iptables -P INPUT DROP 
sudo iptables -P OUTPUT DROP 
sudo iptables -P FORWARD DROP 

# 打开全部网络访问权限
sudo iptables -P INPUT ACCEPT 
sudo iptables -P OUTPUT ACCEPT 
sudo iptables -P FORWARD ACCEPT
```