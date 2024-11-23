package stepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

import static org.testng.Assert.assertEquals;

public class Select {

	Connection connection;
	Statement statement;
	ResultSet resultSet;


	@Given("Database baglantisi kurulur.")
	public void database_baglantisi_kurulur() throws SQLException {

		String URL = "jdbc:mysql://localhost:3306/northwind";
		String USERNAME = "northwind_user";
		String PASSWORD = "password123";

		connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);


	}
	@Given("SELECTQUERY hazirla ve calistir.")
	public void selectquery_hazirla_ve_calistir() throws SQLException {

		String Query = "SELECT * FROM orders WHERE id = 30;";

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		resultSet = statement.executeQuery(Query);


	}
	@Given("SELECTQUERY sonuclarini isle.")
	public void selectquery_sonuclarini_isle() throws SQLException {

		resultSet.next();
		System.out.println("Employee ID = " + resultSet.getInt(2));
		System.out.println("Customer ID = " + resultSet.getInt(3));
		assertEquals(9, resultSet.getInt(2));

	}
	@Given("Database baglantisi kapatilir.")
	public void database_baglantisi_kapatilir() throws SQLException {
/*
		  A->->-> B ->->-> C->
		<-A<-<-<- B <-<-<- C
*/
		resultSet.close();
		statement.close();
		connection.close();


	}

}
