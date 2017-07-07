package dbconnector;

import java.sql.ResultSet;

import com.mongodb.client.MongoDatabase;

public class Table<T> {

	public String Name;
	public String DbName;
	public T Db;
	String activeOP = null;

	// table operation , insertval , deleteval, update val and ,getlist val;

	Table() {
	}

	Table(String Name) {
		this.Name = Name;
	}

	Table(String Name, T db) {
		this.Name = Name;
		this.Db = db;
	}

	public void setDbhandler(T db2) {
		this.Db = db2;
	}

	public Table insert(Column col) {
		return null;
	}

	public Table update(Column col, Column condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public Table where(Column col) {
		return null;
	}

	public void execute(String sql) {

	}

	public void setDbhandler(MongoDatabase dbhandler) {
		// TODO Auto-generated method stub

	}

	public Table select(Column Col, Column where) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet executeQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
