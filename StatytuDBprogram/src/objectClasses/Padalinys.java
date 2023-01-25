package objectClasses;

public class Padalinys {
	public int FirmosId;
	public int Nr;
	public String Atsakomybe;
	public int PastatoId;
	
	// Constructors
	public Padalinys() {}
	
	public Padalinys(int firmosId, int nr, String atsakomybe, int pastatoId) {
		super();
		FirmosId = firmosId;
		Nr = nr;
		Atsakomybe = atsakomybe;
		PastatoId = pastatoId;
	}
	
	public Padalinys(int firmosId, int nr, String atsakomybe) {
		super();
		FirmosId = firmosId;
		Nr = nr;
		Atsakomybe = atsakomybe;
	}
	
	// Methods
	
	// Getters and Setters
	public int getFirmosId() {
		return FirmosId;
	}

	public void setFirmosId(int firmosId) {
		FirmosId = firmosId;
	}

	public int getNr() {
		return Nr;
	}

	public void setNr(int nr) {
		Nr = nr;
	}

	public String getAtsakomybe() {
		return Atsakomybe;
	}

	public void setAtsakomybe(String atsakomybe) {
		Atsakomybe = atsakomybe;
	}

	public int getPastatoId() {
		return PastatoId;
	}

	public void setPastatoId(int pastatoId) {
		PastatoId = pastatoId;
	}
}
