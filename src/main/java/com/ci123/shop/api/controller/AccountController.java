package com.ci123.shop.api.controller;

import com.ci123.shop.api.domain.Account;
import com.ci123.shop.api.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(
            @PathVariable("id") int id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "money", required = true) double money
    ) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        account.setId(id);
        int t = accountService.update(account);
        if (t == 1) {
            return account.toString();
        }
        return "fail";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postAccount(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "money", required = true) double money
    ) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        int t = accountService.add(account);
        if (t == 1) {
            return account.toString();
        }
        return "fail";
    }
}
