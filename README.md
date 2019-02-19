# spring-data-elasticsearch-starter

spring-data-elasticsearch-starter

## 部署elasticsearch服务

通过Docker部署elasticsearch一般服务。

```sbtshell
docker network create somenetwork
docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:6.6.0
docker run -d --name kibana2 --net somenetwork -p 5601:5601 docker.io/kibana:6.6.0
```

服务部署之后，elasticsearch提供两套API接口，9200 端口提供Http协议的接口服务。9300 为elasticsearch 自定义协议接口。通过
Java Client对接elasticsearch服务一般使用9300端口提供的接口。

## 调整配置

```yaml
server:
  port: 8099
spring:
  data:
    elasticsearch:
      clusterName: docker-cluster
      clusterNodes: 172.27.9.114:9300
```

修改配置IP端口到你自己部署的服务地址。

## 启动服务并测试

启动服务后，访问 http://172.27.8.232:8099/swagger-ui.html , 通过Swagger-ui界面调试Controller提供的Restful接口。

注意事项：由于Swagger组件问题，对于Pageable对象的注入，参数应该是 page, size, sort; 并非接口文档提供的内容。
所以使用时可以仅填写page, size, sort 三个参数，其他的都可以不填写，或者都不填写会自动使用默认值。