package bercy.entity;

public class Gsales {

	private String gName;
	private double gPrice;
	private int gNum;

	/**
	 * show products sold today
	 */
	public Gsales(String gName, double gPrice, int gNum, int allSnum) {
		super();
		this.gName = gName;
		this.gPrice = gPrice;
		this.gNum = gNum;
		this.allSnum = allSnum;
	}

	// getter and setter
	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public double getgPrice() {
		return gPrice;
	}

	public void setgPrice(double gPrice) {
		this.gPrice = gPrice;
	}

	public int getgNum() {
		return gNum;
	}

	public void setgNum(int gNum) {
		this.gNum = gNum;
	}

	public int getAllSnum() {
		return allSnum;
	}

	public void setAllSnum(int allSnum) {
		this.allSnum = allSnum;
	}

	private int allSnum;
}
