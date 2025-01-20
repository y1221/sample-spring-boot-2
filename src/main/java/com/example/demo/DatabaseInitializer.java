package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.mysql.User;
import com.example.demo.mysql.UserRepository;

@Configuration
public class DatabaseInitializer {
    @Bean
    CommandLineRunner initDatabase(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        return args -> {
            // テーブルの存在チェック
            try {
                jdbcTemplate.queryForObject("SELECT 1 FROM user LIMIT 1", Integer.class);
                // 存在する場合、処理中断
                return;
            } catch (Exception e) {
                // 存在しない場合、後続処理
            }

            List<User> users = Arrays.asList(
                    new User("一郎", "ichiro@gmail.com"),
                    new User("二郎", "jiro@icloud.com"),
                    new User("三郎", "saburo@outlook.jp"));
            userRepository.saveAllAndFlush(users);

            System.out.println("初期データ投入完了");
        };
    }
}
