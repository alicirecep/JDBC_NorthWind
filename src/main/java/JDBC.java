import org.testng.Assert;

import java.sql.*;

import static org.testng.Assert.*;

public class JDBC {


	/*
			Eger JDBC testi yapmaniz istenirse ONCELIK olarak DATABASE YONETICISI ile
			ILETISIME gecerek ilgili database ait ACCESS INFORMATION'lari almalisiniz.


		Host : localhost
        Port: 3306 (MySQL'in varsayılan portu)
        Database Name: northwind
        Username: northwind_user
        Password: password123

        URL = jdbc:mysql://localhost:3306/northwind
        USERNAME = northwind_user
        PASSWORD = password123


	 */


	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. ADIM : JDBC SURUCUSUNU YUKLE.

		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. ADIM : VERITABANI ILE BAGLANTI (Connection) OLUSTUR.

		String URL = "jdbc:mysql://localhost:3306/northwind";
		String USERNAME = "northwind_user";
		String PASSWORD = "password123";


		Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);


		// 3. ADIM : SQL SORGUSU OLUSTUR

		String QUERY = "SELECT * FROM orders";


		// 4. ADIM : SQL SORGULARINI CALISTIR


		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(QUERY);


		// 5. ADIM : SONUCLARI ISLE


		// Database den aldigimiz sonuclar suan da resultSet icerisinde.
		// Eger bu sonuclar ile islem yapmak istiyorsam resultSet icerisine girmem gerekiyor.
		// resultSet'in icerisine ITERATOR ile girilebilir.


		resultSet.next();
		System.out.println(resultSet.getString("ship_name"));
 		// Karen Toh

		String expectedName= "Karen Toh";
		String actualName = resultSet.getString(7);
		assertEquals(expectedName, actualName);

		resultSet.next();
		System.out.println(resultSet.getString("ship_city"));
		//New York

		System.out.println(resultSet.getInt(3));
		// 4

		resultSet.absolute(11);
		System.out.println(resultSet.getString("ship_name"));
		//Roland Wacker


	}






}
