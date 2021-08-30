package kg.online_store;

import kg.online_store.controller.AdminPageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class OnlineStoreApplication {
	public static void main(String[] args) {
		new File(AdminPageController.uploadDirectory).mkdir();

		SpringApplication.run(OnlineStoreApplication.class, args);
	}
}
