package com.goebuy.utils;

import javax.servlet.ServletOutputStream;

public interface IExcelService {
	 public void exportExcel(String hql,String [] titles,ServletOutputStream outputStream);  
}
