package aop.melashvili.aopdemo;

import aop.melashvili.aopdemo.dao.AccountDAO;
import aop.melashvili.aopdemo.dao.MembershipDAO;
import aop.melashvili.aopdemo.dao.MembershipDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopBeforeAdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopBeforeAdviceApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
			demoTheBeforeAdvice(accountDAO);
			demoTheBeforeAdviceMembership(membershipDAO);
		};
	}

	private void demoTheBeforeAdviceMembership(MembershipDAO membershipDAO) {
		membershipDAO.addAccount();
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {
		accountDAO.addAccount();
	}
}
