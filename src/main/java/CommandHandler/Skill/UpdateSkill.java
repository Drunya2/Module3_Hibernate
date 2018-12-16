package Hibernate.CommandHandler.Skill;


import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Skill;
import Hibernate.Entity.SkillLevel;
import Hibernate.Storage.AbstractDao;

public class UpdateSkill implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных!");
                return;
            }
            String language = parameters[1];
            SkillLevel skillLevel = null;
            try {
                skillLevel = SkillLevel.valueOf(parameters[2]);
            } catch (IllegalArgumentException iae) {
                System.out.println("Level must be junior/middle/senior");
                return;
            }
            AbstractDao<Skill> skillDao = new AbstractDao<>(Skill.class);
            Skill skill = skillDao.getDaoById(id);
            if (skill != null) {
                skill.setSkill(language);
                skill.setSkillLevel(skillLevel);
                skillDao.updateDao(skill);
            } else System.out.println("Skill not found");
        } else System.out.println("Неверное число параметров!");
    }
}
