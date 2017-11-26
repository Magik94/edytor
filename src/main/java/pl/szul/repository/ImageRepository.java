package pl.szul.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.szul.entity.ImageEntity;

/**
 * Created by Dawid on 29.05.2017.
 */
public interface ImageRepository extends MongoRepository<ImageEntity,String> {

}
