package Hibernate.CommandHandler;

import java.util.Scanner;

public class Help implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            String[] allCommands = new String[]{
                    "1. Комманды разработчика",
                    "2. Комманды проекта",
                    "3. Комманды навыков",
                    "4. Комманды компании",
                    "5. Комманды заказчиков"
            };

            String[] developerCommands = new String[]{
                    "\n Разработчики : ",
                    "1. Создать разработчика : ",
                    "Без компании - createDeveloper name surname sex(male или female) salary(long)",
                    "С компанией - createDeveloper name surname sex(male или female) salary(long) id_company(long)",
                    "2. Удалить разработчика - deleteDeveloper id(long)",
                    "3. Обновить разработчика : ",
                    "- Без компании - updateDeveloper name surname sex(male или female) salary(long)",
                    "- С компанией - updateDeveloper name surname sex(male или female) salary(long) id_company(long)",
                    "4. Получить разработчика - getDeveloper id(long)",
                    "5. Получить всех разработчиков - getDeveloperList"
            };

            String[] projectCommands = new String[]{
                    "\n Проекты : ",
                    "1. Создать проект : ",
                    "- Без компании и заказчика - createProject name description",
                    "- С компанией - createProject name description companyId(long)",
                    "- С компанией и заказчиком - createProject name description companyId(long) customerId(long)",
                    "2. Удалить проект - deleteProject id(long)",
                    "3. Обновить проект : ",
                    "- Без компании и заказчика - updateProject id(long) name description",
                    "- С компанией - updateProject id(long) name description companyId(long)",
                    "- С компанией и заказчиком - updateProject id(long) name description companyId(long) customerId(long)",
                    "4. Получить проект - getProject id(long)",
                    "5. Получить все проекты - getProjectList"
            };

            String[] skillCommands = new String[]{
                    "\n Навыки : ",
                    "1. Создать навык - createSkill skillName skillLevel(junior/middle/senior)",
                    "2. Удалить навык - deleteSkill id(long)",
                    "3. Обновить навык - updateSkill id(long) skillName skillLevel(junior/middle/senior)",
                    "4. Получить навык - getSkill id(long)",
                    "5. Получить все навыки - getSkillList"
            };

            String[] companyCommands = new String[]{
                    "\n Компании : ",
                    "1. Создать компанию - createCompany name city",
                    "2. Удалить компанию - deleteCompany id(long)",
                    "3. Обновить компанию - updateCompany id(long) name city",
                    "4. Получить компанию - getCompany id(long)",
                    "5. Получить все компании - getCompanyList"
            };

            String[] customerCommands = new String[]{
                    "\n Раказчики : ",
                    "1. Создать заказчика - createCustomer name country",
                    "2. Удалить заказчика - deleteCustomer id(long)",
                    "3. Обновить заказчика - updateCustomer id(long) name country",
                    "4. Получить заказчика - getCustomer id(long)",
                    "5. Получить всех заказчиков - getCustomerList"
            };
            for (String command : allCommands) System.out.println(command);
            Scanner scanner = new Scanner(System.in);
            int value = 0;
            try {
                value = scanner.nextInt();
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный формат введенных данных!");
                return;
            }

            switch (value) {
                case 1:
                    for (String command : developerCommands) System.out.println(command);
                    break;
                case 2:
                    for (String command : projectCommands) System.out.println(command);
                    break;
                case 3:
                    for (String command : skillCommands) System.out.println(command);
                    break;
                case 4:
                    for (String command : companyCommands) System.out.println(command);
                    break;
                case 5:
                    for (String command : customerCommands) System.out.println(command);
                    break;
            }
            System.out.println();
        } else System.out.println("Unknown command!");
    }
}
