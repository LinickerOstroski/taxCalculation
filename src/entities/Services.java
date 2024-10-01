package entities;

public class Services {
	
	private double coust;
	private double taxe;
	private double profitMargin;
	
	public Services(double coust, double profitMargin ) {
		this.coust = coust;
		this.profitMargin = profitMargin;
	}
	
	public double getFinalAmount() {
		return this.coust + this.taxe + this.profitMargin;
	}

	public double getCoust() {
		return coust;
	}

	public double getTaxe() {
		return taxe;
	}

	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}

	public double getProfitMargin() {
		return profitMargin;
	}
}
