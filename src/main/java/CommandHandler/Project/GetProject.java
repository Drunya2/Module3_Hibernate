package Hibernate.CommandHandler.Project;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Project;
import Hibernate.Storage.AbstractDao;

public class GetProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных");
                return;
            }
            AbstractDao<Project> projectDao = new AbstractDao<>(Project.class);
            Project project = projectDao.getDaoById(id);
            if (project != null) System.out.println("\n" + project);
            else System.out.println("\nProject not found");
        } else System.out.println("Неверное числа параметров!");
    }
}
