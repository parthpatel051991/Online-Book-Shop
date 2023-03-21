package ai.ineuron.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtill {

	private JdbcUtill() {

	}

//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//
//			e.printStackTrace();
//		}
//	}

	public static Connection getJdbcConnection() throws SQLException, IOException {
		
		String fileLocation = "C:\\Users\\cadet\\internship\\OnlineBookShop\\src\\main\\java\\ai\\ineuron\\config\\db.properties";
		HikariConfig config = new HikariConfig(fileLocation);

		HikariDataSource dataSource = new HikariDataSource(config);
		Connection connection = dataSource.getConnection();
		return connection;

	}

	@SuppressWarnings("unused")
	public static Connection physicalConnection() throws FileNotFoundException, SQLException, IOException {
		String fileLocation = "C:\\Users\\cadet\\internship\\OnlineBookShop\\src\\main\\java\\ai\\ineuron\\config\\db.properties";
		FileInputStream fis = new FileInputStream(fileLocation);
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");

		Connection connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

}