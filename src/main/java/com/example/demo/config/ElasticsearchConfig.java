package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfig {

    /*TODO local model config.*/
//    @Bean
//    public NodeClientFactoryBean client() {
//
//        NodeClientFactoryBean bean = new NodeClientFactoryBean(true);
//        bean.setClusterName("docker-cluster");
//        bean.setEnableHttp(false);
//        bean.setPathData("target/elasticsearchTestData");
//        bean.setPathHome("src/test/resources/test-home-dir");
//        return bean;
//    }
}
