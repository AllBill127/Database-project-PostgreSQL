package objectClasses;

import java.math.BigDecimal;
import java.sql.Date;

public class Darbuotojas {
	public int Id;
	public Date IdarbinimoData;
	public String AsmensKodas;
	public BigDecimal Atlyginimas;
	public int FirmosId;
	public int PadalinioNr;
	
	// Constructors
	public Darbuotojas(int id, Date idarbinimoData, String asmensKodas, BigDecimal atlyginimas, int firmosId, int padalinioNr) {
		super();
		Id = id;
		IdarbinimoData = idarbinimoData;
		AsmensKodas = asmensKodas;
		Atlyginimas = atlyginimas;
		FirmosId = firmosId;
		PadalinioNr = padalinioNr;
	}

	// Methods
	
	
	// Getters and Setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getIdarbinimoData() {
		return IdarbinimoData;
	}

	public void setIdarbinimoData(Date idarbinimoData) {
		IdarbinimoData = idarbinimoData;
	}

	public String getAsmensKodas() {
		return AsmensKodas;
	}

	public void setAsmensKodas(String asmensKodas) {
		AsmensKodas = asmensKodas;
	}

	public BigDecimal getAtlyginimas() {
		return Atlyginimas;
	}

	public void setAtlyginimas(BigDecimal atlyginimas) {
		Atlyginimas = atlyginimas;
	}

	public int getFirmosId() {
		return FirmosId;
	}

	public void setFirmosId(int firmosId) {
		FirmosId = firmosId;
	}

	public int getPadalinioNr() {
		return PadalinioNr;
	}

	public void setPadalinioNr(int padalinioNr) {
		PadalinioNr = padalinioNr;
	}
}
