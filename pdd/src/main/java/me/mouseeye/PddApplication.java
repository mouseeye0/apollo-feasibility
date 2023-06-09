package me.mouseeye;

import com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation;
import graphql.execution.instrumentation.Instrumentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PddApplication {

    public static void main(String[] args) {
        SpringApplication.run(PddApplication.class, args);
    }

    @Bean
    @ConditionalOnProperty( prefix = "graphql.tracing", name = "enabled", matchIfMissing = true)
    public Instrumentation tracingInstrumentation(){
        return new FederatedTracingInstrumentation();
    }
}
