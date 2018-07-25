import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseFunctions {
	public DatabaseFunctions functions = null;
	Connection connection = null;

	public DatabaseFunctions DatabaseFunctions(String dbUrl, String user, String password) {
		if (functions == null) {
			functions = new DatabaseFunctions();
			getConnection(dbUrl, user, password);
			return functions;
		}
		return functions;

	}

	private void getConnection(String dbUrl, String user, String password) {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbUrl, user, password);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	public void addUser(int id, String userName, String password, String email, String address) {
		PreparedStatement statement = null;

		try {
			String sql = "insert into user(id, userName, password, email, address) values(?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, userName);
			statement.setString(3, hashPassword(password));
			statement.setString(4, email);
			statement.setString(5, address);

			statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editUser(int id, String userName, String password, String email, String address) {

	}

	public boolean beServiceProvider(int id, String code) { 
		//TODO true döndüyse ekrana başarılı mesajı yazılır.
		//TODO provider oldugunu gösteren ibare eklenir.		
		
		PreparedStatement statement = null;
		try {
			String sql = "";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (checkProviderCode(code)) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean isAServiceProvider(int id) {
		//TODO is a service provide field ı eklenecek dbye 	
		return true;
	}

	private boolean checkProviderCode(String code) {
		return true;
	}

	public boolean checkLogin(String userName, String password) {

		// usernamein passwordunu çek
		// passwordu hashle
		// gelenleri karşılaştır.
		PreparedStatement statement = null;
		String hash = hashPassword(password);
		String passHash = null;
		

		try {
			String sql = "";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet rs = statement.executeQuery();
			passHash = rs.getString("password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (hash.toString().equals(passHash)) {
			return true;
		} else {
			return false;
		}
	}

	public String[] searchService(String[] words) {
		//TODO sadece filtreleme şeklinde mi araba olacak yoksa arama olacak mı ?

		return null;
	}

	public void addService() {
		//TODO add service penceresi hazırlanacak
	}
	
	

	public String hashPassword(String password) {
		byte[] hash = null;

		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

		return hash.toString();
	}

}
