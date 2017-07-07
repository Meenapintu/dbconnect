package dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DataContextMongodb extends DataContext {

	private MongoDatabase db;
	MongoClient mc;

	public DataContextMongodb(Config config) {
		super(config);
		// TODO Auto-generated constructor stub
		if (config.USER != null && config.PASS != null)
			dbPath = "mongodb://" + config.USER + ":" + config.PASS + "@" + config.HOST + ":" + config.PORT + "/"+ config.DATABASE;
		else {
			dbPath = "mongodb://" + config.HOST + ":" + config.PORT + "/" + config.DATABASE;
		}
		conf = config;
		this.mc = new MongoClient(new MongoClientURI(dbPath));
		this.db = this.mc.getDatabase("testdb");
		qe = new DocExecuter();
	}

	@Override
	public void Test() {
		// Table t = create("testing");
		Table t = select("fjdf");
		qe.insertInto(t).values(new Column("Hhh", "2efnewefjeijeij")).execute();
		qe.update(t).values(new Column("Hhh", "2ef")).where(new Column("Hhh", "yeahigo")).execute();
		qe.select("*").from(t).execute();
	}

	@Override
	public Table create(String table_name) {
		Table table = new TableMongo(table_name, conf.DATABASE);
		db.createCollection(table.Name);
		table.setDbhandler(db);
		return table;
	}

	@Override
	public Table select(String table_name) {
		Table table = new TableMongo(table_name, conf.DATABASE);
		table.setDbhandler(mc);
		return table;
	}

	@Override
	public void drop(String table_name) {
		select(table_name);
	}

}
