package dbconnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mongodb.client.MongoDatabase;

public class TablePostgres<T> extends Table<T> {

	Connection conn;
	Statement stmt;

	public TablePostgres(String table_name) {
		// TODO Auto-generated constructor stub
		this.Name = table_name;
	}

	@Override
	public void setDbhandler(T db2) {
		// TODO Auto-generated method stub
		conn = (Connection) db2;

		super.setDbhandler(db2);
	}

	@Override
	public Table insert(Column col) {
		// TODO Auto-generated method stub
		return super.insert(col);
	}

	@Override
	public ResultSet executeQuery(String sql) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.execute(sql);
		return null;
	}

	@Override
	public void execute(String sql) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			stmt.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.execute(sql);
	}

	@Override
	public Table select(Column Col, Column where) {
		// TODO Auto-generated method stub
		return super.select(Col, where);
	}

	@Override
	public Table where(Column col) {
		// TODO Auto-generated method stub
		return super.where(col);
	}

	@Override
	public void setDbhandler(MongoDatabase dbhandler) {
		// TODO Auto-generated method stub
		super.setDbhandler(dbhandler);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
