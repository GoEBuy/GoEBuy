//package com.goebuy.utils;
//
//import java.io.IOException;
//
//import javax.servlet.ServletOutputStream;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Service;
//
//public class ExcelService {
//
//@Service  
//public class ExcelServiceImpl implements IExcelService  
//{  
////    @Resource  
////    private ITestExportExcelDao dao;  
//      
//    public void exportExcel(String hql, String[] titles, ServletOutputStream outputStream)  
//    {  
////        List<Goods> list = dao.exportExcel(hql);  
//        // 创建一个workbook 对应一个excel应用文件  
//        XSSFWorkbook workBook = new XSSFWorkbook();  
//        // 在workbook中添加一个sheet,对应Excel文件中的sheet  
//        XSSFSheet sheet = workBook.createSheet("导出excel例子");  
//        ExportUtil exportUtil = new ExportUtil(workBook, sheet);  
//        XSSFCellStyle headStyle = exportUtil.getHeadStyle();  
//        XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();  
//        // 构建表头  
//        XSSFRow headRow = sheet.createRow(0);  
//        XSSFCell cell = null;  
//        for (int i = 0; i < titles.length; i++)  
//        {  
//            cell = headRow.createCell(i);  
//            cell.setCellStyle(headStyle);  
//            cell.setCellValue(titles[i]);  
//        }  
////        // 构建表体数据  
////        if (list != null && list.size() > 0)  
////        {  
////            for (int j = 0; j < list.size(); j++)  
////            {  
////                XSSFRow bodyRow = sheet.createRow(j + 1);  
////                Goods goods = list.get(j);  
////  
////                cell = bodyRow.createCell(0);  
////                cell.setCellStyle(bodyStyle);  
////                cell.setCellValue(goods.getGoodsName());  
////  
////                cell = bodyRow.createCell(1);  
////                cell.setCellStyle(bodyStyle);  
////                cell.setCellValue(goods.getGoodsCost());  
////  
////                cell = bodyRow.createCell(2);  
////                cell.setCellStyle(bodyStyle);  
////                cell.setCellValue(goods.getGoodsUnit());  
////            }  
////        }  
//        try  
//        {  
//            workBook.write(outputStream);  
//            outputStream.flush();  
//            outputStream.close();  
//        }  
//        catch (IOException e)  
//        {  
//            e.printStackTrace();  
//        }  
//        finally  
//        {  
//            try  
//            {  
//                outputStream.close();  
//            }  
//            catch (IOException e)  
//            {  
//                e.printStackTrace();  
//            }  
//        }  
//    }
//}
//  
//  
//}
