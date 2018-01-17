package lesson6;

public class Movie {
	private String _title;
	private Price price;

	public Movie(String title, int priceCode) {
		_title = title;
	}

	public String getTitle() {
		return _title;
	}
	
	public double getCharge(int days){
		return price.getCharge(days);
	}
	
	public int getFrequentRentalPoints(int days){
		return price.getFrequentRentalPoints(days);
	}
}