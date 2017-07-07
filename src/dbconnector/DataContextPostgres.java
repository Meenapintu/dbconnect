package dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataContextPostgres extends DataContext {

	Connection conn = null;
	Statement stmt;

	public DataContextPostgres(Config config) {
		super(config);
		// TODO Auto-generated constructor stub
		if (config.USER != null && config.PASS != null)
			dbPath = "jdbc:postgresql://" + config.HOST + ":" + config.PORT + "/" + config.DATABASE;
		else {
			dbPath = "mongodb://" + config.HOST + ":" + config.PORT + "/" + config.DATABASE;
		}
		conf = config;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(dbPath, conf.USER, conf.PASS);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		try {
			System.out.println("Opened database successfully   " + conn.getSchema());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qe = new SqlExecuter();
	}

	@Override
	public void Test() {
		// TODO Auto-generated method stub
		//Table t = select("gfflgk");
		// qe.insertInto(t).values(new Column("FISRC","sdgdf444")).values(new
		// Column("dfss","sdg322df")).execute();;
		//qe.select("*").from(t).execute();
		// qe.update(t).values(new Column("FISRC","sdgdf444")).where(new
		// Column("FISRC","sdgdf")).and(new Column("FISRC","sdgdf")).execute();
		super.Test();
	}

	@Override
	public Table create(String table_name, List<Column> cols) {
		// TODO Auto-generated method stub
		// assuming type is always postgreSql supported format else put a
		// validation function ,
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE IF NOT EXISTS " + table_name + "(");
		for (Column c : cols) {
			sql.append(c.name + " " + c.value + ",");
		}
		sql.replace(sql.length() - 1, sql.length(), ")");

		System.out.println(sql.toString());

		try {
			stmt = this.conn.createStatement();
			stmt.execute(sql.toString());
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return super.create(table_name);
	}

	@Override
	public Table select(String table_name) {
		// TODO Auto-generated method stub

		Table t = new TablePostgres(table_name);
		t.setDbhandler(conn);

		return t;
	}

	@Override
	public void drop(String table_name) {
		// TODO Auto-generated method stub
		super.drop(table_name);
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
