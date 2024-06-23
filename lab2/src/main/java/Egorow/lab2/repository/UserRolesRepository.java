package Egorow.lab2.repository;

import org.springframework.data.repository.CrudRepository;
import Egorow.lab2.model.UserRole;

public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
}
