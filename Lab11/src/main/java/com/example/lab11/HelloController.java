package com.example.lab11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.*;

public class HelloController {
   private final List<Employee> employees = new ArrayList<>();
   private ObservableList<Employee> itemstoRender;

   @FXML
    private ListView<Employee> lvSEmpleados;

   protected void initList(){
       employees.add(new Employee("Marta", 40, 1500.89));
       employees.add(new Employee("Enrique", 35, 500.5));
       employees.add(new Employee("María", 32, 450.0));
       employees.add(new Employee("Melisa", 56, 2000.0));
       employees.add(new Employee("Victor", 28, 1200.0));
       employees.add(new Employee("Daniel", 46, 1000.0));
       employees.add(new Employee("Rebeca", 41, 800.0));
       employees.add(new Employee("Eduardo", 25, 1500.89));
   }
   public void initialize(){
       initList();

       itemstoRender = FXCollections.observableArrayList(employees);
       lvSEmpleados.setItems(itemstoRender);
       lvSEmpleados.setCellFactory(param -> new ListCell<Employee>(){
           @Override
           protected void updateItem(Employee e, boolean empty) {
               super.updateItem(e, empty);

               if (e == null || empty) {
                   setText(null);
               } else {
                   setText(e.getName() + " - Age: " + e.getAge() + ", Salary: " + e.getSalary());
               }
           }
       });

   }
   public void sortByName(){
       Collections.sort(employees, new Comparator<Employee>() {
           @Override
           public int compare(Employee o1, Employee o2) {
               return o1.getName().compareTo(o2.getName());
           }
       });
       itemstoRender = FXCollections.observableArrayList(employees);
       lvSEmpleados.setItems(itemstoRender);
   }
   public void sortBySalary(){
       Collections.sort(employees, new Comparator<Employee>() {
           @Override
           public int compare(Employee o1, Employee o2) {
               return Double.compare(o1.getSalary(),o2.getSalary());
           }
       });
       itemstoRender = FXCollections.observableArrayList(employees);
       lvSEmpleados.setItems(itemstoRender);
   }

}