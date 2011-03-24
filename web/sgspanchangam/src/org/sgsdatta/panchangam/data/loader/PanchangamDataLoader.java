package org.sgsdatta.panchangam.data.loader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.sgsdatta.panchangam.dao.PanchangamDAO;
import org.sgsdatta.panchangam.data.Panchangam;

public class PanchangamDataLoader {
	private static final Logger log = Logger
			.getLogger(PanchangamDataLoader.class.getName());

	private List<String> columnNames;

	public void loadData() throws IOException {
		PanchangamDAO panchangamDAO = new PanchangamDAO();
		panchangamDAO.truncate();

		InputStream panchangamFileInputStream = PanchangamDataLoader.class
				.getResourceAsStream("/org/sgsdatta/panchangam/resources/panchangam_khara_2011-12.xls");
		Workbook hssfWorkbook = new HSSFWorkbook(panchangamFileInputStream);
		Sheet sheet = hssfWorkbook.getSheetAt(0);
		for (Row row : sheet) {
			if (row.getRowNum() > 0) {
				Panchangam panchangam = constructPanchangam(row);
				if (log.isLoggable(Level.INFO)) {
					log.info(panchangam.toString());
				}

				panchangamDAO.savePanchangam(panchangam);
			} else {
				columnNames = new ArrayList<String>();
				for (Cell cell : row) {
					columnNames.add(cell.getStringCellValue());
				}
			}
		}

	}

	private Panchangam constructPanchangam(Row row) {
		Panchangam panchangam = new Panchangam();
		for (Cell cell : row) {
			if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
				copyCellValue(panchangam, cell);
			}
		}
		return panchangam;
	}

	private void copyCellValue(Panchangam panchangam, Cell cell) {
		String columnName = columnNames.get(cell.getColumnIndex());
		Class<?> panchangamClass = Panchangam.class;

		if (log.isLoggable(Level.INFO)) {
			log.info("Copying Cell value of  " + columnName);
		}

		try {
			Method getterMethod = panchangamClass.getMethod("get" + columnName);
			Method setterMethod = null;
			Object value = null;
			try {
				if (getterMethod.getReturnType() == String.class) {
					setterMethod = panchangamClass.getMethod(
							"set" + columnName, String.class);
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						value = String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						value = cell.getStringCellValue();
					}

				} else if (getterMethod.getReturnType() == Date.class) {
					setterMethod = panchangamClass.getMethod(
							"set" + columnName, Date.class);
					if (panchangam.getGregorianDate() == null) {

						value = cell.getDateCellValue();
					} else {
						Calendar specifiedTime = Calendar.getInstance();
						specifiedTime.setTime(cell.getDateCellValue());
						Calendar gregorianDate = Calendar.getInstance();
						gregorianDate.setTime(panchangam.getGregorianDate());
						Calendar updatedDateTime = Calendar.getInstance();
						updatedDateTime.set(gregorianDate.get(Calendar.YEAR),
								gregorianDate.get(Calendar.MONTH),
								gregorianDate.get(Calendar.DATE),
								specifiedTime.get(Calendar.HOUR_OF_DAY),
								specifiedTime.get(Calendar.MINUTE),
								specifiedTime.get(Calendar.SECOND));
						value = updatedDateTime.getTime();
					}
				}
			} catch (IllegalStateException ex) {
				// If data is incompatible - Ignore

			}
			if (setterMethod != null) {
				setterMethod.invoke(panchangam, value);
			}

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Columne Name "+columnName);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
