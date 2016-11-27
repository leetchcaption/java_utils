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
		Student student = new Student(); //����һ��ѧ������
		student.setAge(20);
		student.setName("Yifan");
		try {
			ObjectOutputStream ooStream=new ObjectOutputStream(
					new FileOutputStream("F:/�ļ�/my Documents/Coder/JAVA/File/obj.txt"));
			//����һ�����������
			ooStream.writeObject(student); //�Ѷ���д�������,���л����ֳƴ�������java�����ڴ��е����ݲɱ��һ�������Ƶ����ݣ�Ȼ�����Щ����
										   //����ڿ��Գ־õ����ݴ洢�豸������̵�
			ooStream.close();			  //�ر������ 
			//����һ������������
			ObjectInputStream oisStream= new ObjectInputStream(
					new FileInputStream("F:/�ļ�/my Documents/Coder/JAVA/File/obj.txt"));
			Object object = oisStream.readObject();   //�����Ѿ����л��Ķ���
			Student stubac = (Student)object;         //��������ת��
			//��ӡ���ݵ�����̨��������л��ͷ����л��Ƿ�ɹ���
			System.out.println("student name is"+stubac.getname());
			System.out.println("student age is"+stubac.getage());
			oisStream.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}



