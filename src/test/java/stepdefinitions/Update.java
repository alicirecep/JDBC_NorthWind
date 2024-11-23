package stepdefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.testng.Assert;
import utilities.JDBCReusableMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

public class Update {

	String QUERY;
	int intResult;
	int insertID = 88;
	ResultSet resultSet;


	PreparedStatement preparedStatement;

	QueryManage queryManage = new QueryManage();
	//********INSERT********

	@Given("Database baglantisi olusturulur.")
	public void database_baglantisi_olusturulur() {

		JDBCReusableMethods.createConnection();

	}
	@Given("Insert sorgusu hazirlanir ve calistirilir.")
	public void ınsert_sorgusu_hazirlanir_ve_calistirilir() throws SQLException {

	//	INSERT INTO orders (id, employee_id, customer_id,ship_name) VALUES (?,?,?,?);
	//INSERT INTO orders (id, employee_id, customer_id,ship_name) VALUES (83,3,1,'bilge Adam 2');
	QUERY = queryManage.getInsertQuery();
	preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);

	preparedStatement.setInt(1, insertID);
	preparedStatement.setInt(2,3);
	preparedStatement.setInt(3,1);
	preparedStatement.setString(4,"Bilge Adam 2");


	intResult = preparedStatement.executeUpdate();


	}
	@Given("Insert sorgu sonuclari dogrulanir.")
	public void ınsert_sorgu_sonuclari_dogrulanir() throws SQLException {

		// 1. test
		int expectedResult = 1;
		int actualResult = intResult;

		assertEquals(expectedResult, actualResult);

		// 2. test
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(queryManage.getInsertDogrulama());
		// SELECT ship_name FROM orders WHERE id= ?;

		preparedStatement.setInt(1, insertID);
		resultSet = preparedStatement.executeQuery();

		String expectedName = "Bilge Adam 2";

		resultSet.next();
		String actualName = resultSet.getString(1);

		assertEquals(expectedName,actualName);

		System.out.println(actualName);


		// 3 test
		boolean result = true;
		while(resultSet.next()){
			result = false;
		}

		Assert.assertTrue(result);

	}

	@Given("Database baglantisi sonlandirilir.")
	public void database_baglantisi_sonlandirilir() {

		JDBCReusableMethods.closeConnection();

	}

}
