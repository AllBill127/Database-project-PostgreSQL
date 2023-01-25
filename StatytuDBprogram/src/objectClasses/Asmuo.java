package objectClasses;

import java.sql.Date;

public class Asmuo {
	public String AsmensKodas;
	public String Vardas;
	public String Pavarde;
	public Date GimimoData;
	
	// Constructors
	public Asmuo()	{}
	
	public Asmuo(String ak, String vardas, String pavarde, Date gData)
	{
		super();
		this.AsmensKodas = ak;
		this.Vardas = vardas;
		this.Pavarde = pavarde;
		this.GimimoData = gData;
	}
	
	// Methods
	
	
	// Getters
	public String getAsmensKodas()
	{
		return this.AsmensKodas;
	}
	
	public String getVardas()
	{
		return this.Vardas;
	}
	
	public String getPavarde()
	{
		return this.Pavarde;
	}
	
	public Date getGimimoData()
	{
		return this.GimimoData;
	}
	
	// Setters
	public void setAsmensKodas(String ak)
	{
		this.AsmensKodas = ak;
	}
	
	public void setVardas(String vardas)
	{
		this.Vardas = vardas;
	}
	
	public void setPavarde(String pavarde)
	{
		this.Pavarde = pavarde;
	}
	
	public void setGimimoData(Date gData)
	{
		this.GimimoData = gData;
	}
}
