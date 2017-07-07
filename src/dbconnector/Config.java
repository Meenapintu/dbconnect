package dbconnector;

public class Config {

	public Config(String dATABASE, String hOST, String pORT, String uSER, String pASS, String schema) {
		super();
		DATABASE = dATABASE;
		HOST = hOST;
		PORT = pORT;
		USER = uSER;
		PASS = pASS;
		this.schema = schema;
	}

	public Config(String dATABASE, String hOST, String pORT) {
		super();
		DATABASE = dATABASE;
		HOST = hOST;
		PORT = pORT;
		USER = null;
		PASS = null;

	}

	public String DATABASE = null;
	public String HOST;
	public String PORT;
	public String USER;
	public String PASS;
	public String schema;

}
