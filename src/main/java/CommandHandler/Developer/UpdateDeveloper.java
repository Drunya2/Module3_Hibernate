package Hibernate.CommandHandler.Developer;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Entity.Developer;
import Hibernate.Entity.Sex;
import Hibernate.Storage.AbstractDao;

public class UpdateDeveloper implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 5 || parameters.length == 6) {
            long developerId = 0;
            long salary = 0;
            long companyId = 0;
            try {
                developerId = Long.parseLong(parameters[0]);
                salary = Long.parseLong(parameters[4]);
                if (parameters.length == 6) companyId = Long.parseLong(parameters[5]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных");
                return;
            }
            AbstractDao<Developer> developerDao = new AbstractDao<>(Developer.class);
            Developer developer = developerDao.getDaoById(developerId);
            if (developer == null) {
                System.out.println("Developer not found");
                return;
            }
            developer.setName(parameters[1]);
            developer.setSurname(parameters[2]);
            try {
                developer.setSex(Sex.valueOf(parameters[3]));
            } catch (IllegalArgumentException iae) {
                System.out.println("This field must be male/female");
                return;
            }
            developer.setSalary(salary);
            if (parameters.length == 6) {
                AbstractDao<Company> abstractDao1 = new AbstractDao<>(Company.class);
                Company company = abstractDao1.getDaoById(companyId);
                if (company == null) System.out.println("Компании с таким ID нет, сохранено со значением null");
                developer.setCompany(company);
            }
            developerDao.updateDao(developer);
        } else System.out.println("Неверное число параметров");
    }

}
