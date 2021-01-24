package jackobs.TLVparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TlVparkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TlVparkingApplication.class, args);
	}

}
