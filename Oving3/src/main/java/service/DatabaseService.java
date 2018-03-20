package service;

import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

import database.DataBaseSettings;


public class DatabaseService {
	
	private static DatabaseService instance = null;
	private MysqlDataSource datasource;
	
    private DatabaseService() throws SQLException {
        this.datasource = getDatasource();
    }
    
    public static MysqlDataSource getDatasource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(DataBaseSettings.databaseServer);
        dataSource.setDatabaseName(DataBaseSettings.databaseName);
        dataSource.setUser(DataBaseSettings.databaseUsername);
        dataSource.setPassword(DataBaseSettings.databaseSPassword);

        return dataSource;
    }
}
