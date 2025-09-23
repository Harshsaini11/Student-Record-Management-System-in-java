package HARSH;

import java.util.*;

class Student 
{
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks)
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagement 
{
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent()
    {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        students.add(new Student(id, name, marks));
        System.out.println("Student Added.\n");
    }

    static void viewStudents() 
    {
        if (students.isEmpty())
        {
            System.out.println("No records found.\n");
            return;
        }
        for (Student s : students) 
        {
            System.out.println("ID: " + s.id + " | Name: " + s.name + " | Marks: " + s.marks);
        }
        System.out.println();
    }

    static void updateStudent() 
    {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students)
        {
            if (s.id == id)
            {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();
                System.out.println("Record Updated.\n");
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    static void deleteStudent() 
    {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) 
            {
                it.remove();
                System.out.println("Record Deleted.\n");
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Update Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) 
            {
                case 1: addStudent(); 
                break;
                case 2: viewStudents(); 
                break;
                case 3: updateStudent(); 
                break;
                case 4: deleteStudent();
                break;
                case 5: System.out.println("Exiting..."); 
                return;
                default: System.out.println("Invalid choice.\n");
            }
        }
        }
}