package com.petshop.customerAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management/api/v1/account")
public class AccountManagementController {
    private final AccountService accountService;

    @Autowired
    public AccountManagementController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getCustomer();
    }

    // --> ADMIN
//    @PostMapping
//    @PreAuthorize("hasAuthority('admin:role')")
//    public Account createAccount(@RequestBody Map<String, String> body) {
//
//        String username = body.get("username");
//        String password = body.get("password");
//        String roles = body.get("roles");
//
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(username);
//
//        return accountService.addNewCustomer(username, password, roles);
//    }

    @DeleteMapping(path = "{id}")
    public void deleteAccount(@PathVariable("id") Integer id) {
        System.out.println(id);
//        System.out.println(account);
    }

//    @PutMapping(path = "{id}")
//    @PreAuthorize("hasAuthority('admin:role')")
//    public void setRoles(@PathVariable("id") Integer id,
//                              @RequestBody(required = false) Map<String, String> body
//    ) {
//        String username = body.get("username");
//        String password = body.get("password");
//        String roles = body.get("roles");
//
//        accountService.updateAccount(id, username, password, roles);
//    }
    // <--   ADMIN

    // ------------> EDITOR
    @PostMapping
    public Account createAccount(@RequestBody Map<String, String> body) {

        String username = body.get("username");
        String password = body.get("password");
//        String roles = body.get("roles");

        String roles = "user";

        System.out.println(username);
        System.out.println(password);
//        System.out.println(username);

        return accountService.addNewCustomer(username, password, roles);
    }

    @PutMapping(path = "{id}")
    public void updateAccount(@PathVariable("id") Integer id,
                              @RequestBody Map<String, String> body
    ) {

        String username = body.get("username");
        String password = body.get("password");
        String roles = body.get("roles");

        accountService.updateAccount(id, username, password, roles);
    }
    // <----------- EDITOR

}
