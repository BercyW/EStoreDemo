package bercy.entity;

public final class SalesMan {

	private int sId;
	private String sName;
	private String sPassword;


	
	/**
	 * check user
	 * @param sId
	 * @param sPassword
	 */
	public SalesMan(int sId, String sPassword) {
		super();
		this.sId = sId;
		this.sPassword = sPassword;
	}

	/**
	 * Query,update user
	 * @param sId
	 * @param sName
	 * @param sPassword
	 */
	public SalesMan(int sId, String sName, String sPassword) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPassword = sPassword;
	}
	/**
	 * insert user
	 * @return
	 */
	public SalesMan(String sName, String sPassword) {
		super();
		this.sName = sName;
		this.sPassword = sPassword;
	}

	//getter setter
	public int getsId() {
		return sId;
	}

	
	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

}
