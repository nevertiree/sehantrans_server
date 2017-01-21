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
