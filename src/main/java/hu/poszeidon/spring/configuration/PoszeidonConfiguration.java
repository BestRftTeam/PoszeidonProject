package hu.poszeidon.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = "hu.poszeidon.spring")
public class PoszeidonConfiguration  {
}