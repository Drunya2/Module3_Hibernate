package Hibernate.CommandHandler.Project;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Entity.Customer;
import Hibernate.Entity.Project;
import Hibernate.Storage.AbstractDao;

public class UpdateProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3 || parameters.length == 4 || parameters.length == 5) {
            long projectId = 0;
            long companyId = 0;
            long customerId = 0;
            String name = parameters[1];
            String description = parameters[2];
            try {
                projectId = Long.parseLong(parameters[0]);
                if (parameters.length == 4) companyId = Long.parseLong(parameters[3]);
                if (parameters.length == 5) {
                    companyId = Long.parseLong(parameters[3]);
                    customerId = Long.parseLong(parameters[4]);
                }
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных");
                return;
            }

            AbstractDao<Project> projectDao = new AbstractDao<>(Project.class);
            Project project = projectDao.getDaoById(projectId);
            project.setProjectName(name);
            project.setDescription(description);
            if (parameters.length == 4) {
                Company company = CreateProject.getCompanyById(companyId);
                project.setCompany(company);
            } else if (parameters.length == 5) {
                Company company = CreateProject.getCompanyById(companyId);
                project.setCompany(company);
                Customer customer = CreateProject.getCustomerById(customerId);
                project.setCustomer(customer);
            }
            projectDao.updateDao(project);
        } else System.out.println("Неверное число параметров!");
    }
}
