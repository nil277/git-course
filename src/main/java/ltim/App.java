package ltim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
    public static void main(String[] args) {
        try {
            ArrayList<String> contractNoList = new ArrayList<>();
            ArrayList<String> invoiceAmountList = new ArrayList<>();
            ArrayList<String> despList = new ArrayList<>();

            //For reading downloads folder
            File folder = new File("C:\\Users\\10735121\\Downloads");
            File[] listOfFiles = folder.listFiles();


            /*
             * Read One by onw files in the folder
             * silect .txt files
             * if in the .txt file Invoice table contains separate out the table
             * From the table extract the data contract no and Invoice amount
             */
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println(file.getName());
                    BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    String line;
                    boolean p = false;
                    boolean no = false;
                    String pre = "";
                    String desp ="";
                    int count = 0;
                    String contractNo = "";
                    String invoiceAmount = "";
                    while ((line = bf.readLine()) != null) {
                        if (p) {
                            if ("0123456789".contains("" + line.charAt(0))) 
                            {
                                no = true;
                            }
                            if (no) {
                                count++;
                                if (count == 3) {
                                    contractNo = line;
                                    contractNoList.add(contractNo);
                                }
                                if(!line.contains("USD")&&!"0123456789".contains("" + line.charAt(0))){
                                    desp += line;
                                }
                            }
                            if (line.contains("USD")) {
                                despList.add(desp);
                                invoiceAmount = pre;
                                invoiceAmountList.add(invoiceAmount);
                                p = false;
                            }
                        }
                        if (line.contains("finalized")) {
                            p = true;
                        }
                        pre = line;
                    }
                    bf.close();
                }
            }

            Workbook workbook = new XSSFWorkbook();

            Sheet sh = workbook.createSheet("Invoice");

            sh.createFreezePane(0, 1);

            String[] columnHeadings = { "Contract No", "Invoice Amount", "Project Description" };

            Row headrerRow = sh.createRow(0);

            for (int i = 0; i < columnHeadings.length; i++) {
                Cell cell = headrerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
            }

            int rownum = 1;
            for (int i = 0; i < contractNoList.size(); i++) {
                Row row = sh.createRow(rownum++);
                row.createCell(0).setCellValue(contractNoList.get(i));
                row.createCell(1).setCellValue(invoiceAmountList.get(i));
                row.createCell(2).setCellValue(despList.get(i));
            }

            for (int i = 0; i < columnHeadings.length; i++) {
                sh.autoSizeColumn(i);
            }

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\10735121\\Downloads\\invoices.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();

            System.out.println("completed");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
