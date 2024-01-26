public class PrimeThread extends Thread {
	
	private int x;
	private int max;
	
	public PrimeThread(int x, int max) {
		this.x = x;
		this.max = max;
	}
	
	//override
	public void run() {
		while(x < max) {
			if(isPrime(x))
				Primes.primes.add(x);
			x += 20;
		}
	}
	
	public boolean isPrime(int x) {
		double sqrt = Math.sqrt(x);
		if(x % 3 == 0)
			return false;
		
		int num = 7;
		
		while(num <= sqrt) {
			if(x % num == 0)
				return false;
			
			num += 2;
		}
		
		return true;
	}
}
