package ai.webtch.sampleserver.jdbcclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JdbcClientPostService implements PostService {

    private static final Logger log = LoggerFactory.getLogger(JdbcClientPostService.class);

    //TODO: add JdbcClient

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void create(Post post) {

    }

    @Override
    public void update(Post post, String id) {

    }

    @Override
    public void delete(String id) {

    }
}