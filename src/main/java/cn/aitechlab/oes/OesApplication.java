package cn.aitechlab.oes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.aitechlab.oes.dao")
public class OesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OesApplication.class, args);
    }

}
