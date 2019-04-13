package rc.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rc.springbootmongodb.entity.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {

}
