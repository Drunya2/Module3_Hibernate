package Hibernate.CommandHandler.OtherQueries;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Developer;
import Hibernate.Entity.Skill;
import Hibernate.Storage.AbstractDao;

import java.util.HashSet;
import java.util.Set;

public class ConnectDeveloperSkill implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2) {
            long developerId = 0;
            long skillId = 0;
            try {
                developerId = Long.parseLong(parameters[0]);
                skillId = Long.parseLong(parameters[1]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный формат введенных данных!");
                return;
            }
            AbstractDao<Developer> developerDao = new AbstractDao<>(Developer.class);
            AbstractDao<Skill> skillDao = new AbstractDao<>(Skill.class);
            Developer developer = developerDao.getDaoById(developerId);
            Skill skill = skillDao.getDaoById(skillId);
            if (developer == null) {
                System.out.println("Developer not found");
                return;
            }
            if (skill == null) {
                System.out.println("Skill not found");
                return;
            }
            Set<Skill> skills = new HashSet<>();
            skills.add(skill);
            developer.setSkills(skills);
            developerDao.updateDao(developer);
        } else System.out.println("Неверное число параметров!");
    }
}
