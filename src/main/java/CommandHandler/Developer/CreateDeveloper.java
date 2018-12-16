package Hibernate.CommandHandler.Developer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Entity.Developer;
import Hibernate.Entity.Sex;
import Hibernate.Storage.AbstractDao;

public class CreateDeveloper implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 5 || parameters.length == 4) {
            AbstractDao<Developer> abstractDao = new AbstractDao<>(Developer.class);
            AbstractDao<Company> abstractDao1 = new AbstractDao<>(Company.class);
            Developer developer = new Developer();
            developer.setName(parameters[0]);
            developer.setSurname(parameters[1]);
            long salary = 0;
            long companyId = 0;
            try {
                salary = Long.parseLong(parameters[3]);
                if (parameters.length == 5)
                    companyId = Long.parseLong(parameters[4]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип данных");
                return;
            }

            try {
                developer.setSex(Sex.valueOf(parameters[2]));
            } catch (IllegalArgumentException ae) {
                System.out.println("This field must be male/female");
                return;
            }
            developer.setSalary(salary);
            if (parameters.length == 5) {
                Company company = abstractDao1.getDaoById(companyId);
                if (company == null) System.out.println("Компании с таким ID нет, сохранено со значением null");
                developer.setCompany(company);
            }
            abstractDao.createDao(developer);
        } else System.out.println("Неверное число параметров");
    }
}
