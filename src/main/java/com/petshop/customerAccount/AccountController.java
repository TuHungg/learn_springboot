package com.petshop.customerAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/v1/account") // This means URL's start with /demo (after Application path)
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getCustomer() {
        return accountService.getCustomer();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/signin")
//    public List<Account> signIn(@RequestBody Map<String, String> body) {
//        String username = body.get("username");
//        String password = body.get("password");
//
////        customerService.signIn(username, password);
////        System.out.println(customerService.signIn(username, password));
//        return accountService.signIn(username, password);
//    }

//    @PostMapping("/signup")
//    public void signUp(@RequestBody Map<String, String> body) {
//
//        String username = body.get("username");
//        String password = body.get("password");
//        String roles = "user";
//
//        accountService.signUp(username, password, roles);
//
//    }

}