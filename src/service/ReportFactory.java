package service;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class ReportFactory {

    public iReport makeReport(String type,String name){
        if(type.equals("PDF"))
            return new PDF();
            else if(type.equals("CSV"))
            return new CSV();
        else return null;
    }
}
