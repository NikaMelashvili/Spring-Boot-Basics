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
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Nika");
		myAccount.setLevel("Gold");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}
}
