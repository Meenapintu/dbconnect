package dbconnector;

import java.sql.ResultSet;

public class DocExecuter extends QueryExecuter {

	private String select = "";
	private String cond = "";
	private String insertInto;
	private String update = "";
	private String delete = "";

	private Table table;

	DocExecuter() {
		select = "";
		cond = "";
		insertInto = "";
		update = "";
		delete = "";

	}

	private Column insertcol, selectcol, wherecol;

	/*
	 * (non-Javadoc)
	 * 
	 * @see dbconnector.QueryExecuter#clean()
	 */
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		super.clean();
		select = "";
		cond = "";
		insertInto = "";
		update = "";
		delete = "";

	}

	@Override
	public DocExecuter select(String cols) {
		select = "select " + cols;
		return this;
	}

	@Override
	public DocExecuter from(Table table) {
		this.table = table;
		return this;
	}

	@Override
	public DocExecuter insertInto(Table table) {
		this.table = table;
		insertInto = "INSERT INTO ";
		return this;
	}

	@Override
	public DocExecuter update(Table table) {
		this.table = table;
		update = "UPDATE  ";
		return this;
	}

	@Override
	public DocExecuter values(Column cols) {
		insertcol = cols;
		return this;
	}

	@Override
	public DocExecuter where(Column conds) {
		wherecol = conds;
		return this;
	}

	@Override
	public DocExecuter and(Column conds) {
		cond += "AND " + conds.name + "='" + conds.value + "'";
		return this;
	}

	@Override
	public ResultSet execute() {

		if (insertInto != "") {
			insertInto = "";
			table.insert(insertcol);
		} else if (select != "") {
			select = "";

			table.select(new Column("fgg", "dfd"), new Column("ffffg", "dgddg"));
		}
		else if (update != "") {
			update = "";
			table.update(insertcol, wherecol);
		} else if (delete != "") {
			delete = "";
		}
		this.clean();
		return null;

	}

}
