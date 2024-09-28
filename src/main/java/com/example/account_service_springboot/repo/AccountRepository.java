package com.example.account_service_springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.account_service_springboot.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
