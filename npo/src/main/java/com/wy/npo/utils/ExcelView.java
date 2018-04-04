package com.wy.npo.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.wy.npo.constants.enums.CustomEnum;
import com.wy.npo.utils.annotation.ExcelAttribute;

/**
 * 导出工具类（如果想要导出2003版本的excel，这里继承的方法修改成AbstractXlsView）
 * @author wangy
 */
public class ExcelView<T extends CustomEnum> extends AbstractXlsxView {
	

	private String fileName;
	
	private String sheetName;
	
	public ExcelView(String fileName,String sheetName){
		this.fileName = fileName;
		this.sheetName = sheetName;
	}

	@Override
	protected void buildExcelDocument(Map<String,Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		  // excel中每个sheet中最多有65536行  
          int sheetSize = 65536;
		  List<Object> list = (List<Object>)model.get("list");
		
		  // 取出一共有多少个sheet  
          int listSize = 0;  
          if (list != null && list.size() >= 0) {  
              listSize = list.size();  
          } 
          //获取各个sheet数据行数
		  double sheetNo = Math.ceil(listSize / sheetSize);  
		  
		  Field[] allFields = (list.get(0)).getClass().getDeclaredFields();
		  List<Field> fields = new ArrayList<Field>();  
		  // 得到所有field并存放到一个list中  
          for (Field field : allFields) {  
              if (field.isAnnotationPresent(ExcelAttribute.class)) {  
                  fields.add(field);  
              }  
          }  
          for (int index = 0; index <= sheetNo; index++) {  
        	  Sheet sheet = workbook.createSheet();
        	  // 设置工作表的名称.  
              workbook.setSheetName(index, sheetName + index);  
	          Row row = sheet.createRow(0);
	          Cell cell;
	          /* *********普通列样式*********** */
	          Font font = workbook.createFont();
	          CellStyle cellStyle = workbook.createCellStyle();  
	          font.setFontName("Arail narrow"); // 字体  
	          font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体宽度 
	          /* *********高亮列样式********* */  
	          Font newFont = workbook.createFont();
	          CellStyle newCellStyle = workbook.createCellStyle();
	          newFont.setFontName("Arail narrow"); // 字体  
	          newFont.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体宽度 
	          
	          for (int i = 0; i < fields.size(); i++) {   
	 			 Field field = fields.get(i);  
	 			 ExcelAttribute attr = field.getAnnotation(ExcelAttribute.class);  
	 			 int col = i;  
	 			 // 根据指定的顺序获得列号  
	              if (StringUtils.isNotBlank(attr.column())) {  
	                  col = getExcelCol(attr.column()); 
	              }  
	              // 创建列  
	              cell = row.createCell(col); 
	              if (attr.isMark()) {   //是否高亮显示
	                  newFont.setColor(Font.COLOR_RED); // 字体颜色  
	                  newCellStyle.setFont(newFont);  
	                  //背景颜色
	                  newCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
	                  newCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
                      setCellStyle(newCellStyle);
	                  cell.setCellStyle(newCellStyle);  
	                 
	              } else {  
	                  font.setColor(Font.COLOR_NORMAL); // 字体颜色  
	                  cellStyle.setFont(font);  
	                   //背景颜色
	                  cellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
	                  cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	                  setCellStyle(cellStyle);
	                  cell.setCellStyle(cellStyle);  
	              }  
	              int width = (int) ((attr.name().getBytes().length <= 4 ? 6 : attr.name().getBytes().length) * 1.5 * 256);
	              //如果有设置宽度，则将设置的看宽度填入
	              if(0 != attr.width()){
	            	  width = attr.width();
	              }
	              sheet.setColumnWidth(i, width);
	              // 设置列中写入内容为String类型  
	              cell.setCellType(Cell.CELL_TYPE_STRING); 
	              // 写入列名  
	              cell.setCellValue(attr.name());
	          }
	          /* *************创建内容列*************** */  
              font = workbook.createFont();  
              cellStyle = workbook.createCellStyle();  
              int startNo = index * sheetSize;  
              int endNo = Math.min(startNo + sheetSize, listSize);  
              // 写入各条记录,每条记录对应excel表中的一行  
              for (int i = startNo; i < endNo; i++) { 
            	  row = sheet.createRow(i + 1 - startNo); 
            	  Object entity = list.get(i);
            	  for (int j = 0; j < fields.size(); j++) {  
            		  // 获得field  
                      Field field = fields.get(j);  
                      // 设置实体类私有属性可访问  
                      field.setAccessible(true); 
                      ExcelAttribute attr = field.getAnnotation(ExcelAttribute.class);  
                      int col = j;  
                      // 根据指定的顺序获得列号  
                      if (StringUtils.isNotBlank(attr.column())) {  
                          col = getExcelCol(attr.column());  
                      }  
                      // 根据ExcelVOAttribute中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.  
                      if (attr.isExport()) { 
                    	 // 创建cell  
                          cell = row.createCell(col);  
                          if (attr.isMark()) {  
                        	  CellStyle contentCell = workbook.createCellStyle();
                              newFont.setColor(Font.COLOR_RED); // 字体颜色  
                              contentCell.setFont(newFont);  
        	                  setCellStyle(contentCell);
                              cell.setCellStyle(contentCell);  
                          } else {  
                              font.setColor(Font.COLOR_NORMAL); // 字体颜色  
                              cellStyle.setFont(font);  
                              setCellStyle(cellStyle);
                              cell.setCellStyle(cellStyle);  
                          }  
                           // 如果数据存在就填入,不存在填入空格  
                          Class<?> classType = (Class<?>) field.getType();  
                          String value = null;  
                          if (field.get(entity) != null && classType.isAssignableFrom(Date.class)) {
                        	  SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);  
                              value = DateUtil.getDateTimeFormat(sdf.parse(String.valueOf(field.get(entity))));  
                          }  
                          if(attr.fommat().isEnum()){
                        	  value = resolveEnumValue(String.valueOf(field.get(entity)), attr.fommat());
                          }
                          cell.setCellValue(field.get(entity) == null ? "" : value == null ? String.valueOf(field.get(entity)) : value);  
                      }
            	  }
              } 
              /* *************创建合计列*************** */  
              Row lastRow = sheet.createRow((short) (sheet.getLastRowNum() + 1));  
              for (int i = 0; i < fields.size(); i++) {  
            	  Field field = fields.get(i);
            	  ExcelAttribute attr = field.getAnnotation(ExcelAttribute.class);  
            	  if (attr.isSum()) {  
            		  int col = i;  
            		  // 根据指定的顺序获得列号  
                      if (StringUtils.isNotBlank(attr.column())) {  
                          col = getExcelCol(attr.column());  
                      } 
                      BigDecimal totalNumber = BigDecimal.ZERO;  
                      for (int j = 1, len = (sheet.getLastRowNum() - 1); j <= len; j++) {  
                    	  Row hssfRow = sheet.getRow(j);
                    	  if (hssfRow != null) {  
                    		  Cell hssfCell = hssfRow.getCell(col);  
                    		  if (hssfCell != null && hssfCell.getCellType() == Cell.CELL_TYPE_STRING  
                                      && NumberUtils.isNumber(hssfCell.getStringCellValue())) {  
                    			  totalNumber = totalNumber.add(BigDecimal.valueOf(Double.valueOf(hssfCell.getStringCellValue())));
                    		  }
                    	  }
                      }
                      Cell sumCell = lastRow.createCell(col);  
                      sumCell.setCellValue("合计：" + totalNumber);  
            	  }
              }
 		  }
          //这里为必须编写的代码
		  String name = URLEncoder.encode(fileName+".xlsx", "UTF-8");
	      response.setHeader("Content-Disposition", "attachment; filename="+name);
	} 
	
	/**
	 * 边框设置
	 * @param cellstyle
	 */
	private void setCellStyle(CellStyle cellstyle){
		cellstyle.setBorderRight(CellStyle.BORDER_THIN);
		cellstyle.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellstyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellstyle.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellstyle.setBorderTop(CellStyle.BORDER_THIN);
		cellstyle.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellstyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellstyle.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
	}
	
	 /** 
     * 将EXCEL中A,B,C,D,E列映射成0,1,2,3 
     *  
     * @param col 
     */  
    private static int getExcelCol(String col) {  
        col = col.toUpperCase();  
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。  
        int count = -1;  
        char[] cs = col.toCharArray();  
        for (int i = 0; i < cs.length; i++) {  
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);  
        }  
        return count;  
    }  
    

    private String resolveEnumValue(String value, Class<T> type) {  
    	 for (T constant : type.getEnumConstants()){  
    	    // if (constant.toString().equalsIgnoreCase(value)) {  
    	    return constant.value(value);  
    	    //}  
    	 }   
    	 return null;  
    } 
}
