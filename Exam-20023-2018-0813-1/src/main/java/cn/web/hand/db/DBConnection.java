package cn.web.hand.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	private static DBConnection DB_CONN;
	/*private String username;
	private String password;
	private String url;*/
	
	//
	private DBConnection(){
    	try {
			this.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static DBConnection getInstance(){
		if(DB_CONN == null){
			DB_CONN = new DBConnection();
		}
		return DB_CONN;
	}
	//初始化信息
	private void init() throws Exception{
		/*Properties prop = new Properties();
		InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("config/db.properties");
		prop.load(in);
		this.username = prop.getProperty("username");
		this.password = prop.getProperty("password");
		this.url = prop.getProperty("url");*/
		//String drivername = prop.getProperty("jdbc:mysql://localhost:3306/basictest");
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);	
	}
	
	//获取连接
	public Connection getConnection(){
		Connection coon = null;
		try {
			coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","pingchang");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return coon;
	}
	
	//关闭连接
	public void close(Connection conn,Statement stmt, ResultSet rs){
    	try{
    		if(rs != null) rs.close();
    		if(stmt != null) stmt.close();
    		if(conn != null) conn.close();
    	}catch(Exception e){}
    }
}
