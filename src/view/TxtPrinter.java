package view;

import model.Home;
import model.ProjectConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class for printing result to txt file.
 *
 * @author Novik Ihar
 */
public class TxtPrinter implements Printable{
    private String outPutFilePath;

    public TxtPrinter(String outPutFile) {
        outPutFilePath = outPutFile;
    }



    @Override
    public void printAllAppliancesInfo(Home allAppliances,int usedPower) {

        sendReportToFile("\n"+allAppliances.toString()+("\n"+ ProjectConstants.TOTAL_POWER_CONSUMPTION
                +" - " + usedPower +" "+ ProjectConstants.WATT +"\n"));

    }



    @Override
    public void printSelectedAppliances(List selectedAppliances) {
        sendReportToFile("\n"+ProjectConstants.SELECTED_RANGE+":\n");
        StringBuilder selectedInfo=new StringBuilder("");
        for (Object a : selectedAppliances) {
            selectedInfo.append(a.toString()).append("\n");
        }
        sendReportToFile(selectedInfo.toString());
    }

    private void sendReportToFile(String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(outPutFilePath),true))) {
            bufferedWriter.write( message);
        } catch (IOException e) {
           // System.out.println("Ошибка при записи результатов работы програмы, проверьте правильность директории");
            e.printStackTrace();
        }
    }
}
