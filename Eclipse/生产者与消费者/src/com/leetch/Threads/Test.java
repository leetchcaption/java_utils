package com.leetch.Threads;
import java.lang.*; 
public class Test {
	public static void main(String args[]){
		Godown godown = new Godown(30);
		Consumer c1 = new Consumer(50,godown) ;
		Consumer c2 = new Consumer(20, godown);
		Consumer c3 = new Consumer(30, godown);
		Producer p1 = new Producer(10, godown);
		Producer p2 = new Producer(10, godown);
		Producer p3 = new Producer(10, godown);
		Producer p4 = new Producer(10, godown);
		Producer p5 = new Producer(10, godown);
		Producer p6 = new Producer(10, godown);
		
		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
	}
}
class Godown{
	public static final int max_size = 100 ;//�������
	public int curnum ; //��ǰ�����
	public Godown() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public Godown(int curnum){
		this.curnum = curnum;
	}
	public synchronized void produce(int neednum){ //����ָ�������Ĳ�Ʒ 
		while((neednum+curnum)>max_size){//����Ƿ���Ҫ����
			System.out.println("Ҫ�����Ĳ�Ʒ����"+neednum+"����ʣ������"+(max_size-curnum)+",��ʱ����ִ����������1");
			 try{
				 //��ǰ�������̵߳ȴ�
				 wait();
			 }catch (InterruptedException e){
				 e.printStackTrace();
			 }
		}
		//����������������������������ĵ�ǰ�����
		curnum += neednum;
		System.out.println("�Ѿ�������"+neednum+"����Ʒ���ֲִ���Ϊ"+curnum);
		//�����ڴ˶���������ϵȴ��������߳�
		notifyAll();	
	}
	public synchronized void consume(int neednum){
		while((curnum<neednum)) { //����Ƿ��������
			try{
				//��ǰ�������̵߳ȴ�
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//����������������������ѣ������ĵ�ǰ�����
		curnum -= neednum;
		System.out.println("�Ѿ�������"+neednum+"����Ʒ���ֲִ���Ϊ"+curnum);
		//�����ڴ˼������ϵȴ��������߳�
		notifyAll();
	}
}
/* ������ */
class Producer extends Thread{
	private int neednum ;     // ������Ʒ����
	private Godown godown;   //�ֿ�
	
	public Producer(int neednum,Godown godown) {
		// TODO �Զ����ɵĹ��캯�����
		this.neednum = neednum ;
		this.godown = godown;
	}
	public void run(){
		//����ָ�������Ĳ�Ʒ
		godown.produce(neednum);
	}
}
/* ������ */
class Consumer extends Thread{
	private int neednum ;  // ������Ʒ����
	private Godown godown; //�ֿ�
	public Consumer(int needrum,Godown godown) {
		// TODO �Զ����ɵĹ��캯�����
		this.neednum = needrum;
		this.godown = godown;
	}
	public void run(){
		//����ָ�������Ĳ�Ʒ
		godown.consume(neednum);
	}
}