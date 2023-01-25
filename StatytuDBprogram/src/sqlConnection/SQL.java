package sqlConnection;

import java.math.BigDecimal;
import java.sql.*;

public class SQL 
{
	static String DB_URL;
	static String USER;
	static String PASS;
	
	public SQL(String url, String user, String password)
	{
		DB_URL = url;
		USER = user;
		PASS = password;
	}
	
	// Select by primary key
	public void asmensInfo(String ak)
	{
		String sqlQuerry = "SELECT * FROM asmuo WHERE asmens_kodas = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setString(1, ak);
			
			ResultSet result = p.executeQuery();
			while(result.next())
			{
				System.out.println("Asmens_kodas: " + result.getString("asmens_kodas"));
				System.out.println("Vardas: " + result.getString("vardas"));
				System.out.println("Pavarde: " + result.getString("pavarde"));
				System.out.println("Gimimo_data: " + result.getDate("gimimo_data"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void darbuotojoInfo(int id)
	{
		String sqlQuerry = "SELECT * FROM darbuotojas WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, id);
			
			ResultSet result = p.executeQuery();
			while(result.next())
			{
				System.out.println("Darbuotojo id: " + result.getInt("id"));
				System.out.println("Idarbinimo_data: " + result.getDate("idarbinimo_data"));
				System.out.println("Asmens_kodas: " + result.getString("asmens_kodas"));
				System.out.println("Atlyginimas: " + result.getBigDecimal("atlyginimas"));
				System.out.println("Firmos id: " + result.getInt("firmos_id"));
				System.out.println("Padalinio_nr: " + result.getInt("padalinio_nr"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void pastatoInfo(int id)
	{
		String sqlQuerry = "SELECT * FROM pastatas WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, id);
			
			ResultSet result = p.executeQuery();
			while(result.next())
			{
				System.out.println("Pastato id: " + result.getInt("id"));
				System.out.println("Adresas: " + result.getString("adresas"));
				System.out.println("Pradejimo_data: " + result.getDate("pradejimo_data"));
				System.out.println("Statybu_kaina: " + result.getBigDecimal("statybu_kaina"));
				System.out.println("Pardavimo_kaina: " + result.getBigDecimal("pardavimo_kaina"));
				System.out.println("Firmos id: " + result.getInt("firmos_id"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void firmosInfo(int id)
	{
		String sqlQuerry = "SELECT * FROM firma WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, id);
			
			ResultSet result = p.executeQuery();
			while(result.next())
			{
				System.out.println("firmos id: " + result.getInt("id"));
				System.out.println("Pavadinimas: " + result.getString("pavadinimas"));
				System.out.println("Sukurimo_data: " + result.getDate("sukurimo_data"));
				System.out.println("Verte: " + result.getBigDecimal("verte"));
				System.out.println("Kapitalas: " + result.getBigDecimal("kapitalas"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	// Select all primary keys from table
	public void visiDarbuotojai()
	{
		String sqlQuerry = "SELECT id, asmuo.asmens_kodas, vardas, pavarde FROM darbuotojas"
				+ " INNER JOIN asmuo ON darbuotojas.asmens_kodas = asmuo.asmens_kodas;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			
			ResultSet result = p.executeQuery();
			
			System.out.println("Galimi darbuotojo id:");
			while(result.next())
			{
				System.out.println("	" + result.getInt("id") + "	" + result.getString("asmens_kodas") +
						"	" + result.getString("vardas") + " " + result.getString("pavarde"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void visosFirmos()
	{
		String sqlQuerry = "SELECT id FROM firma;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			
			ResultSet result = p.executeQuery();
			
			System.out.println("Galimi firmos id:");
			while(result.next())
			{
				System.out.println("	" + result.getInt("id"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void visiPastatai()
	{
		String sqlQuerry = "SELECT id FROM pastatas;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			
			ResultSet result = p.executeQuery();
			
			System.out.println("Galimi pastato id:");
			while(result.next())
			{
				System.out.println("	" + result.getInt("id"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void visiPadaliniai()
	{
		String sqlQuerry = "SELECT firmos_id, nr FROM padalinys ORDER BY firmos_id, nr;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			
			ResultSet result = p.executeQuery();
			
			System.out.println("Galimi padaliniai (firmos_id, padalinio_nr):");
			while(result.next())
			{
				System.out.println("	" + result.getInt("firmos_id") + "	" + result.getInt("nr"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void visiAsmenys()
	{
		String sqlQuerry = "SELECT asmens_kodas FROM asmuo;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			
			ResultSet result = p.executeQuery();
			
			System.out.println("Galimi asmens kodai:");
			while(result.next())
			{
				System.out.println("	" + result.getString("asmens_kodas"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	// Insert into table
	public void idarbintiAsmeni(String ak, BigDecimal atlyginimas, int firmos_id, int padalinio_nr )
	{
		String sqlQuerry = "INSERT INTO darbuotojas (asmens_kodas,atlyginimas,firmos_id,padalinio_nr)"
				+ "VALUES (?, ?, ?, ?);";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry, Statement.RETURN_GENERATED_KEYS);
			p.setString(1, ak);
			p.setBigDecimal(2, atlyginimas);
			p.setInt(3, firmos_id);
			p.setInt(4, padalinio_nr);
			p.execute();
			
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
			{
				System.out.println("Idarbinto darbuotojo id: " + result.getInt("id"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void sukurtiFirma(int id, String pavadinimas, Date sData, BigDecimal verte, BigDecimal kapitalas)
	{
		String sqlQuerry = "INSERT INTO firma (id,pavadinimas,sukurimo_data,verte,kapitalas)"
				+ "VALUES (?, ?, ?, ?, ?);";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry, Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, id);
			p.setString(2, pavadinimas);
			p.setDate(3, sData);
			p.setBigDecimal(4, verte);
			p.setBigDecimal(5, kapitalas);
			p.execute();
			
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
			{
				System.out.println("Sukurtos firmos id: " + result.getInt("id"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void pridetiPadalini(int firmos_id, String atsakomybe)
	{
		String sqlQuerry = "INSERT INTO padalinys (firmos_id, atsakomybe)"
				+ "VALUES (?, ?);";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry, Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, firmos_id);
			p.setString(2, atsakomybe);
			p.execute();
			
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
			{
				System.out.println("Sukurto padalinio nr: " + result.getInt("nr"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void pradetiStatytiPastata(String adresas, Date pData, BigDecimal statybu_kaina, BigDecimal pardavimo_kaina, int firmos_id)
	{
		String sqlQuerry = "INSERT INTO pastatas (adresas,pradejimo_data,statybu_kaina,pardavimo_kaina,firmos_id)"
				+ "VALUES (?, ?, ?, ?, ?);";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry, Statement.RETURN_GENERATED_KEYS);
			p.setString(1, adresas);
			p.setDate(2, pData);
			p.setBigDecimal(3, statybu_kaina);
			p.setBigDecimal(4, pardavimo_kaina);
			p.setInt(5, firmos_id);
			p.execute();
			
			ResultSet result = p.getGeneratedKeys();
			while(result.next())
			{
				System.out.println("Pradeto pastato id: " + result.getInt("id"));
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	// Update darbuotojas.atlyginimas
	public void pakeistiAtlyginima(int id, BigDecimal atlyginimas)
	{
		String sqlQuerry = "UPDATE darbuotojas SET atlyginimas = ? WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(2, id);
			p.setBigDecimal(1, atlyginimas);
			
			int resultCount = p.executeUpdate();
			
			if(resultCount >= 1)
				System.out.println(id + " darbuotojo atlyginimas pakeistas");
			else
				System.out.println(id + " darbuotojo atlyginimas nepakeistas");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	// Update pastatas.pardavimo_kaina
	public void nustatytiPardavimoKaina(int id, BigDecimal kaina)
	{
		String sqlQuerry = "UPDATE pastats SET pardavimo_kaina = ? WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, id);
			p.setBigDecimal(2, kaina);
			
			int resultCount = p.executeUpdate();
			
			if(resultCount >= 1)
				System.out.println(id + " pastato pardavimo kaina pakeistas");
			else
				System.out.println(id + " pastato pardavimo kaina nepakeistas");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	// Update padalinys.pastato_id
	public void priskirtiPastataPadaliniui(int firmos_id, int nr, int pastato_id)
	{
		String sqlQuerry = "UPDATE padalinys SET pastato_id = ? WHERE firmos_id = ? AND nr = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, pastato_id);
			p.setInt(2, firmos_id);
			p.setInt(3, nr);
			
			int resultCount = p.executeUpdate();
			
			if(resultCount >= 1)
				System.out.println(pastato_id + " pastatas priskirtas " + firmos_id 
						+ " firmos " + nr + " padaliniui");
			else
				System.out.println(pastato_id + " pastatas nepriskirtas " + firmos_id 
						+ " firmos " + nr + " padaliniui");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	// Delete by id
	public void atleistiDarbuotoja(int id)
	{
		String sqlQuerry = "DELETE FROM darbuotojas WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, id);
			
			int resultCount = p.executeUpdate();
			
			if(resultCount >= 1)
				System.out.println(id + " darbuotojas atleistas");
			else
				System.out.println(id + " darbuotojas neatleistas");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void pasalintiPastataIsSarasu(int id)
	{
		String sqlQuerry = "DELETE FROM pastatas WHERE id = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setInt(1, id);
			
			int resultCount = p.executeUpdate();
			
			if(resultCount >= 1)
				System.out.println(id + " pastatas pasalintas");
			else
				System.out.println(id + " pastatas nepasalintas");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	//======================= Logic functions ====================
	public void pakeltiAtlyginima(String ak)
	{
		BigDecimal pakelimoProc = new BigDecimal("1.069");
		
		BigDecimal atlyginimas;
		int darbuotojo_id;
		String sqlQuerry = "SELECT * FROM darbuotojas WHERE asmens_kodas = ?;";
		
		try
		{
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement p = conn.prepareStatement(sqlQuerry);
			p.setString(1, ak);
			
			ResultSet result = p.executeQuery();
			result.next();
			darbuotojo_id = result.getInt("id");
			atlyginimas = result.getBigDecimal("atlyginimas");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return;
		}
		
		atlyginimas = atlyginimas.multiply(pakelimoProc);		
		pakeistiAtlyginima(darbuotojo_id, atlyginimas);
	}
	
	public void parduotiPastata(int pastato_id)
	{
		BigDecimal statybuKaina;
		BigDecimal pardavimoKaina;
		int firmos_id;
		BigDecimal kapitalas;
		String sqlSelect1 = "SELECT statybu_kaina, pardavimo_kaina, firmos_id FROM pastatas WHERE id = ?;";
		String sqlSelect2 = "SELECT kapitalas FROM firma WHERE id = ?;";
		String sqlUpdate3 = "UPDATE firma SET kapitalas = ? WHERE id = ?;";
		String sqlDelete4 = "DELETE FROM pastatas WHERE id = ?;";
		
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement p1 = conn.prepareStatement(sqlSelect1);
				PreparedStatement p2 = conn.prepareStatement(sqlSelect2);
				PreparedStatement p3 = conn.prepareStatement(sqlUpdate3);
				PreparedStatement p4 = conn.prepareStatement(sqlDelete4);)
		{
			conn.setAutoCommit(false);
			
			try
			{
				// Select 1
				p1.setInt(1, pastato_id);
				
				ResultSet result = p1.executeQuery();
				result.next();
				statybuKaina = result.getBigDecimal("statybu_kaina");
				pardavimoKaina = result.getBigDecimal("pardavimo_kaina");
				firmos_id = result.getInt("firmos_id");
				
				// Select 2
				p2.setInt(1, firmos_id);
				
				result = p2.executeQuery();
				result.next();
				kapitalas = result.getBigDecimal("kapitalas");
				
				// Update logic
				if (pardavimoKaina == null)
				{
					System.out.println(pastato_id + " pastato pardavimo kaina nepateikta");
					System.out.println(firmos_id + " firmos kapitalas nepakeistas, pastatas nebaigtas");
					conn.setAutoCommit(true);
					return;
				}
				kapitalas = kapitalas.add(pardavimoKaina.subtract(statybuKaina));
				
				// Update 3
				p3.setBigDecimal(1, kapitalas);
				p3.setInt(2, firmos_id);
				
				int updateResultCount = p3.executeUpdate();
				// Check if update successful
				if(updateResultCount >= 1)
				{
					System.out.println(firmos_id + " firmos kapitalas pakeistas");
					p4.setInt(1, pastato_id);
					
					int delResultCount = p4.executeUpdate();
					// Check if delete successful
					if(delResultCount >= 1)
						System.out.println(pastato_id + " pastatas baigtas ir pasalintas is saraso");
					else
					{
						System.out.println(firmos_id + " firmos kapitalas nepakeistas");
						conn.rollback();
						conn.setAutoCommit(true);
						return;
					}
				}
				else
				{
					System.out.println(firmos_id + " firmos kapitalas nepakeistas");
					conn.rollback();
					conn.setAutoCommit(true);
					return;
				}
				
				conn.commit();
				conn.setAutoCommit(true);
			}
			catch (SQLException ex)
			{
				conn.rollback();
				conn.setAutoCommit(true);
				System.out.println("Transaction rollback ");
				ex.printStackTrace();
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return;
		}
	}
}
