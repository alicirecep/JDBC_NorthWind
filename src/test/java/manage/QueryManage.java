package manage;

public class QueryManage {

	private String InsertQuery = "INSERT INTO orders (id, employee_id, customer_id,ship_name) VALUES (?,?,?,?);";
	private String InsertDogrulama = "SELECT ship_name FROM orders WHERE id= ?;";
	private String UpdateQuery = "UPDATE orders SET ship_name = ? WHERE id = ?;";
	private String UpdateDogrulama = "SELECT ship_name FROM orders WHERE id=?;";
	private String DeleteQuery = "DELETE FROM orders WHERE id = ?;";
	private String DeleteDogrulama = "SELECT * FROM orders WHERE id = ?;";


	//****GETTER******


	public String getInsertQuery() {
		return InsertQuery;
	}

	public String getInsertDogrulama() {
		return InsertDogrulama;
	}

	public String getUpdateQuery() {
		return UpdateQuery;
	}

	public String getUpdateDogrulama() {
		return UpdateDogrulama;
	}

	public String getDeleteQuery() {
		return DeleteQuery;
	}

	public String getDeleteDogrulama() {
		return DeleteDogrulama;
	}
}
