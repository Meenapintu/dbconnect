package dbconnector;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

public class TableMongo<T> extends Table<T> {
	private MongoClient mc;

	TableMongo(String Name, String Database_name) {
		this.Name = Name;
		this.DbName = Database_name;
	}
	@Override
	public void setDbhandler(T dbhandler) {
		// TODO Auto-generated method stub
		super.setDbhandler(dbhandler);
		this.mc = (MongoClient) dbhandler;
	}
	@Override
	public Table insert(Column col) {
		// TODO Auto-generated method stub
		Document b = new Document();
		b.append(col.name, col.value);
		this.mc.getDatabase(this.DbName).getCollection(this.Name).insertOne(b);
		return super.insert(col);
	}

	@Override
	public Table update(Column col, Column condition) {
		// TODO Auto-generated method stub
		Document b = new Document();
		b.append(col.name, col.value);
		Document c = new Document();
		c.append(condition.name, condition.value);
		this.mc.getDatabase(this.DbName).getCollection(this.Name).findOneAndUpdate(b, new Document("$set", c));
		return super.update(col, condition);
	}

	@Override
	public Table select(Column Col, Column where) {
		// TODO Auto-generated method stub
		Document b = new Document();
		b.append(where.name, where.value);
		FindIterable<Document> c = this.mc.getDatabase(this.DbName).getCollection(this.Name).find();
		MongoCursor<Document> mdbc = c.iterator();
		while (mdbc.hasNext()) {
			System.out.println(mdbc.next().toJson());
		}
		return super.select(Col, where);
	}

	@Override
	public Table where(Column col) {
		// TODO Auto-generated method stub
		return super.where(col);
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
