package modelBridge;

import java.util.Date;

public class StockList {
	private Stock[] list;
	private int size;
	private Date date;
	
	public StockList(String[] symbolArray , Date dateIn ){
		createArray(symbolArray);
		setSize(symbolArray.length);
		setDate(dateIn);
		
	}
	
	private void createArray(String[] symbolArray) {
		list = new Stock[symbolArray.length];
		String symboltemp;
		for(String symbol : symbolArray){
			
		}
			
	}

	public StockList(){
		
	}
	private void setSize(int sizeIn){
		
	}
	private void setDate(Date dateIn){
		
	}
	public void addStock(Stock newStock){
		
	}
}
//Date date = new Date(); 
//System.out.println("Current Date : "+dateFormat.format(date))