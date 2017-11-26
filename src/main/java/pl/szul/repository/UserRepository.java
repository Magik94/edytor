package pl.szul.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.szul.entity.UserEnity;

/**
 * Created by Dawid on 30.05.2017.
 */
public interface UserRepository extends MongoRepository<UserEnity,String> {
    UserEnity findByUsername(String username);
}
