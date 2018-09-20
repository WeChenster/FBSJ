package com.smy.fbsj;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@MapperScan("com.smy.fbsj")//将项目中对应的mapper类的路径加进来就可以了
@ComponentScan(basePackages = {"com.smy.fbsj"})
public class GlobalApplication {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(GlobalApplication.class);
        logger.info("============项目启动================");
        SpringApplication.run(GlobalApplication.class, args);
        logger.info("============启动结束================");
    }
}
