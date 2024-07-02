package ai.webtch.sampleserver.jdbcclient;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initializeDatabases() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS post");
        jdbcTemplate.execute(
                "CREATE  TABLE  post (" +
                        "id varchar(255) NOT NULL, " +
                        "title varchar(255) NOT NULL, " +
                        "slug varchar(255) NOT NULL, " +
                        "date date NOT NULL, " +
                        "time_to_read int NOT NULL, " +
                        "tags varchar(255), " +
                        "version INT, " +
                        "PRIMARY KEY (id)" +
                        ")"
        );
    }
}
