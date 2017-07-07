package dbconnector;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;

public class dbconnector {

	private static Block<? super Document> action;

	public static void main(String argv[]) {

		Config conf = new Config("testdb", "localhost", "27017");
		DataContext dc = new DataContextMongodb(conf);
		// dc.Test();
		Table t = dc.select("fjdf");
		dc.qe.insertInto(t).values(new Column("Hhh", "2efnewefjeijeij")).execute();
		dc.qe.update(t).values(new Column("Hhh", "2ef")).where(new Column("Hhh", "yeahigo")).execute();
		dc.qe.select("*").from(t).execute();

		// ==============RDBMS=====================================
		Config pconf = new Config("postgres", "localhost", "5432", "postgres", "123456", null);
		DataContext pdc = new DataContextPostgres(pconf);
		List<Column> l = new ArrayList<Column>();
		l.add(new Column("FISRC", "varchar"));
		l.add(new Column("gin", "varchar"));

		pdc.create("g1", l);
		// pdc.Test();
		Table t2 = pdc.select("g1");
		pdc.qe.insertInto(t2).values(new Column("FISRC", "sdgdf444")).values(new Column("gin", "gindfd")).execute();
		;
		pdc.qe.select("*").from(t2).execute();
		pdc.qe.update(t2).values(new Column("FISRC", "sdgdf444")).where(new Column("FISRC", "sdgdf")).execute();

	}
}
