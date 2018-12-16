package Hibernate.CommandHandler.Company;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Storage.AbstractDao;

import java.util.List;

public class GetCompanyList implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            AbstractDao<Company> companyDao = new AbstractDao<>(Company.class);
            List<Company> companies = companyDao.getAllDao();
            System.out.println();
            if (companies.isEmpty()) System.out.println("This table is clear!");
            else for (Company company : companies) System.out.println(company);
        } else System.out.println("Неверное число параметров!");
    }
}
