package com.makemytrip.makemytrip.Repository;

import com.makemytrip.makemytrip.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
