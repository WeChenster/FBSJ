package com.smy;



import org.jboss.logging.Logger;
import org.mybatis.spring.annotation.MapperScan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@MapperScan("com.smy.fbsj")//将项目中对应的mapper类的路径加进来就可以了
@ComponentScan(basePackages = {"com.smy.fbsj"})
public class GlobalApplication {
    private static Logger log= Logger.getLogger(GlobalApplication.class);;

    public static void main(String[] args) {
        log.info("============项目启动================");
        SpringApplication.run(GlobalApplication.class, args);
        log.info("============启动结束================");
    }
}
