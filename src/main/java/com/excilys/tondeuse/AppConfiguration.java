package com.excilys.tondeuse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.excilys.tondeuse.cli", "com.excilys.tondeuse.utils" })
public class AppConfiguration {
}
