package by.prokhorenko.shapes.validation;

import java.io.File;

public class ReaderValidator {

    public  boolean isNull(Object o){

        return o==null;
    }
    public  boolean isEmptyFile(String link){
        return new File(link).length() == 0;
    }

    public boolean fileIsExists(String link){
        return new File(link).exists();
    }
}
