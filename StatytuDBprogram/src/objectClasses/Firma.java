package objectClasses;

import java.math.BigDecimal;
import java.sql.Date;

public class Firma {
	public int Id;
	public String Pavadinimas;
	public Date SukurimoData;
	public BigDecimal Verte;
	public BigDecimal Kapitalas;
	
	// Constructors
	public Firma()
	{
		
	}
	
	public Firma(int id, String pavadinimas, Date sData, BigDecimal verte, BigDecimal kapitalas)
	{
		super();
		this.Id = id;
		this.Pavadinimas = pavadinimas;
		this.SukurimoData = sData;
		this.Verte = verte;
		this.Kapitalas = kapitalas;
	}
	
	public Firma(String pavadinimas, Date sData, BigDecimal verte, BigDecimal kapitalas)
	{
		super();
		this.Pavadinimas = pavadinimas;
		this.SukurimoData = sData;
		this.Verte = verte;
		this.Kapitalas = kapitalas;
	}
	
	// Methods
	
	
	// Getters
	public int getId()
	{
		return this.Id;
	}
	
	public String getPavadinimas()
	{
		return this.Pavadinimas;
	}
	
	public Date getSukurimoData()
	{
		return this.SukurimoData;
	}
	
	public BigDecimal getVerte()
	{
		return this.Verte;
	}
	
	public BigDecimal getKapitalas()
	{
		return this.Kapitalas;
	}
	
	// Setters
	public void setId(int id)
	{
		this.Id = id;
	}
	
	public void setPavadinimas(String pavadinimas)
	{
		this.Pavadinimas = pavadinimas;
	}
	
	public void setSukurimoData(Date sData)
	{
		this.SukurimoData = sData;
	}
	
	public void setVerte(BigDecimal verte)
	{
		this.Verte = verte;
	}
	
	public void setKapitalas(BigDecimal kapitalas)
	{
		this.Kapitalas = kapitalas;
	}
}
