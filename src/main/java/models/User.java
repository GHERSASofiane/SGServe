package models;

public class User {

	public User() {
		this.CMD = "";
	}

	private String CMD = "";
	private String NOMUS, PREUS, ADRUS, TEL1US, TEL2US, MAILUS, MDPUS;
	private int STATUS, IDUS, ROLUS;

	public String getCMD() {
		return CMD;
	}

	public void setCMD(String cMD) {
		CMD = cMD;
	}

	public String getNOMUS() {
		return NOMUS;
	}

	public void setNOMUS(String nOMUS) {
		NOMUS = nOMUS;
	}

	public String getPREUS() {
		return PREUS;
	}

	public void setPREUS(String pREUS) {
		PREUS = pREUS;
	}

	public String getADRUS() {
		return ADRUS;
	}

	public void setADRUS(String aDRUS) {
		ADRUS = aDRUS;
	}

	public String getTEL1US() {
		return TEL1US;
	}

	public void setTEL1US(String tEL1US) {
		TEL1US = tEL1US;
	}

	public String getTEL2US() {
		return TEL2US;
	}

	public void setTEL2US(String tEL2US) {
		TEL2US = tEL2US;
	}

	public String getMAILUS() {
		return MAILUS;
	}

	public void setMAILUS(String mAILUS) {
		MAILUS = mAILUS;
	}

	public String getMDPUS() {
		return MDPUS;
	}

	public void setMDPUS(String mDPUS) {
		MDPUS = mDPUS;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public int getIDUS() {
		return IDUS;
	}

	public void setIDUS(int iDUS) {
		IDUS = iDUS;
	}

	public int getROLUS() {
		return ROLUS;
	}

	public void setROLUS(int rOLUS) {
		ROLUS = rOLUS;
	}

}
