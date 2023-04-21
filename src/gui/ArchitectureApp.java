package gui;

import controller.Controller;
import model.Company;
import model.Customer;
import model.Employee;
import javafx.application.Application;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee bob = Controller.createEmployee("Bob Dole", 210);
        Controller.addEmployeeToCompanyWithYear(bob, ibm, 2001);

        Employee alice = Controller.createEmployee("Alice Schmidt", 250);
        Controller.addEmployeeToCompany(alice, ibm);

        Employee george = Controller.createEmployee("George Down", 150);
        Controller.addEmployeeToCompanyWithYear(george, amd, 1998);

        Employee rita = Controller.createEmployee("Rita Uphill", 300);
        Controller.addEmployeeToCompany(rita, sled);

        Controller.createEmployee("John Doe", 100);

        Customer martin = Controller.createCustomer("Martin");
        Controller.addCustomerToCompany(martin, ibm);

        Customer daniel = Controller.createCustomer("Daniel");
        Controller.addCustomerToCompany(daniel, ibm);

        Customer jens = Controller.createCustomer("Jens");
        Controller.addCustomerToCompany(jens, amd);
    }
}
