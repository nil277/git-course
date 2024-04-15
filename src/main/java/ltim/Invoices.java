package ltim;

import java.util.ArrayList;
import java.util.Date;

    // BufferedReader bf = new BufferedReader(new InputStreamReader(new
    // FileInputStream(file)));
    // String line;
    // boolean p = false;
    // boolean no = false;
    // String pre = "";
    // int count = 0;
    // String contractNo = "";
    // String invoiceAmount = "";
    // while ((line = bf.readLine()) != null) {

    // if(p){
    // //System.out.println(line);
    // if("0123456789".contains(""+line.charAt(0))){
    // no = true;
    // }
    // if(no){
    // count++;
    // if(count == 3){
    // contractNo = line;
    // }
    // }
    // if(line.contains("USD")) {
    // invoiceAmount = pre;
    // p = false;
    // }
    // }
    // if(line.contains("finalized")){
    // p = true;
    // }
    // pre = line;
    // }


    // ArrayList<Invoices> list = createData();
    // int rownum = 1;
    // for(Invoices i : list){
    // Row row = sh.createRow(rownum++);
    // row.createCell(0).setCellValue(i.getItemId());
    // row.createCell(1).setCellValue(i.getItemName());
    // row.createCell(2).setCellValue(i.getItemQty());
    // row.createCell(3).setCellValue(i.getTotalPrice());
    // Cell cell = row.createCell(4);
    // cell.setCellValue(i.getItemSoldDate());
    // cell.setCellStyle(dateStyle);
    // }

    // Workbook workbook = new XSSFWorkbook();

    // Sheet sh = workbook.createSheet("Invoice");

    // sh.createFreezePane(0, 1);

    // String [] columnHeadings = {"Item Id","Item Name","Qnt","Item Price","Sold
    // Date"};

    // Row headrerRow = sh.createRow(0);

    // for(int i = 0;i < columnHeadings.length;i++){
    // Cell cell = headrerRow.createCell(i);
    // cell.setCellValue(columnHeadings[i]);
    // }

    // ArrayList<Invoices> list = createData();

    // CreationHelper creationHelper = workbook.getCreationHelper();
    // CellStyle dateStyle = workbook.createCellStyle();
    // dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
    // int rownum = 1;
    // for(Invoices i : list){
    // Row row = sh.createRow(rownum++);
    // row.createCell(0).setCellValue(i.getItemId());
    // row.createCell(1).setCellValue(i.getItemName());
    // row.createCell(2).setCellValue(i.getItemQty());
    // row.createCell(3).setCellValue(i.getTotalPrice());
    // Cell cell = row.createCell(4);
    // cell.setCellValue(i.getItemSoldDate());
    // cell.setCellStyle(dateStyle);
    // }

    // for(int i = 0; i < columnHeadings.length;i++){
    // sh.autoSizeColumn(i);
    // }

    // Sheet sh2 = workbook.createSheet("Second");

    // FileOutputStream fileOutputStream = new
    // FileOutputStream("C:\\Users\\10735121\\Downloads\\invoices.xlsx");
    // workbook.write(fileOutputStream);
    // fileOutputStream.close();
    // workbook.close();

    // System.out.println("completed");


    //git learning
    //curently on niladri branch


public class Invoices {
    int itemId;
    int itemQty;
    String itemName;
    double totalPrice;
    Date itemSoldDate;
    public Invoices(int itemId, String itemName, int itemQty, double totalPrice, Date itemSoldDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.totalPrice = totalPrice;
        this.itemSoldDate = itemSoldDate;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemQty() {
        return itemQty;
    }
    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Date getItemSoldDate() {
        return itemSoldDate;
    }
    public void setItemSoldDate(Date itemSoldDate) {
        this.itemSoldDate = itemSoldDate;
    }

    public static ArrayList<Invoices> createData() {
        ArrayList<Invoices> list = new ArrayList<>();
        list.add(new Invoices(1, "Book", 10, 100, new Date()));
        list.add(new Invoices(2, "Book", 10, 100, new Date()));
        list.add(new Invoices(3, "Book", 10, 100, new Date()));
        list.add(new Invoices(4, "Book", 10, 100, new Date()));
        list.add(new Invoices(5, "Book", 10, 100, new Date()));
        list.add(new Invoices(6, "Book", 10, 100, new Date()));
        list.add(new Invoices(7, "Book", 10, 100, new Date()));
        list.add(new Invoices(8, "Book", 10, 100, new Date()));
        return list;
    }
}
