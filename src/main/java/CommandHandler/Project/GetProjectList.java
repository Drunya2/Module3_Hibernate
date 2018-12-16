package Hibernate.CommandHandler.Project;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Project;
import Hibernate.Storage.AbstractDao;

import java.util.List;

public class GetProjectList implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            AbstractDao<Project> projectDao = new AbstractDao<>(Project.class);
            List<Project> projects = projectDao.getAllDao();
            System.out.println();
            if (projects.isEmpty()) System.out.println("This table is clear!");
            else for (Project project : projects) System.out.println(project);
        } else System.out.println("Неверное число параметров!");
    }
}
