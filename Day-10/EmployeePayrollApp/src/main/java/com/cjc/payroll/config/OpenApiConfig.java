package com.cjc.payroll.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeePayrollOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Payroll Management System API")
                        .description("REST API documentation for Employee Payroll Application built with Spring Boot. Features full CRUD operations, pagination, search filters, and AOP logging.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("CJC Development Team")
                                .email("support@cjc.com")
                                .url("https://www.cjc.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server().url("http://localhost:8081").description("Local Development Server")
                ));
    }
}
