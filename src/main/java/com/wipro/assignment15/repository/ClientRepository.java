package com.wipro.assignment15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.assignment15.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
