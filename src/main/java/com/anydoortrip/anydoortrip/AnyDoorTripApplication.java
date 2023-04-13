package com.anydoortrip.anydoortrip;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


/**
 * Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
 * 如果想让Spring的配置文件生效，加载到Spring 容器中来；
 * 使用@ImportResource注解，将其标注在一个配置类上(此处配置在启动类)
 */
@Slf4j
@SpringBootApplication
@MapperScan(value = "com.anydoortrip.anydoortrip.**.mapper")
public class AnyDoorTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnyDoorTripApplication.class, args);
	}

}
