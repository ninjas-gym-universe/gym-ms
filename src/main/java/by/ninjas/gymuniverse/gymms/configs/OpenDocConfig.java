package by.ninjas.gymuniverse.gymms.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Spring OpenDoc.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
@OpenAPIDefinition(
    info = @Info(
        title = "${app.name}",
        description = "${app.description}",
        version = "${app.version}"))
@Configuration
public class OpenDocConfig {
}
