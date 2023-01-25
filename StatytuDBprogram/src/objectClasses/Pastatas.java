package objectClasses;

import java.math.BigDecimal;
import java.sql.Date;

public class Pastatas {
	public int Id;
	public String Adresas;
	public Date PradejimoData;
	public BigDecimal StatymoKaina;
	public BigDecimal PardavimoKaina;
	public int FirmosId;
	
	// Constructors
	public Pastatas() {}
	
	public Pastatas(int id, String adresas, Date pradejimoData, BigDecimal statymoKaina, BigDecimal pardavimoKaina, int firmosId) {
		super();
		Id = id;
		Adresas = adresas;
		PradejimoData = pradejimoData;
		StatymoKaina = statymoKaina;
		PardavimoKaina = pardavimoKaina;
		FirmosId = firmosId;
	}
	
	public Pastatas(int id, String adresas, Date pradejimoData, BigDecimal statymoKaina, BigDecimal pardavimoKaina) {
		super();
		Id = id;
		Adresas = adresas;
		PradejimoData = pradejimoData;
		StatymoKaina = statymoKaina;
		PardavimoKaina = pardavimoKaina;
	}
	
	// Methods
	
	
	// Getters and Setters
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAdresas() {
		return Adresas;
	}
	public void setAdresas(String adresas) {
		Adresas = adresas;
	}
	public Date getPradejimoData() {
		return PradejimoData;
	}
	public void setPradejimoData(Date pradejimoData) {
		PradejimoData = pradejimoData;
	}
	public BigDecimal getStatymoKaina() {
		return StatymoKaina;
	}
	public void setStatymoKaina(BigDecimal statymoKaina) {
		StatymoKaina = statymoKaina;
	}
	public BigDecimal getPardavimoKaina() {
		return PardavimoKaina;
	}
	public void setPardavimoKaina(BigDecimal pardavimoKaina) {
		PardavimoKaina = pardavimoKaina;
	}
	public int getFirmosId() {
		return FirmosId;
	}
	public void setFirmosId(int firmosId) {
		FirmosId = firmosId;
	}
}
