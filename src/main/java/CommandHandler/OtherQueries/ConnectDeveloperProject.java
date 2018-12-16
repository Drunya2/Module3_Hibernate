package Hibernate.CommandHandler.OtherQueries;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Developer;
import Hibernate.Entity.Project;
import Hibernate.Storage.AbstractDao;

import java.util.HashSet;
import java.util.Set;

public class ConnectDeveloperProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2) {
            long developerId = 0;
            long projectId = 0;
            try {
                developerId = Long.parseLong(parameters[0]);
                projectId = Long.parseLong(parameters[1]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный формат введенных данных!");
                return;
            }
            AbstractDao<Developer> developerDao = new AbstractDao<>(Developer.class);
            AbstractDao<Project> projectDao = new AbstractDao<>(Project.class);
            Developer developer = developerDao.getDaoById(developerId);
            Project project = projectDao.getDaoById(projectId);
            if (developer == null) {
                System.out.println("Developer not found");
                return;
            }
            if (project == null) {
                System.out.println("Project not found");
                return;
            }
            Set<Project> projects = new HashSet<>();
            projects.add(project);
            developer.setProjects(projects);
            developerDao.updateDao(developer);
        } else System.out.println("Неверное число параметров!");
    }
}
