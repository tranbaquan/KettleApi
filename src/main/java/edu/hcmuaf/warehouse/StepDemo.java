package edu.hcmuaf.warehouse;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.Database;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleMissingPluginsException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.RowAdapter;
import org.pentaho.di.trans.step.StepInterface;

public class StepDemo {
    static {
        try {
            KettleEnvironment.init();
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            TransMeta transMeta = new TransMeta("D:\\Document\\[2017-2018]\\DataWarehouse\\data\\lab5.ktr");
            Trans trans = new Trans(transMeta);
            trans.prepareExecution(null);

            StepInterface step = trans.findRunThread("calculator");
            step.addRowListener(new RowAdapter());
            trans.startThreads();
            trans.waitUntilFinished();
        } catch (KettleXMLException e) {
            e.printStackTrace();
        } catch (KettleMissingPluginsException e) {
            e.printStackTrace();
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }
}
