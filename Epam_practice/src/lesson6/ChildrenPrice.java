package lesson6;

class ChildrenPrice extends Price{
	
	public double getCharge(int days){
		double result = 1.5;
			if (days > 3)
				result += (days - 3) * 1.5;
		return result;
	}
	
}
