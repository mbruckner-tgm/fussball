package betting.main.data;

public class SpielerStatistikDTO {

	private String userName;
	private int anzahlGespielteWetten;
	private int anzahlErhaltenePunkte;

	public SpielerStatistikDTO(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAnzahlGespielteWetten() {
		return anzahlGespielteWetten;
	}

	public void setAnzahlGespielteWetten(int anzahlGespielteWetten) {
		this.anzahlGespielteWetten = anzahlGespielteWetten;
	}

	public int getAnzahlErhaltenePunkte() {
		return anzahlErhaltenePunkte;
	}

	public void setAnzahlErhaltenePunkte(int anzahlErhaltenePunkte) {
		this.anzahlErhaltenePunkte = anzahlErhaltenePunkte;
	}

	@Override
	public String toString() {
		return "SpielerStatistikenDTO [userName=" + userName + ", anzahlGespielteWetten=" + anzahlGespielteWetten
				+ ", anzahlErhaltenePunkte=" + anzahlErhaltenePunkte + "]";
	}

}
