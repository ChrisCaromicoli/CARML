
public class Portfolio {
	private static int capital = 10000;
	private static double deltaThreshold = 1000;

	public static void main(String[] args) {
		//Initalize all stocks with volumes. Volumes are based on an equal distribution of capital
		Stock A = new Stock();
		A.volume = (int) Math.floor(capital/5/A.getPrice());
		Stock B = new Stock();
		B.volume = (int) Math.floor(capital/5/B.getPrice());
		Stock C = new Stock();
		C.volume = (int) Math.floor(capital/5/C.getPrice());
		Stock D = new Stock();
		D.volume = (int) Math.floor(capital/5/D.getPrice());
		Stock E = new Stock();
		E.volume = (int) Math.floor(capital/5/E.getPrice());
		//Initialize portfolio delta and option position
		init(A,B,C,D,E);
		//Using changing price to determine when to rebalance
		timeChange(A,B,C,D,E);
		
	}
	//Calculating the days changes
	private static void timeChange(Stock A, Stock B, Stock C, Stock D, Stock E) {
		//double deltaThreshold = 0.0;
		for(int i=0; i<10; i++){
			//Hold onto old price
			A.oldPrice=A.price;
			B.oldPrice=B.price;
			C.oldPrice=C.price;
			D.oldPrice=D.price;
			E.oldPrice=E.price;
			//Calculate new price (for now this replaces actual stock data)
			double ran = Math.random();
			if(ran>0.5){
				A.price-=5;
				B.price+=1;
				C.price-=1;
				D.price+=5;
				E.price+=1;
			}
			else{
				A.price+=1;
				B.price-=3;
				C.price+=1;
				D.price-=6;
				E.price-=1;
			}
				/**
				 * Need to figure out how to determine delta so it won't change portfolio as often
				 */
				//System.out.println(deltaThreshold);
				double option = 0.0;
				double delta = determineDelta(A, B, C, D, E);
				option = determineOption(delta);
				//System.out.println(deltaThreshold);
				if(delta+option > deltaThreshold){
					redistributePortfolio(A,B,C,D,E);
					showPortfolio(A,B,C,D,E,delta,option);
				}
				deltaThreshold = delta;
				//showPortfolio(A,B,C,D,E,delta,option);
				
		}
		
	}
	private static void redistributePortfolio(Stock a, Stock b, Stock c, Stock d, Stock e) {
		sell(a,b,c,d,e);
		buy(a,b,c,d,e);
		
		
	}
	private static void buy(Stock a, Stock b, Stock c, Stock d, Stock e) {
		double remaining = calculateRemainingCapital(a,b,c,d,e);
		if(a.price>a.oldPrice&&remaining>a.getPrice()*a.bundle)
			a.volume+=a.bundle;
		if(b.price>b.oldPrice&&remaining>b.getPrice()*b.bundle)
			b.volume+=b.bundle;
		if(c.price>c.oldPrice&&remaining>c.getPrice()*c.bundle)
			c.volume+=c.bundle;
		if(d.price>d.oldPrice&&remaining>d.getPrice()*d.bundle)
			d.volume+=d.bundle;
		if(e.price>e.oldPrice&&remaining>e.getPrice()*e.bundle)
			e.volume+=e.bundle;
		
		
	}
	private static double calculateRemainingCapital(Stock a, Stock b, Stock c, Stock d, Stock e) {
		return capital-a.getPrice()-b.getPrice()-c.getPrice()-d.getPrice()-e.getPrice();
	}
	private static void sell(Stock a, Stock b, Stock c, Stock d, Stock e) {
		if(a.price<a.oldPrice)
			a.volume-=a.bundle;
		if(b.price<b.oldPrice)
			b.volume-=b.bundle;
		if(c.price<c.oldPrice)
			c.volume-=c.bundle;
		if(d.price<d.oldPrice)
			d.volume-=d.bundle;
		if(e.price<e.oldPrice)
			e.volume-=e.bundle;
		
	}
	//Initial setup of portfolio delta and underlining option
	private static void init(Stock A, Stock B, Stock C, Stock D, Stock E) {
		double delta = determineDelta(A,B,C,D,E);
		double option = determineOption(delta);
		showPortfolio(A,B,C,D,E,delta,option);
	}
	//Show portfolio with price and volume including delta nad option
	private static void showPortfolio(Stock a, Stock b, Stock c, Stock d, Stock e,double delta, double option) {
		String str = "The price of stock A is " + a.getPrice() +" with " + a.volume +" shares,\nthe price of stock B is " +
	b.getPrice() +" with " + b.volume + " shares,\nthe price of stock C is " + c.getPrice() +" with " + c.volume + 
	" shares,\nthe price of stock D is " + d.getPrice() +" with " + d.volume +" shares,\nthe price of stock E is " + e.getPrice() +
	" with " + e.volume+
	" shares \nwith delta "+ delta + " and option " + option + ".";
		System.out.println(str);
		
	}
	private static double determineOption(double delta) {
		double option = 0.0;
		//if(Math.abs(delta) > Math.abs(deltaThreshold)){
			option = -delta/2;
		//}
		return option;
	}

	public static double determineDelta(Stock a, Stock b, Stock c, Stock d, Stock e){
		double delta = a.getPrice()*a.volume*(1-a.getRisk())+b.getPrice()*b.volume*(1-b.getRisk())+c.getPrice()*c.volume*(1-c.getRisk())
				+d.getPrice()*d.volume*(1-d.getRisk())+e.getPrice()*e.volume*(1-e.getRisk());
		//System.out.println("The delta is " + delta);
		return Math.floor(delta);
	}
}
