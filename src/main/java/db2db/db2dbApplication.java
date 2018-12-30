package db2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class db2dbApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(db2dbApplication.class, args);
	}

}
