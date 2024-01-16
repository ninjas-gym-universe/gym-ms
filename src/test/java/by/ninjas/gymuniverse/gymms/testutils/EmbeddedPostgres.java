package by.ninjas.gymuniverse.gymms.testutils;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Base class for tests with embedded postgres DB.
 * <br>
 * Use {@link Testcontainers}. Active on <b>test</b> profile.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@ActiveProfiles("test")
@Testcontainers
@DirtiesContext
public abstract class EmbeddedPostgres {

    @Container
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void initDb(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }
}
