package tasksystem.exceptions;

import tasksystem.datastore.DataStore;

public class InvalidFeatureImpactException extends RuntimeException{
    public InvalidFeatureImpactException(){
        System.err.println("Invalid impact value. Valid values are : "+ DataStore.featureImpact);
    }
}
