package edu.hcmuaf.warehouse;

import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryMeta;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;

public class RepositoryDemo {
    public Repository getRepository() {
        try {

            DatabaseConnectionDemo databaseConnectionDemo = new DatabaseConnectionDemo();
            DatabaseMeta databaseMeta = databaseConnectionDemo.getDestDatabaseMeta();
            RepositoryMeta repositoryMeta = new KettleDatabaseRepositoryMeta("KettleDatabaseRepository",
                    "Repository", "Des", databaseMeta);
            KettleDatabaseRepository repository = new KettleDatabaseRepository();
            repository.init(repositoryMeta);
            repository.connectionDelegate.connect(true, true);
            return repository;
        } catch (KettleException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RepositoryDemo repositoryDemo = new RepositoryDemo();
        repositoryDemo.getRepository();
    }
}
