package bercy.entity;

/**
 * goodsbean
 * 
 * @author Bercy
 *
 */
public final class Goods {
	private int gId;
	private String gName;
	private double gPrice;
	private int gNumber;

	/**
	 * add product
	 * 
	 * @param gName
	 * @param gPrice
	 * @param gNumber
	 */
	public Goods(String gName, double gPrice, int gNumber) {
		super();
		this.gName = gName;
		this.gPrice = gPrice;
		this.gNumber = gNumber;
	}

	/*
	 * show goods info
	 */
	public Goods(int gId, String gName, double gPrice, int gNumber) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gNumber = gNumber;
	}

	/**
	 * change goods name
	 */
	public Goods(int gId, String gName) {
		super();
		this.gId = gId;
		this.gName = gName;
	}
	/**
	 * change price
	 * @param gId
	 * @param gPrice
	 */
	
	public Goods(int gId, double gPrice) {
		super();
		this.gId = gId;
		this.gPrice = gPrice;
	}

	// getter setter
	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

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

	public int getgNumber() {
		return gNumber;
	}

	public void setgNumber(int gNumber) {
		this.gNumber = gNumber;
	}

}
