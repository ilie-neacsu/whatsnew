package ai.webtch.sampleserver;

import java.time.LocalDate;

import ai.webtch.sampleserver.jdbcclient.Post;
import ai.webtch.sampleserver.jdbcclient.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(@Qualifier("jdbcTemplatePostService") PostService postService) {
        return args -> {
            postService.create(new Post("1234", "Hello World", "hello-world", LocalDate.now(), 1, "java, spring"));
        };
    }
}