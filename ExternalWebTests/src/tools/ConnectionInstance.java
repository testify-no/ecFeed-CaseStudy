package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;



public class ConnectionInstance{
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet result = null;
	
	ConnectionInstance(DataSource dataSource){
		try{
			connection = dataSource.getConnection();
			statement = connection.createStatement();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	ResultSet tryQuery(String query){
		try{
			result = statement.executeQuery(query);
			return result;
		} catch(Exception e){
			System.out.println(e.getMessage());
			result = null;
			return null;
		}		
	}
	
	int tryUpdate(String query){
		int outcome = -1;
		try{
			statement.executeQuery("SET DATABASE REFERENTIAL INTEGRITY FALSE;");
			outcome = statement.executeUpdate(query);
			statement.executeQuery("SET DATABASE REFERENTIAL INTEGRITY TRUE;");
			return outcome;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return outcome;
		}		
	}
	
	public void close(){
		try{
			connection.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
