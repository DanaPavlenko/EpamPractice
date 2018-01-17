package lesson6;

class NewReleasePrice extends Price{

	
	public double getCharge(int days){
		double result = 0;
		return result += days * 3;
	}
	
	@Override
	public int getFrequentRentalPoints(int days){
		return 2;
	}
		
 }
