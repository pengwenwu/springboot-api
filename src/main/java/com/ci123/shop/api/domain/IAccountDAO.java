package com.ci123.shop.api.domain;

import java.util.List;

public interface IAccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccoutById(int id);

    List<Account> findAccountList();
}
