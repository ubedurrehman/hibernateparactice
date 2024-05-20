package com.tut;


import com.tut.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("2. Course");
        System.out.println("Please Select the Selection....");
        int selection= scanner.nextInt();

        if(selection == 1){
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teacher");
            System.out.println("3. Delete Teacher");
            System.out.println("4. Update  Teacher");
            System.out.println("5. All Teachers");
            int teacherSelection = scanner.nextInt();

            if(teacherSelection == 1){
                Teacher teacher = new Teacher();
                Session session = factory.openSession();
                System.out.println("Enter Teacher Name...");
                String name = scanner.nextLine();
                List<Teacher>  teachers = (List<Teacher>)  session.createQuery("From Teacher ", Teacher.class).list();

                System.out.println("Enter Teacher Address...");
                String address = scanner.nextLine();
                System.out.println("Enter Teacher remarks...");
                String remark = scanner.nextLine();
                System.out.println("Enter Teacher Salary...");
                float salary = scanner.nextInt();
                System.out.println("Enter Teacher qualification...");
                String qualification = scanner.nextLine();

                teacher.setName(name);
                teacher.setAddress(address);
                teacher.setRemarks(remark);
                teacher.setSalary(salary);
                teacher.setQualification(qualification);
//                Session session = factory.openSession();


                Transaction transaction = session.beginTransaction();
                int i = (int)session.save(teacher);
                if(i>0){
                    System.out.println("Data Inserted...");
                }
                transaction.commit();
                session.close();
            }

            if(teacherSelection==5){
                Session session = factory.openSession();
                List<Teacher>  teachers = (List<Teacher>)  session.createQuery("From Teacher ", Teacher.class).list();
                for(Teacher teacher : teachers){
                    System.out.println(teacher);
                    System.out.println(teacher.getName());
                }
            }


        }
        if(selection==2){

        }
        //Teacher END


    }
}

