package org.ram.crud_mvc_app.repository;

import org.ram.crud_mvc_app.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
