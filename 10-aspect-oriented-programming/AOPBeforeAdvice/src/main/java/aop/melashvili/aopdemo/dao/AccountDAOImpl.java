package aop.melashvili.aopdemo.dao;

import aop.melashvili.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + ": adding an account");
    }
}
