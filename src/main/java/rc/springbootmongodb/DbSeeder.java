package rc.springbootmongodb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rc.springbootmongodb.entity.Address;
import rc.springbootmongodb.entity.Hotel;
import rc.springbootmongodb.entity.Review;
import rc.springbootmongodb.repository.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner {

  private HotelRepository hotelRepository;

  public DbSeeder(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @Override
  public void run(String... strings) throws Exception {

    Hotel marriot = new Hotel(
        "Marriot",
        130,
        new Address("Paris", "France"),
        Arrays.asList(
            new Review("John", 8, false),
            new Review("Mary", 7, true)
        )
    );

    Hotel ibis = new Hotel(
        "Ibis",
        90,
        new Address("Bucharest", "Romania"),
        Arrays.asList(
            new Review("Teddy", 9, true)
        )
    );

    Hotel sofitel = new Hotel(
        "Sofitel",
        200,
        new Address("Rome", "Italy"),
        new ArrayList<>()
    );

    this.hotelRepository.deleteAll();

    List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
    this.hotelRepository.saveAll(hotels);

  }
}
