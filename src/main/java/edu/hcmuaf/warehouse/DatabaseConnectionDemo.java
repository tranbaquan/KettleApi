package edu.hcmuaf.warehouse;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.Database;
import org.pentaho.di.core.database.DatabaseMeta;

import java.sql.ResultSet;


public class DatabaseConnectionDemo {
    public static void main(String[] args) {
        try {
            KettleEnvironment.init();

            DatabaseMeta databaseMeta = new DatabaseMeta();

            databaseMeta.setDatabaseInterface(DatabaseMeta.getDatabaseInterface("MS SQL Server"));
            databaseMeta.setName("dw_src_qlbn");

            databaseMeta.setHostname("BAQUAN");
            databaseMeta.setDBName("dw_src_qlbn");
            databaseMeta.setDBPort("1433");
            databaseMeta.setUsername("tranbaquan");
            databaseMeta.setPassword("01642128235tbQ");

            Database database = new Database(null, databaseMeta);
            database.connect();

            ResultSet rs = database.openQuery("select * from dbo.capthuoc");

            while (rs.next()){
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println(rs.getString(4));
            }
            database.closeQuery(rs);
            database.disconnect();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
