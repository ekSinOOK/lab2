package Egorow.lab2.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import Egorow.lab2.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}