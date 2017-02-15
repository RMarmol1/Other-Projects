public class ByPrice {
	private Object comparison;
	private String myNum;
	private String myRange1;
	private String myRange2;
	
	
	public ByPrice()
	{
		comparison = "";
		myNum = "0";
		myRange1 = "0";
		myRange2 = "0";
	}
	
	public Object getComparison() {
		return comparison;
	}
	
	public void setComparison(Object comparison) {
		this.comparison = comparison;
	}
	
	public String getNum() {
		return myNum;
	}
	
	public void setNum(String myNum) {
		this.myNum = myNum;
	}
	
	public String getRange1() {
		return myRange1;
	}
	
	public void setRange1(String myRange1) {
		this.myRange1 = myRange1;
	}
	
	public String getRange2() {
		return myRange2;
	}
	
	public void setRange2(String myRange2) {
		this.myRange2 = myRange2;
	}
}