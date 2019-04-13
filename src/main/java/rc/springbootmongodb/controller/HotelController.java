package rc.springbootmongodb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.springbootmongodb.entity.Hotel;
import rc.springbootmongodb.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  private HotelRepository hotelRepository;

  public HotelController(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @GetMapping("/all")
  public List<Hotel> getAll(){
    List<Hotel> hotels = this.hotelRepository.findAll();
    return hotels;
  }

}
