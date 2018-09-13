package edu.hcmuaf.warehouse;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.Database;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class TransformDemo {
    public static void main(String[] args) {
        try {
            KettleEnvironment.init();
            DatabaseMeta source1 = new DatabaseMeta();
            source1.setDatabaseInterface(DatabaseMeta.getDatabaseInterface("MS SQL Server"));
            source1.setName("BHYT");
            source1.setHostname("DESKTOP-RKF9I56");
            source1.setDBName("BHYT");
            source1.setDBPort("1433");
            source1.setUsername("sa");
            source1.setPassword("a");
            Database database1 = new Database(null, source1);
            database1.connect();

            DatabaseMeta souce2 = new DatabaseMeta();
        souce2.setDatabaseInterface(DatabaseMeta.getDatabaseInterface("MS SQL Server"));
        souce2.setName("QL_BN_BHYT");
        souce2.setHostname("DESKTOP-RKF9I56");
        souce2.setDBName("QL_BN_BHYT");
        souce2.setDBPort("1433");
        souce2.setUsername("sa");
        souce2.setPassword("a");
        Database database2 = new Database(null, souce2);
        database2.connect();

        DatabaseMeta destination = new DatabaseMeta();
        destination.setDatabaseInterface(DatabaseMeta.getDatabaseInterface("MS SQL Server"));
        destination.setName("DW_Lab5");
        destination.setHostname("DESKTOP-RKF9I56");
        destination.setDBName("lab5");
        destination.setDBPort("1433");
        destination.setUsername("sa");
        destination.setPassword("a");
        Database database = new Database(null, destination);
        database.connect();

        TransMeta transMeta = new TransMeta("E:/User/Code/intellij/KettleApi/src/file/lab5.ktr");
        Trans trans = new Trans(transMeta);
        trans.execute(null);
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }
}
