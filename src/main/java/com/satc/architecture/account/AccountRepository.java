package com.satc.architecture.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

   public Boolean existsByEmail(String email);
   public Boolean existsByUsername(String username);
   public Boolean existsByDocument(String document);
}
