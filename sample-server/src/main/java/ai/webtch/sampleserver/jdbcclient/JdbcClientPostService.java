package ai.webtch.sampleserver.jdbcclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jdbcClientService")
@Transactional
public class JdbcClientPostService implements PostService {

    private static final Logger log = LoggerFactory.getLogger(JdbcClientPostService.class);

    private final JdbcClient jdbcClient;

    public JdbcClientPostService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<Post> findAll() {
        return jdbcClient.sql("SELECT id, title, slug, date, time_to_read, tags, version FROM post")
                .query(Post.class)
                .list();
    }

    @Override
    public Optional<Post> findById(String id) {
       return jdbcClient.sql("SELECT id, title, slug, date, time_to_read, tags, version FROM post WHERE id = :id")
               .param("id", id)
               .query(Post.class)
               .optional();
    }

    @Override
    public void create(Post post) {
        var updated = jdbcClient.sql("INSERT INTO post(id, title, slug, date, time_to_read, tags, version) " +
                "values(?, ?, ?, ?, ?, ?, ?)")
                .params(List.of(post.id(), post.title(), post.slug(), post.date(), post.timeToRead(),
                        post.tags(), post.version()))
                .update();
        Assert.state(updated == 1, "Failed to update post " + post.title());
    }

    @Override
    public void update(Post post, String id) {
        var updated = jdbcClient.sql("UPDATE post SET title = ?, slug = ?, date = ?, time_to_read = ?, " +
                "tags = ?, version = ? where id = ?")
                .params(List.of(post.title(), post.slug(), post.date(), post.timeToRead(),
                        post.tags(), post.version(), post.id()))
                .update();
        Assert.state(updated == 1, "Failed to update post " + post.title());
    }

    @Override
    public void delete(String id) {
        var updated = jdbcClient.sql("DELETE FROM post WHERE id = :id")
                .param("id", id)
                .update();
    }
}