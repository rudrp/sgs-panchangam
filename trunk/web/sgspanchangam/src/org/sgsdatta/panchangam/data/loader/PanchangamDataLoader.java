package org.sgsdatta.panchangam.data.loader;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.sgsdatta.panchangam.dao.PanchangamDAO;
import org.sgsdatta.panchangam.data.Day;
import org.sgsdatta.panchangam.data.Lagnaantakaalam;
import org.sgsdatta.panchangam.data.Nakshatram;
import org.sgsdatta.panchangam.data.Panchangam;
import org.sgsdatta.panchangam.data.RaasiChakram;
import org.sgsdatta.panchangam.data.Tithi;
import org.sgsdatta.panchangam.data.Varjyam;
import org.sgsdatta.panchangam.util.Constants;

public class PanchangamDataLoader {
	private static final Logger log = Logger
			.getLogger(PanchangamDataLoader.class.getName());

	/**
	 * Load data.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
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
			}
		}

	}

	/**
	 * Construct panchangam.
	 * 
	 * @param row
	 *            the row
	 * @return the panchangam
	 */
	private Panchangam constructPanchangam(Row row) {
		Panchangam panchangam = new Panchangam();
		panchangam.setRaasiChakram(new RaasiChakram());
		panchangam.setLagnantakaalamulu(new ArrayList<Lagnaantakaalam>());
		for (Cell cell : row) {
			if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
				try {
					copyCellValue(panchangam, cell);
				} catch (IllegalStateException e) {

				}
			}
		}
		return panchangam;
	}

	/**
	 * Copy cell value.
	 * 
	 * @param panchangam
	 *            the panchangam
	 * @param cell
	 *            the cell
	 */
	private void copyCellValue(Panchangam panchangam, Cell cell)
			throws IllegalStateException {

		if (log.isLoggable(Level.INFO)) {
			log.info("Copying Cell value of  " + cell);
		}

		switch (cell.getColumnIndex()) {
		case 0:
			panchangam.setGregorianDate(new SimpleDateFormat("dd-MM-yyyy")
					.format((cell.getDateCellValue())));
			break;
		case 1:
			panchangam.setDay(new Day());
			panchangam.getDay().setYear(
					String.valueOf(Double.valueOf(cell.getNumericCellValue())
							.intValue()));
			break;
		case 2:
			panchangam.getDay().setMonth(cell.getStringCellValue());
			break;
		case 3:
			panchangam.getDay().setDate(
					String.valueOf(Double.valueOf(cell.getNumericCellValue())
							.intValue()));
			break;
		case 4:
			panchangam.getDay().setDayOfTheWeek(cell.getStringCellValue());
			break;
		case 5:
			panchangam.getDay().setRahukalam(cell.getStringCellValue());
			break;
		case 6:
			panchangam.getDay().setSunrise(
					appendGregorianDateToTime(panchangam.getGregorianDate(),
							cell.getDateCellValue()));
			break;
		case 7:
			panchangam.getDay().setSunset(
					appendGregorianDateToTime(panchangam.getGregorianDate(),
							cell.getDateCellValue()));
			break;
		case 8:
			panchangam.getDay().setAayanam(cell.getStringCellValue());
			break;
		case 9:
			Tithi t = new Tithi();
			t.setRutuvu(cell.getStringCellValue());
			ArrayList<Tithi> tl = new ArrayList<Tithi>();
			tl.add(t);
			panchangam.setTithis(tl);
			break;
		case 10:
			panchangam.getTithis().get(0).setMaasam(cell.getStringCellValue());
			break;
		case 11:
			panchangam.getTithis().get(0).setPaksham(cell.getStringCellValue());
			break;
		case 12:// Tithi
			String tithiCSV = cell.getStringCellValue();
			String[] tithis = tithiCSV.split(",");
			panchangam.getTithis().get(0).setTithiName(tithis[0]);
			if (tithis.length > 1) {
				try {
					Tithi t2 = (Tithi) panchangam.getTithis().get(0).clone();
					t2.setTithiName(tithis[1]);
					panchangam.getTithis().add(t2);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			break;
		case 13:
			if (cell.getCellType() == Cell.CELL_TYPE_STRING
					&& cell.getStringCellValue().contains(",")) {
				String tithiTimeCSV = cell.getStringCellValue();
				String[] tithiTimes = tithiTimeCSV.split(",");
				try {
					panchangam
							.getTithis()
							.get(0)
							.setTithiTime(appendGregorianDateToTime(panchangam.getGregorianDate(),
									new SimpleDateFormat("H:mm")
											.parse(tithiTimes[0])));
					panchangam
							.getTithis()
							.get(1)
							.setTithiTime(appendGregorianDateToTime(panchangam.getGregorianDate(),
									new SimpleDateFormat("H:mm")
											.parse(tithiTimes[1])));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				panchangam
						.getTithis()
						.get(0)
						.setTithiTime(
								appendGregorianDateToTime(
										panchangam.getGregorianDate(),
										cell.getDateCellValue()));
			}
			break;
		case 14:
			String nakshatramString = cell.getStringCellValue();
			ArrayList<Nakshatram> nl = new ArrayList<Nakshatram>();
			for (String nakshatram : nakshatramString.split(",")) {
				Nakshatram n = new Nakshatram();
				n.setNakshatram(nakshatram);
				nl.add(n);
			}
			panchangam.setNakshatrams(nl);
			break;
		case 15:// Nakshatram Time
			if (cell.getCellType() == Cell.CELL_TYPE_STRING
					&& cell.getStringCellValue().contains(",")) {
				String nakshatramTimeCSV = cell.getStringCellValue();
				String[] nakshatramTimes = nakshatramTimeCSV.split(",");
				try {
					panchangam
							.getNakshatrams()
							.get(0)
							.setNakshatramTime(
									appendGregorianDateToTime(panchangam
											.getGregorianDate(),
											new SimpleDateFormat("H:mm")
													.parse(nakshatramTimes[0])));
					panchangam
							.getNakshatrams()
							.get(1)
							.setNakshatramTime(
									appendGregorianDateToTime(panchangam
											.getGregorianDate(),
											new SimpleDateFormat("H:mm")
													.parse(nakshatramTimes[1])));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				panchangam
						.getNakshatrams()
						.get(0)
						.setNakshatramTime(
								appendGregorianDateToTime(
										panchangam.getGregorianDate(),
										cell.getDateCellValue()));
			}
			break;
		case 16:
			panchangam.getDay().setYogam(cell.getStringCellValue());
			break;
		case 17:
			panchangam.getDay().setKaranam(cell.getStringCellValue());
			break;
		case 18:
			Varjyam v = new Varjyam();
			ArrayList<Varjyam> a = new ArrayList<Varjyam>();
			a.add(v);
			panchangam.getDay().setVarjyamulu(a);

			panchangam
					.getDay()
					.getVarjyamulu()
					.get(0)
					.setVarjyamStartTime(
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getDateCellValue()));

			break;
		case 19:
			panchangam
					.getDay()
					.getVarjyamulu()
					.get(0)
					.setVarjyamEndTime(
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getDateCellValue()));
			break;
		case 20:
			Varjyam v2 = new Varjyam();
			panchangam.getDay().getVarjyamulu().add(v2);
			panchangam
					.getDay()
					.getVarjyamulu()
					.get(1)
					.setVarjyamStartTime(
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getDateCellValue()));

			break;
		case 21:
			panchangam
					.getDay()
					.getVarjyamulu()
					.get(1)
					.setVarjyamEndTime(
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getDateCellValue()));
			break;
		case 22:
			panchangam.getDay().setVisesham(cell.getStringCellValue());
			break;
		case 23:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));

			break;
		case 24:
			break;
		case 25:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 26:
			break;
		case 27:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 28:
			break;
		case 29:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 30:
			break;
		case 31:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 32:
			break;
		case 33:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 34:
			break;
		case 35:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 36:
			break;
		case 37:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 38:
			break;
		case 39:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 40:
			break;
		case 41:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 42:
			break;
		case 43:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 44:
			break;
		case 45:
			panchangam.getLagnantakaalamulu().add(
					new Lagnaantakaalam(cell.getStringCellValue(),
							appendGregorianDateToTime(
									panchangam.getGregorianDate(),
									cell.getRow()
											.getCell(cell.getColumnIndex() + 1)
											.getDateCellValue())));
			break;
		case 46:
			break;
		case 47:
			panchangam.getRaasiChakram().setMeshamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 48:
			panchangam.getRaasiChakram().setVrushabhamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 49:
			panchangam.getRaasiChakram().setMithunamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 50:
			panchangam.getRaasiChakram().setKarkatakamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 51:
			panchangam.getRaasiChakram().setSimhamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 52:
			panchangam.getRaasiChakram().setKanyaGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 53:
			panchangam.getRaasiChakram().setTulaGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 54:
			panchangam.getRaasiChakram().setVruschikamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 55:
			panchangam.getRaasiChakram().setDhanurGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 56:
			panchangam.getRaasiChakram().setMakaramGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 57:
			panchangam.getRaasiChakram().setKumbhamGrahaSthithi(
					cell.getStringCellValue());
			break;
		case 58:
			panchangam.getRaasiChakram().setMeenamGrahaSthithi(
					cell.getStringCellValue());
			break;

		}

	}

	private Date appendGregorianDateToTime(String gregorianDate,
			Date specifiedTime) {
		Calendar gregorianDateCalendar = Calendar.getInstance();
		Calendar specifiedTimeCalendar = Calendar.getInstance();
		Calendar updatedDateTime = Calendar.getInstance();
		try {
			gregorianDateCalendar.setTime(new SimpleDateFormat("dd-MM-yyyy")
					.parse(gregorianDate));
			updatedDateTime.setTimeZone(Constants.IST);
			specifiedTimeCalendar.setTime(specifiedTime);
			updatedDateTime.set(gregorianDateCalendar.get(Calendar.YEAR),
					gregorianDateCalendar.get(Calendar.MONTH),
					gregorianDateCalendar.get(Calendar.DATE),
					specifiedTimeCalendar.get(Calendar.HOUR_OF_DAY),
					specifiedTimeCalendar.get(Calendar.MINUTE),
					specifiedTimeCalendar.get(Calendar.SECOND));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return updatedDateTime.getTime();

	}
}
