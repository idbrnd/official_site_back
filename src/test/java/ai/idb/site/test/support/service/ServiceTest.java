package ai.idb.site.test.support.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.context.SpringBootTest;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Tag("service")
// @Import({P6spyLogMessageFormatConfiguration.class, DatabaseCleanup.class})
@SpringBootTest
public @interface ServiceTest {
}
