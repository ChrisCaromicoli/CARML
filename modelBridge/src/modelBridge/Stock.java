package modelBridge;

public class Stock implements Comparable< Stock > {
	public final String symbol;
	private double price;
	private double risk;
	private double slope;
	private int bundle;
	private int volume;
	
	static final int slopeInterval = 10;
	
	// created parameters for stock constructor and made a single parameter
	// constructor that generates random risks and prices.

	//	**CONSTRUCTOR**

	public Stock(String symbolIn) {
		findPrice(Math.floor(Math.random() * 100));
		findRisk(Math.floor(Math.random() * 100) / 100);
		symbol = symbolIn;
		this.bundle = 10;
	}
	//	**SETTERS**
	public void setPrice(double priceIn) {

		this.price = priceIn;
		// System.out.println(price);
	}

	public void setRisk(double riskIn) {
		int numShares = Shares(symbol)
		this.risk = price*numShares;
		// sSystem.out.println(risk);
	}
	
	private int Shares(String symbol) {
		//				**
		//	        	**
		//  finish this **
		//				**
		//				**
		//				**
		return 100000;
	}

	//	**GETTERS**
	public double getPrice() {
		return this.price;
	}

	public double getRisk() {
		return this.risk;
	}

	public int getBundle() {
		return this.bundle;
	}

	public double getSlope() {
		return this.slope;
	}

	public int getVolume() {
		return this.volume;
	}
	
	private void findSlope(String symbol){
		//GET TIME AND PRICE DATA FROM DOWNIE
		
		
		double newSlope = 1.0;
		this.slope = newSlope;
		
	}

	//add any changes to the attributes to this clone function
	public Stock clone(){
		//				**
		//	        	**
		//  finish this **
		//				**
		//				**
		//				**
		Stock newStock = new Stock (symbol, price,risk);
		return newStock;
	}
	
	@Override
	public int compareTo(Stock otherStock) {
		if (this.slope > otherStock.slope)
			return 1;
		else if(this.slope < otherStock.slope)
			return -1;
		else
			return 0;
	}
}

/*public static void main(String[] args) { 
    int MAXN = 1000;
    int n = 0;
    double[] x = new double[MAXN];
    double[] y = new double[MAXN];

    // first pass: read in data, compute xbar and ybar
    double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
    while(!StdIn.isEmpty()) {
        x[n] = StdIn.readDouble();
        y[n] = StdIn.readDouble();
        sumx  += x[n];
        sumx2 += x[n] * x[n];
        sumy  += y[n];
        n++;
    }
    double xbar = sumx / n;
    double ybar = sumy / n;

    // second pass: compute summary statistics
    double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
    for (int i = 0; i < n; i++) {
        xxbar += (x[i] - xbar) * (x[i] - xbar);
        yybar += (y[i] - ybar) * (y[i] - ybar);
        xybar += (x[i] - xbar) * (y[i] - ybar);
    }
    double beta1 = xybar / xxbar;
    double beta0 = ybar - beta1 * xbar;

    // print results
    StdOut.println("y   = " + beta1 + " * x + " + beta0);

    // analyze results
    int df = n - 2;
    double rss = 0.0;      // residual sum of squares
    double ssr = 0.0;      // regression sum of squares
    for (int i = 0; i < n; i++) {
        double fit = beta1*x[i] + beta0;
        rss += (fit - y[i]) * (fit - y[i]);
        ssr += (fit - ybar) * (fit - ybar);
    }
    double R2    = ssr / yybar;
    double svar  = rss / df;
    double svar1 = svar / xxbar;
    double svar0 = svar/n + xbar*xbar*svar1;
    StdOut.println("R^2                 = " + R2);
    StdOut.println("std error of beta_1 = " + Math.sqrt(svar1));
    StdOut.println("std error of beta_0 = " + Math.sqrt(svar0));
    svar0 = svar * sumx2 / (n * xxbar);
    StdOut.println("std error of beta_0 = " + Math.sqrt(svar0));

    StdOut.println("SSTO = " + yybar);
    StdOut.println("SSE  = " + rss);
    StdOut.println("SSR  = " + ssr);
}
}
*/