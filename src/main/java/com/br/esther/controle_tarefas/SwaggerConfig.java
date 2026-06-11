package com.br.esther.controle_tarefas;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .servers(List.of(
                new Server().url("https://controle-tarefas-springboot-production.up.railway.app").description("Produção"),
                new Server().url("http://localhost:8080").description("Local")
            ));
    }
}