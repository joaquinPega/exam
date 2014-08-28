package muestradehilos;

public class mainprueba {
	public static int c = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1,t2,t3,t4,t5;
		t1=new Thread(new Handler(true,"thread1"));
		t2=new Thread(new Handler(true,"thread2"));
		t3=new Thread(new Handler(true,"thread3"));
		t4=new Thread(new Handler(true,"thread4"));
		t5=new Thread(new Handler(true,"thread5"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		try {
			Thread.sleep(199);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
