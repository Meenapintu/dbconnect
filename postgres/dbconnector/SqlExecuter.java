package dbconnector;

import java.sql.ResultSet;
import java.util.Vector;

public class SqlExecuter extends QueryExecuter {

	private String select = "";
	private String tablename = "";
	private Vector<String> values = new Vector<String>();
	private String cond = "";
	private String insertInto;
	private String update = "";
	private String delete = "";

	private Vector<String> valuef = new Vector<String>();
	private Vector<String> valuev = new Vector<String>();

	private Table table;

	SqlExecuter() {
		select = "";
		tablename = "";
		values = new Vector<String>();
		cond = "";
		insertInto = "";
		update = "";
		delete = "";
		valuef = new Vector<String>();
		valuev = new Vector<String>();
	}

	@Override
	public void clean() {
		select = "";
		tablename = "";
		values = new Vector<String>();
		cond = "";
		insertInto = "";
		update = "";
		delete = "";
		valuef = new Vector<String>();
		valuev = new Vector<String>();
	}

	@Override
	public SqlExecuter select(String cols) {
		select = "select " + cols;
		return this;
	}

	@Override
	public SqlExecuter from(Table table) {
		this.tablename = table.Name;
		this.table = table;
		return this;
	}

	@Override
	public SqlExecuter insertInto(Table table) {
		this.table = table;
		insertInto = "INSERT INTO ";
		return this;
	}

	@Override
	public SqlExecuter update(Table table) {
		this.table = table;
		update = "UPDATE  ";
		return this;
	}

	@Override
	public SqlExecuter values(Column cols) {
		valuef.add(cols.name);
		valuev.add("'" + cols.value + "'");
		values.add(cols.name + " = '" + cols.value + "'");
		return this;
	}

	@Override
	public SqlExecuter where(Column conds) {
		if (cond == "")
			cond = " where ";

		cond += conds.name + "='" + conds.value + "'";
		return this;
	}

	@Override
	public SqlExecuter and(Column conds) {
		cond += "AND " + conds.name + "='" + conds.value + "'";
		return this;
	}

	@Override
	public ResultSet execute() {
		StringBuilder sb = new StringBuilder();
		if (insertInto != "") {
			sb.append(insertInto).append(this.table.Name).append(" (")
					.append((valuef.toString()).substring(1, valuef.toString().length() - 1)).append(") values (")
					.append((valuev.toString()).substring(1, valuev.toString().length() - 1)).append(")");
			insertInto = "";
		} else if (select != "") {
			sb.append(select).append(" FROM ").append(this.table.Name).append(cond);
			select = "";
			// System.out.println(sb.toString() + " SQLEXE");
			return this.table.executeQuery(sb.toString());

		}

		else if (update != "") {
			sb.append(update).append(this.table.Name).append(" SET ")
					.append((values.toString()).substring(1, values.toString().length() - 1)).append(cond);
			update = "";
		} else if (delete != "") {
			sb.append(update).append(this.table.Name).append(" SET ");
			delete = "";
		}

		// System.out.println(sb.toString() + " SQLEXE");

		this.table.execute(sb.toString());
		this.clean();
		return null;

	}

}
