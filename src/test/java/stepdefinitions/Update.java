package stepdefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;

import org.testng.Assert;
import utilities.JDBCReusableMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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
		//	int actualResult = intResult;

		assertEquals(expectedResult, intResult);

		// 2. test
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(queryManage.getInsertDogrulama());
		// SELECT ship_name FROM orders WHERE id= ?;

		preparedStatement.setInt(1, insertID);
		resultSet = preparedStatement.executeQuery();

		String expectedName = "Bilge Adam 2";

		resultSet.next();
		String actualName = resultSet.getString(1);

		assertEquals(expectedName, actualName);

		System.out.println(actualName);


	}

	@Given("Database baglantisi sonlandirilir.")
	public void database_baglantisi_sonlandirilir() {

		JDBCReusableMethods.closeConnection();

	}



	// **********UPDATE**********

	@Given("Update sorgusu hazirlanir ve calistirilir")
	public void update_sorgusu_hazirlanir_ve_calistirilir() throws SQLException {
		QUERY = queryManage.getUpdateQuery();

		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);
		//UPDATE orders SET ship_name = ? WHERE id = ?;
		preparedStatement.setString(1, "Adam Bilge");
		preparedStatement.setInt(2, insertID);

		intResult = preparedStatement.executeUpdate();


	}
	@Given("Update sonucu dogrulanir.")
	public void update_sonucu_dogrulanir() throws SQLException {

		Assert.assertEquals(1,intResult);

		QUERY = queryManage.getUpdateDogrulama();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);

		// SELECT ship_name FROM orders WHERE id=?;

		preparedStatement.setInt(1, insertID);
		resultSet = preparedStatement.executeQuery();


		resultSet.next();
		String expName = "Adam Bilge";

		Assert.assertEquals(expName, resultSet.getString(1));

	}


	//************DELETE*************

	@Given("Delete sorgusu hazirlanir ve calistirilir")
	public void delete_sorgusu_hazirlanir_ve_calistirilir() throws SQLException {

		QUERY = queryManage.getDeleteQuery();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);
		// DELETE FROM orders WHERE id = ?;

		preparedStatement.setInt(1, insertID);

		intResult = preparedStatement.executeUpdate();


	}
	@Given("Delete sonucu dogrulanir.")
	public void delete_sonucu_dogrulanir() throws SQLException {

		assertEquals(1 , intResult);
		//********************************

		QUERY = queryManage.getDeleteDogrulama();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);
		//SELECT * FROM orders WHERE id = ?;

		preparedStatement.setInt(1, insertID);

		resultSet = preparedStatement.executeQuery();

		boolean result = false;
		while(resultSet.next()){
				result = true;
		}

		assertFalse(result);

	}



}

