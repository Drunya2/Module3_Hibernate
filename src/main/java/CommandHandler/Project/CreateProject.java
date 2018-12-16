package Hibernate.CommandHandler.Project;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Entity.Customer;
import Hibernate.Entity.Project;
import Hibernate.Storage.AbstractDao;

public class CreateProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2 || parameters.length == 3 || parameters.length == 4) {
            String name = parameters[0];
            String description = parameters[1];
            long companyId = 0;
            long customerId = 0;
            try {
                if (parameters.length == 3) companyId = Long.parseLong(parameters[2]);
                if (parameters.length == 4) {
                    companyId = Long.parseLong(parameters[2]);
                    customerId = Long.parseLong(parameters[3]);
                }
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных!");
                return;
            }
            AbstractDao<Project> projectDao = new AbstractDao<>(Project.class);
            Project project = new Project();
            project.setProjectName(name);
            project.setDescription(description);
            if (parameters.length == 3) {
                Company company = getCompanyById(companyId);
                project.setCompany(company);
            } else if (parameters.length == 4) {
                Company company = getCompanyById(companyId);
                project.setCompany(company);
                Customer customer = getCustomerById(customerId);
                project.setCustomer(customer);
            }
            projectDao.createDao(project);
        } else System.out.println("Неверное число параметров!");
    }

    public static Customer getCustomerById(long id) {
        AbstractDao<Customer> customerDao = new AbstractDao<>(Customer.class);
        Customer customer = customerDao.getDaoById(id);
        if (customer == null) System.out.println("Customer not found, save with value Null");
        return customer;
    }

    public static Company getCompanyById(long id) {
        AbstractDao<Company> companyDao = new AbstractDao<>(Company.class);
        Company company = companyDao.getDaoById(id);
        if (company == null) System.out.println("Company not found, save with value Null");
        return company;
    }
}
