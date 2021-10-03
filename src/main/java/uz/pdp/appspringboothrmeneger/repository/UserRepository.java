package uz.pdp.appspringboothrmeneger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringboothrmeneger.entity.Role;
import uz.pdp.appspringboothrmeneger.entity.User;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndEmailCode(String email, String emailCode);

    List<User> findAllByRolesIn(Collection<Set<Role>> roles);




}
