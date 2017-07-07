package dbconnector;

public class Column {
	String name;
	String value;

	public Column(String Name, String Value) {
		this.name = Name;
		this.value = Value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
