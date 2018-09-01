//package com.goebuy.utils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.mail.Session;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
///**
// * 使用poi导入导出Excel
// * @author Administrator
// *
// */
//public class ExportUtil  
//{  
//    private XSSFWorkbook wb = null;  
//  
//    private XSSFSheet sheet = null;  
//  
//    /** 
//     * @param wb 
//     * @param sheet 
//     */  
//    public ExportUtil(XSSFWorkbook wb, XSSFSheet sheet)  
//    {  
//        this.wb = wb;  
//        this.sheet = sheet;  
//    }  
//  
//    /** 
//     * 合并单元格后给合并后的单元格加边框 
//     *  
//     * @param region 
//     * @param cs 
//     */  
//    public void setRegionStyle(CellRangeAddress region, XSSFCellStyle cs)  
//    {  
//  
//        int toprowNum = region.getFirstRow();  
//        for (int i = toprowNum; i <= region.getLastRow(); i++)  
//        {  
//            XSSFRow row = sheet.getRow(i);  
//            for (int j = region.getFirstColumn(); j <= region.getLastColumn(); j++)  
//            {  
//                XSSFCell cell = row.getCell(j);// XSSFCellUtil.getCell(row,  
//                                                // (short) j);  
//                cell.setCellStyle(cs);  
//            }  
//        }  
//    }  
//  
//    /** 
//     * 设置表头的单元格样式 
//     *  
//     * @return 
//     */  
//    public XSSFCellStyle getHeadStyle()  
//    {  
//        // 创建单元格样式  
//        XSSFCellStyle cellStyle = wb.createCellStyle();  
//        // 设置单元格的背景颜色为淡蓝色  
//        cellStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);  
//        cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);  
//        // 设置单元格居中对齐  
//        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
//        // 设置单元格垂直居中对齐  
//        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);  
//        // 创建单元格内容显示不下时自动换行  
//        cellStyle.setWrapText(true);  
//        // 设置单元格字体样式  
//        XSSFFont font = wb.createFont();  
//        // 设置字体加粗  
//        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
//        font.setFontName("宋体");  
//        font.setFontHeight((short) 200);  
//        cellStyle.setFont(font);  
//        // 设置单元格边框为细线条  
//        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);  
//        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);  
//        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);  
//        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);  
//        return cellStyle;  
//    }  
//  
//    /** 
//     * 设置表体的单元格样式 
//     *  
//     * @return 
//     */  
//    public XSSFCellStyle getBodyStyle()  
//    {  
//        // 创建单元格样式  
//        XSSFCellStyle cellStyle = wb.createCellStyle();  
//        // 设置单元格居中对齐  
//        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
//        // 设置单元格垂直居中对齐  
//        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);  
//        // 创建单元格内容显示不下时自动换行  
//        cellStyle.setWrapText(true);  
//        // 设置单元格字体样式  
//        XSSFFont font = wb.createFont();  
//        // 设置字体加粗  
//        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
//        font.setFontName("宋体");  
//        font.setFontHeight((short) 200);  
//        cellStyle.setFont(font);  
//        // 设置单元格边框为细线条  
//        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);  
//        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);  
//        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);  
//        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);  
//        return cellStyle;  
//    }  
//}  
// 
////dao类  
////public interface ITestExportExcelDao  
////{  
////    public List<Goods> exportExcel(String hql);  
////}  
////@Repository  
////public class TestExportExcelDaoImpl implements ITestExportExcelDao  
////{  
////    @Resource  
////    private SessionFactory factory;  
////      
////    /** 
////     * 以goods表为例导出测试 
////     */  
////    @SuppressWarnings("unchecked")  
////    public List<Goods> exportExcel(String hql)  
////    {  
////        Session session = factory.getCurrentSession();  
////        List<Goods> list = session.createQuery(hql).list();  
////        return list;  
////    }  
////  
////}  
////控制层Controller  
////@Controller  
////@RequestMapping("/testexportexcel/*")  
////public class TestExportExcelController  
////{  
////    @Resource  
////    private ITestExportExcelService service;  
////  
////    @RequestMapping  
////    public String exportExcel(HttpServletResponse response)  
////    {  
////        response.setContentType("application/binary;charset=ISO8859_1");  
////        try  
////        {  
////            ServletOutputStream outputStream = response.getOutputStream();  
////            String fileName = new String(("导出excel例子").getBytes(), "ISO8859_1");  
////            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");// 组装附件名称和格式  
////            String hql = "from Goods";  
////            String[] titles = { "商品名", "商品单价", "商品单位" };  
////            service.exportExcel(hql, titles, outputStream);  
////        }  
////        catch (IOException e)  
////        {  
////            e.printStackTrace();  
////        }  
////        return null;  
////    }  
////  
////    @RequestMapping  
////    public String upload(HttpServletRequest request, HttpServletResponse response)  
////    {  
////        MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;  
////        MultipartFile file = mulRequest.getFile("excel");  
////        String filename = file.getOriginalFilename();  
////        if (filename == null || "".equals(filename))  
////        {  
////            return null;  
////        }  
////        try  
////        {  
////            InputStream input = file.getInputStream();  
////            XSSFWorkbook workBook = new XSSFWorkbook(input);  
////            XSSFSheet sheet = workBook.getSheetAt(0);  
////            if (sheet != null)  
////            {  
////                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)  
////                {  
////                    XSSFRow row = sheet.getRow(i);  
////                    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++)  
////                    {  
////                        XSSFCell cell = row.getCell(j);  
////                        String cellStr = cell.toString();  
////                        System.out.print("【"+cellStr+"】 ");  
////                    }  
////                    System.out.println();  
////                }  
////  
////            }  
////        }  
////        catch (Exception e)  
////        {  
////            e.printStackTrace();  
////        }  
////        return "/test/uploadExcel.jsp";  
////    }  
////  
////}