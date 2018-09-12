package edu.hcmuaf.warehouse;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Result;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.plugins.PluginRegistry;
import org.pentaho.di.core.plugins.RepositoryPluginType;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.RepositoriesMeta;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryMeta;

public class JobDemo {
    static {
        try {
            KettleEnvironment.init();
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            RepositoriesMeta repositoriesMeta = new RepositoriesMeta();
            repositoriesMeta.readData();
            RepositoryMeta repositoryMeta = repositoriesMeta.findRepository("repo");
            PluginRegistry registry = PluginRegistry.getInstance();
            Repository repository = registry.loadClass(
                    RepositoryPluginType.class,
                    repositoryMeta,
                    Repository.class
            );
            repository.init(repositoryMeta);
            JobMeta jobMeta = new JobMeta("D:\\Document\\[2017-2018]\\DataWarehouse\\data\\job1.kjb", repository);
            Job job = new Job(repository, jobMeta);
            job.start();
            job.waitUntilFinished();
            Result result = job.getResult();
            System.out.println(result);
        } catch (KettleXMLException e) {
            e.printStackTrace();
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }
}
