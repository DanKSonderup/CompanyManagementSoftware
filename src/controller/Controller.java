package controller;

import model.Company;
import model.Customer;
import model.Employee;
import storage.Storage;

import java.util.ArrayList;

public abstract class Controller {

    /**
     * Create a new Company.
     * Pre: name not empty, hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.storeCompany(company);
        return company;
    }

    /**
     * Delete the company.
     * Pre: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.deleteCompany(company);
    }

    /**
     * Update the company.
     * Pre: name not empty, hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Create a new employee.
     * Pre: name not empty, wage >= 0.
     */
    public static Employee createEmployee(String name, int wage) {
        Employee employee = new Employee(name, wage);
        Storage.storeEmployee(employee);
        return employee;
    }

    /**
     * Delete the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
        }
        Storage.deleteEmployee(employee);
    }

    /**
     * Update the employee.
     * Pre: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage) {
        employee.setName(name);
        employee.setWage(wage);
    }
    public static void updateEmployeeWithEmploymentYear(Employee employee, String name, int wage, int year) {
        employee.setName(name);
        employee.setWage(wage);
        employee.setEmploymentYear(year);
    }

    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }

    // -------------------------------------------------------------------------

    /**
     * Add the employee to the company.
     * If the employee is connected to another company, this connected is removed.
     */
    public static void addEmployeeToCompany(Employee employee, Company company) {
        var oldCompany = employee.getCompany();
        if (oldCompany != null) {
            oldCompany.removeEmployee(employee);
        }
        employee.setCompany(company);
        company.addEmployee(employee);
    }
    public static void addEmployeeToCompanyWithYear(Employee employee, Company company, int year) {
        var oldCompany = employee.getCompany();
        if (oldCompany != null) {
            oldCompany.removeEmployee(employee);
        }
        employee.setCompany(company);
        employee.setEmploymentYear(year);
        company.addEmployee(employee);
    }

    /**
     * Remove the employee's company, if the employee has a company.
     */
    public static void removeEmployeeFromCompany(Employee employee, Company company) {
        if (employee.getCompany() != null) {
            company.removeEmployee(employee);
            employee.setCompany(null);
        }
    }
    public static Customer createCustomer(String name) {
        Customer customer1 = new Customer(name);
        Storage.storeCustomer(customer1);
        return customer1;
    }
    /**
     * Add customer to a company
     */
    public static void addCustomerToCompany(Customer customer, Company company) {
        company.addCustomer(customer);
    }
    public static void deleteCustomer(Customer customer) {
        Storage.deleteCustomer(customer);
    }


}
