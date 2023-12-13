package by.ninjas.gymuniverse.gymms.testutils.slices;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test slice that includes DB dependencies.
 *
 * @author dziomin
 * @version 0.2.0
 * @since 0.2.0
 */
@DataJpaTest(showSql = false)
@ActiveProfiles("test")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DbTest {

}
