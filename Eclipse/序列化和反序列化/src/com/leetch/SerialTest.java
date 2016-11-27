package com.leetch;
import java.io.*;
import java.sql.Connection;
class Student implements Serializable{
	private static final long serialVersionUID=1L;
	private String nameString ;
	private int ageInt;
	public String getname(){
		return this.nameString;
	}
	public int getage(){
		return this.ageInt;
	}
	public void setName(String name){
		this.nameString = name;
	}
	public void setAge(int age){
		this.ageInt=age;
	}
}
public class SerialTest {
	public static void main(String[] args){
		Student student = new Student(); //创建一个学生对象
		student.setAge(20);
		student.setName("Yifan");
		try {
			ObjectOutputStream ooStream=new ObjectOutputStream(
					new FileOutputStream("F:/文件/my Documents/Coder/JAVA/File/obj.txt"));
			//创建一个对象输出流
			ooStream.writeObject(student); //把对象写入输出流,序列化，又称串化，把java对象内存中的数据采编成一串二进制的数据，然后把这些数据
										   //存放在可以持久的数据存储设备，如磁盘等
			ooStream.close();			  //关闭输出流 
			//创建一个对象输入流
			ObjectInputStream oisStream= new ObjectInputStream(
					new FileInputStream("F:/文件/my Documents/Coder/JAVA/File/obj.txt"));
			Object object = oisStream.readObject();   //读出已经序列化的对象
			Student stubac = (Student)object;         //进行类型转换
			//打印数据到控制台，检查序列化和反序列化是否成功？
			System.out.println("student name is"+stubac.getname());
			System.out.println("student age is"+stubac.getage());
			oisStream.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}



