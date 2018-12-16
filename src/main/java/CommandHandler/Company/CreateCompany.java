package Hibernate.CommandHandler.Company;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Storage.AbstractDao;

public class CreateCompany implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2) {
            AbstractDao<Company> companyDao = new AbstractDao<>(Company.class);
            Company company = new Company();
            company.setName(parameters[0]);
            company.setCity(parameters[1]);
            companyDao.createDao(company);
        } else System.out.println("Неверное число параметров!");
    }
}
