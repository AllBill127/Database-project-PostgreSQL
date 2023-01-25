package objectClasses;

public class Savininkas {
	public String AsmensKodas;
	public int FirmosId;
	
	// Constructors
	public Savininkas()
	{}
	
	public Savininkas(String ak, int id)
	{
		super();
		this.AsmensKodas = ak;
		this.FirmosId = id;
	}
	
	// Methods
	
	
	// Getters
	public String getAsmensKodas()
	{
		return this.AsmensKodas;
	}

	public int getFirmosId()
	{
		return this.FirmosId;
	}
	
	// Setters
	public void setAsmensKodas(String ak)
	{
		this.AsmensKodas = ak;
	}
	
	public void setFirmosId(int id)
	{
		this.FirmosId = id;
	}
}
