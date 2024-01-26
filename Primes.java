import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Primes {
	
	//declare a global variable ArrayList to contain our primes
	static List<Integer> primes = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		//add initial primes to our list
		primes.add(2);
		primes.add(3);
		primes.add(5);
		
		//set upperbound
		int max = (int) Math.pow(10, 8);
		
		//set our threads
		PrimeThread t1 = new PrimeThread(7, max);
		PrimeThread t2 = new PrimeThread(9, max);
		PrimeThread t3 = new PrimeThread(11, max);
		PrimeThread t4 = new PrimeThread(13, max);
		PrimeThread t5 = new PrimeThread(17, max);
		PrimeThread t6 = new PrimeThread(19, max);
		PrimeThread t7 = new PrimeThread(21, max);
		PrimeThread t8 = new PrimeThread(23, max);
		
		//start our threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		
		while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() || t5.isAlive() || t6.isAlive() || t7.isAlive() || t8.isAlive());
		
		Collections.sort(primes);
		
		long end = System.nanoTime();
		double time = (double) ((end - start) / Math.pow(10, 9));
		
		long sum = 0;
		for(int i = 0; i < primes.size(); i++)
			sum += primes.get(i);
		
		
		try {
			File f = new File("primes.txt");
			if(f.createNewFile()) {
				System.out.println("File created");
			}
			else {
				System.out.println("File exists");
			}
			
			FileWriter writer = new FileWriter("primes.txt");
			
			writer.write(time + " seconds " + primes.size() + " " + sum);
			
			String s = "";
			for(int i = 10; i > 0; i--) {
				s += primes.get(primes.size() - i) + " ";
			}
			writer.write(s);
			
			writer.close();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
