package jackob.basicORM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BasicOrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicOrmApplication.class, args);
	}

}
