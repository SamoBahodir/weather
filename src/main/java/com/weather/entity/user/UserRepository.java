package com.weather.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(@NotNull String username);

    boolean existsByUsername(@Param("username") String username);
}
