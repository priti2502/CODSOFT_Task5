package codesoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student
{
	private String name;
	private int rollno;
	private String grade;
	
	public Student(String name, int rollno, String grade) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", grade=" + grade + "]";
	}
	

}
class StudentManagement
{
	private List<Student>students;
	public StudentManagement()
	{
		students=new ArrayList<>();
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	
	public boolean removeStudent(int rollno)
	{
		for(Student s:students)
		{
			if(s.getRollno()==rollno)
			{
				students.remove(s);
				return true;
			}
		}
		return false;
		
	}
	
	public Student findStudent(int rollno)
	{
		for(Student s:students)
		{
			if(s.getRollno()==rollno)
			{
				
				return s;
			}
		}
		return null;
	}
	
	public List<Student> getAll()
	{
		return students;
	}
	
}
public class Task5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentManagement sm=new StudentManagement();
		while(true)
		{
			System.out.println("1.Add Student");
			System.out.println("2.Remove Student");
			System.out.println("3.Find Student");
			System.out.println("4.get All Student");
			System.out.println("5.Exit");
			System.out.println("Enter your option");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
				System.out.println("Enter your name");
				String name=sc.next();
				
				System.out.println("Enter your Roll no");
				int rollno=sc.nextInt();
				
				System.out.println("Enter your grade ");
				String grade=sc.next();
				
				Student s=new Student(name, rollno, grade);
				sm.addStudent(s);
				break;
			} 
			case 2:
			{
				System.out.println("Enter a RollNo");
				int rollno=sc.nextInt();
				boolean remove=sm.removeStudent(rollno);
				if(remove)
				{
					System.out.println("Student removed successfully");
				}
				else
				{
					System.out.println("student not found");
				}
				break;
			}
			case 3:
			{
				System.out.println("Enter a RollNo");
				int rollno=sc.nextInt();
				Student s=sm.findStudent(rollno);
				if(s!=null)
				{
					System.out.println("Student found");
					System.out.println(s);
				}
				else
				{
					System.out.println("student not found");
				}
				
				break;
			}
			case 4:
			{
				List<Student>li=sm.getAll();
				if(li.isEmpty())
				{
					System.out.println("no student found");
				}
				else
				{
					System.out.println("All Student");
					for(Student s:li)
					{
						System.out.println(s);
					}
				}
				break;
			}
			case 5:
			{
				System.out.println("Existing");
				sc.close();
				System.exit(0);
				
				break;
			}
			default:
			{
				System.out.println("Invalid Option");
				break;
			}
			}
		}
	}

}
