//Importing java appropriate class

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;


//2a. Importing the package. --> java.sql
//2b. Load and register the driver --> com.mysql.jdbc.driver
//2c. Create a connection --> Create object Connection
//2d. Create a statement --> Create object Statement
//2e. Execute a query 
//2f. Close the connection

public class SqlTesting {

//we need to add exception because by default Class.forname() throws an error.	
	public static void main(String[] args) throws Exception{
		
//Instantiating SQL credentials		
		String url = "jdbc:mysql://localhost:3306/testemployee";
		String uname = "root";
		String pass = "sql123";
		String query = "insert into testemployee.employeetest VALUES (?,?,?);";
		
		String csvPath = "src\\csvTesst.csv";
		
//Creating a batch size because instead of sending each tedious request to SQL database
//we can process multiple queries in a single batch.
		int batchsize = 20;
		
//Class.forname() is used to load the driver from SQL.		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//Creating a connection		
		Connection con = DriverManager.getConnection(url, uname, pass);
		con.setAutoCommit(false);
		
//Creating a Prepared Statement instead of Create Statement. (I recommend you look online the difference between Create and Prepared Statement.)
		PreparedStatement st = con.prepareStatement(query);
//		ResultSet rt = st.executeUpdate(query);
//		rt.getResultSet();
		
// BufferedReader is based on FileReader MainClass but it makes use of efficiency and is much more faster in reading lines.
		BufferedReader lineReader = new BufferedReader(new FileReader(csvPath));
		
		String lineText = null;
		int count = 0;
		
//Read Data line by line by using this feature.
		lineReader.readLine();
		
		while((lineText = lineReader.readLine()) != null) {
			
// We are saving each text from the CSV file into a variable and then pushing it into SQL.
			String[] data = lineText.split(",");
			String employee_ID = data[0];
			String employee_name = data[1];
			String salary = data[2];
			
			st.setString(1, employee_ID);
			st.setString(2, employee_name);
			st.setString(3, salary);
			
			st.addBatch();
			
			if(count % batchsize == 0) {
				st.executeBatch();
			}
			
		}
		
		lineReader.close();
		st.executeBatch();
		con.commit();
		con.close();
		

	}

}
