package Hibernate.Start;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.CommandHandler.Company.*;
import Hibernate.CommandHandler.Customer.*;
import Hibernate.CommandHandler.Developer.*;
import Hibernate.CommandHandler.Help;
import Hibernate.CommandHandler.OtherQueries.ConnectDeveloperProject;
import Hibernate.CommandHandler.OtherQueries.ConnectDeveloperSkill;
import Hibernate.CommandHandler.Project.*;
import Hibernate.CommandHandler.Skill.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static String command;
    private static String parameters[];
    private static boolean isExit = false;
    private static Map<String, CommandHandler> commands;

    private static void readCommand() {
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();
        String[] array = query.split(" ");
        command = array[0];
        parameters = new String[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            parameters[i - 1] = array[i];
        }
    }

    private static void handleCommand() {
        while (isExit != true) {
            readCommand();
            if (command.equals("exit")) {
                isExit = true;
                System.exit(0);
                return;
            }

            if (!commands.containsKey(command)) {
                System.out.println("Unknown comamnd: " + command);
                return;
            }
            commands.get(command).handleCommand(parameters);
        }
    }

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("help", new Help());
        commands.put("createDeveloper", new CreateDeveloper());
        commands.put("deleteDeveloper", new DeleteDeveloper());
        commands.put("updateDeveloper", new UpdateDeveloper());
        commands.put("getDeveloper", new GetDeveloper());
        commands.put("getDeveloperList", new GetDeveloperList());
        commands.put("createProject", new CreateProject());
        commands.put("deleteProject", new DeleteProject());
        commands.put("updateProject", new UpdateProject());
        commands.put("getProject", new GetProject());
        commands.put("getProjectList", new GetProjectList());
        commands.put("createSkill", new CreateSkill());
        commands.put("deleteSkill", new DeleteSkill());
        commands.put("updateSkill", new UpdateSkill());
        commands.put("getSkill", new GetSkill());
        commands.put("getSkillList", new GetSkillList());
        commands.put("createCompany", new CreateCompany());
        commands.put("deleteCompany", new DeleteCompany());
        commands.put("updateCompany", new UpdateCompany());
        commands.put("getCompany", new GetCompany());
        commands.put("getCompanyList", new GetCompanyList());
        commands.put("createCustomer", new CreateCustomer());
        commands.put("deleteCustomer", new DeleteCustomer());
        commands.put("updateCustomer", new UpdateCustomer());
        commands.put("getCustomer", new GetCustomer());
        commands.put("getCustomerList", new GetCustomerList());
        commands.put("connectDeveloperSkill", new ConnectDeveloperSkill());
        commands.put("connectDeveloperProject", new ConnectDeveloperProject());
    }

    public static void main(String[] args) {
        initCommands();
        while (!isExit) {
            handleCommand();
            System.out.println();
        }
    }
}
