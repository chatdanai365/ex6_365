/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class StudentJPA {

   
    public static void main(String[] args) {
//       Student std1 = new Student(1, "jack", 4.00);
//       Student std2 = new Student(2, "Guy", 3.05);
//       StudentTable.insertStudent(std1);
//       StudentTable.insertStudent(std2);
       
//       Student std;
//       std = StudentTable.findStudentById(1);
//       if(std != null){
//           std.setName("Jason");
//           std.setGpa(3.99);
//       }
//       StudentTable.updateStudent(std);
       
//       StudentTable.removeStudent(StudentTable.findStudentById(2));
       
       List<Student> stdList1 = StudentTable.findStudentByName("Guy");
       printAllStudent(stdList1);
      
       List<Student> stdList = StudentTable.findAllStudent();
       printAllStudent(stdList);
    }
    
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
