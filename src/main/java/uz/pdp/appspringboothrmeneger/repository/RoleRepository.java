package uz.pdp.appspringboothrmeneger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringboothrmeneger.entity.Role;
import uz.pdp.appspringboothrmeneger.entity.User;
import uz.pdp.appspringboothrmeneger.entity.enums.RoleName;

import java.util.List;
import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(RoleName roleName);

    List<User> findAllByRoleName(RoleName roleName);
}
