package ai.webtch.sampleserver.jdbcclient;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@DependsOn("databaseInitializer")
public class DatabaseSeeder {

    private final PostService postService;

    public DatabaseSeeder(@Qualifier("jdbcTemplateService") PostService postService) {
        this.postService = postService;
    }

    @PostConstruct
    public void seedDatabase() {

        postService.create(
               new Post("1354", "Hello, World", "hello-world", LocalDate.now(),
                       2, "world", 1));

        postService.create(
                new Post("2345", "Spring Boot Guide", "spring-boot-guide", LocalDate.now(),
                        2, "java, spring boot", 1));

        postService.create(
                new Post("3456", "Hibernate Tutorial", "hibernate-tutorial", LocalDate.now(),
                        3, "java, hibernate", 1));

        postService.create(
                new Post("4567", "Microservices with Spring", "microservices-spring", LocalDate.now(),
                        4, "java, spring, microservices", 1));
    }
}
