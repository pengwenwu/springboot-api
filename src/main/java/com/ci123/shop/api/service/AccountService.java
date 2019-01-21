package com.ci123.shop.api.service;

import com.ci123.shop.api.domain.Account;
import com.ci123.shop.api.domain.IAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountService implements IAccountService {
    @Autowired
    IAccountDAO accountDAO;

    @Override
    public int add(Account account) {
        return accountDAO.add(account);
    }

    @Override
    public int delete(int id) {
        return accountDAO.delete(id);
    }

    @Override
    public int update(Account account) {
        return accountDAO.update(account);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDAO.findAccoutById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDAO.findAccountList();
    }
}
