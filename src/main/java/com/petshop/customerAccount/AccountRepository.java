package com.petshop.customerAccount;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// layer DAO

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {



    @Query("SELECT c FROM Account c WHERE c.UserName = ?1")
    Optional<Account> findAccountByUserName(String UserName);

    @Query("SELECT c.Roles FROM Account c WHERE c.UserName = ?1 and c.PassWord = ?2")
    Optional<String> findByRules(String UserName, String PassWord);

    @Query("SELECT c FROM Account c WHERE c.UserName = ?1 and c.PassWord = ?2")
    Optional<Account> findByAccount(String UserName, String PassWord);
//    CustomerAccount findByAccount(String UserName, String PassWord);

    @Modifying
    @Query("UPDATE Account c SET c.PassWord = ?1, c.Roles = ?2 WHERE c.Id = ?3")
    void updateAccount(String UserName, String Rules, Integer Id);

}
