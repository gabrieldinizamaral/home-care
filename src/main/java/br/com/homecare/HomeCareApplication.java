package br.com.homecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { HomeCareApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
public class HomeCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeCareApplication.class, args);
	}
	
}
