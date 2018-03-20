package database.service;

import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

import database.DataBaseSettings;


public class DatabaseService {
	
	private static DatabaseService instance = null;
	private MysqlDataSource datasource;
	
	/*this is private because we don't need to create an instance of this class, 
	 * so we only do this if we use the method getInstance,
	 * and then it creates only one instance of this class.
	 * */
    private DatabaseService() throws SQLException {
        this.datasource = getDatasource();
    }
    
    // this is the method we call if we want to get the datasource to our database. Can be used without creating an instance - static
    public static MysqlDataSource getDatasource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(DataBaseSettings.databaseServer);
        dataSource.setDatabaseName(DataBaseSettings.databaseName);
        dataSource.setUser(DataBaseSettings.databaseUsername);
        dataSource.setPassword(DataBaseSettings.databaseSPassword);

        return dataSource;
    }
    
    
    
    	//don't really know why we need this, but I guess it's if we want to create an instance of this class and not just use getDatasource()
    public static DatabaseService getInstance() throws SQLException{
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }
}
