package nisanthdto.DTO.Demo;

import nisanthdto.DTO.Demo.model.Location;
import nisanthdto.DTO.Demo.model.User;
import nisanthdto.DTO.Demo.repository.LocationRepository;
import nisanthdto.DTO.Demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoDemoApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(DtoDemoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Override
	public void run(String... args) throws Exception
	{
       Location location=new Location();
	   location.setPlace("Perambalur");
	   location.setDescription("Perambalur is the best and woest network");
	   location.setLongitude(40.8);
	   location.setLatitude(38.9);
	   locationRepository.save(location);

	   User user1=new User();
	   user1.setFirstName("Nisanth");
		user1.setLastName("selvaraj");
		user1.setEmail("nisanth@gmail.com");
		user1.setPassword("secret");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2=new User();
		user2.setFirstName("Sujith");
		user2.setLastName("selvaraj");
		user2.setEmail("sujith@gmail.com");
		user2.setPassword("realme");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
