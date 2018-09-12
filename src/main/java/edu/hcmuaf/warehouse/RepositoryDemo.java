package edu.hcmuaf.warehouse;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.RepositoriesMeta;
import org.pentaho.di.repository.RepositoryMeta;

public class RepositoryDemo {
    public static void main(String[] args) {
        try {
            RepositoriesMeta repositoriesMeta = new RepositoriesMeta();
            repositoriesMeta.readData();

        } catch (KettleException e) {
            e.printStackTrace();
        }
    }
}
