package test.task.com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Attention the system works)");
            }
        };
    }
}
