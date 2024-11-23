package manage;

public class QueryManage {

	private String InsertQuery = "INSERT INTO orders (id, employee_id, customer_id,ship_name) VALUES (?,?,?,?);";
	private String InsertDogrulama = "SELECT ship_name FROM orders WHERE id= ?;";



	//****GETTER******


	public String getInsertQuery() {
		return InsertQuery;
	}

	public String getInsertDogrulama() {
		return InsertDogrulama;
	}
}
