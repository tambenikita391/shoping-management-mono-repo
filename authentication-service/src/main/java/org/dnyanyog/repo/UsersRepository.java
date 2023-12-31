package org.dnyanyog.repo;

import java.util.List;

import org.dnyanyog.dto.UserData;
import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, Long> {


	List<UserData> findByUserNameAndPassword(String userName, String password);


}