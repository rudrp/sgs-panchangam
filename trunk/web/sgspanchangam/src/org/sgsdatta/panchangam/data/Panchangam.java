package org.sgsdatta.panchangam.data;

import java.util.Date;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

@Entity
@Cached
@Unindexed
public class Panchangam {

	@Id
	private Long id;
	@Indexed
	private Date gregorianDate = null;
	private String year = null;
	private String month = null;
	private String date = null;
	private String day = null;
	private String rahukalam = null;
	private Date sunrise = null;
	private Date sunset = null;
	private String aayanam = null;
	private String rutuvu = null;
	private String maasam = null;
	private String paksham = null;
	private String tithi = null;
	private Date tithiTime = null;
	private String nakshatram = null;
	private Date nakshatramTime = null;
	private String yogam = null;
	private String karanam = null;
	private Date varjyam1Start = null;
	private Date varjyam1End = null;
	private Date varjyam2Start = null;
	private Date varjyam2End = null;
	private String visesham = null;
	private String r1 = null;
	private Date l1 = null;
	private String g1 = null;
	private String r2 = null;
	private Date l2 = null;
	private String g2 = null;
	private String r3 = null;
	private Date l3 = null;
	private String g3 = null;
	private String r4 = null;
	private Date l4 = null;
	private String g4 = null;
	private String r5 = null;
	private Date l5 = null;
	private String g5 = null;
	private String r6 = null;
	private Date l6 = null;
	private String g6 = null;
	private String r7 = null;
	private Date l7 = null;
	private String g7 = null;
	private String r8 = null;
	private Date l8 = null;
	private String g8 = null;
	private String r9 = null;
	private Date l9 = null;
	private String g9 = null;
	private String r10 = null;
	private Date l10 = null;
	private String g10 = null;
	private String r11 = null;
	private Date l11 = null;
	private String g11 = null;
	private String r12 = null;
	private Date l12 = null;
	private String g12 = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGregorianDate() {
		return gregorianDate;
	}

	public void setGregorianDate(Date gregorianDate) {
		this.gregorianDate = gregorianDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRahukalam() {
		return rahukalam;
	}

	public void setRahukalam(String rahukalam) {
		this.rahukalam = rahukalam;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	public String getAayanam() {
		return aayanam;
	}

	public void setAayanam(String aayanam) {
		this.aayanam = aayanam;
	}

	public String getRutuvu() {
		return rutuvu;
	}

	public void setRutuvu(String rutuvu) {
		this.rutuvu = rutuvu;
	}

	public String getMaasam() {
		return maasam;
	}

	public void setMaasam(String maasam) {
		this.maasam = maasam;
	}

	public String getPaksham() {
		return paksham;
	}

	public void setPaksham(String paksham) {
		this.paksham = paksham;
	}

	public String getTithi() {
		return tithi;
	}

	public void setTithi(String tithi) {
		this.tithi = tithi;
	}

	public Date getTithiTime() {
		return tithiTime;
	}

	public void setTithiTime(Date tithiTime) {
		this.tithiTime = tithiTime;
	}

	public String getNakshatram() {
		return nakshatram;
	}

	public void setNakshatram(String nakshatram) {
		this.nakshatram = nakshatram;
	}

	public Date getNakshatramTime() {
		return nakshatramTime;
	}

	public void setNakshatramTime(Date nakshatramTime) {
		this.nakshatramTime = nakshatramTime;
	}

	public String getYogam() {
		return yogam;
	}

	public void setYogam(String yogam) {
		this.yogam = yogam;
	}

	public String getKaranam() {
		return karanam;
	}

	public void setKaranam(String karanam) {
		this.karanam = karanam;
	}

	public Date getVarjyam1Start() {
		return varjyam1Start;
	}

	public void setVarjyam1Start(Date varjyam1Start) {
		this.varjyam1Start = varjyam1Start;
	}

	public Date getVarjyam1End() {
		return varjyam1End;
	}

	public void setVarjyam1End(Date varjyam1End) {
		this.varjyam1End = varjyam1End;
	}

	public Date getVarjyam2Start() {
		return varjyam2Start;
	}

	public void setVarjyam2Start(Date varjyam2Start) {
		this.varjyam2Start = varjyam2Start;
	}

	public Date getVarjyam2End() {
		return varjyam2End;
	}

	public void setVarjyam2End(Date varjyam2End) {
		this.varjyam2End = varjyam2End;
	}

	public String getVisesham() {
		return visesham;
	}

	public void setVisesham(String visesham) {
		this.visesham = visesham;
	}

	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public Date getL1() {
		return l1;
	}

	public void setL1(Date l1) {
		this.l1 = l1;
	}

	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public Date getL2() {
		return l2;
	}

	public void setL2(Date l2) {
		this.l2 = l2;
	}

	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}

	public String getR3() {
		return r3;
	}

	public void setR3(String r3) {
		this.r3 = r3;
	}

	public Date getL3() {
		return l3;
	}

	public void setL3(Date l3) {
		this.l3 = l3;
	}

	public String getG3() {
		return g3;
	}

	public void setG3(String g3) {
		this.g3 = g3;
	}

	public String getR4() {
		return r4;
	}

	public void setR4(String r4) {
		this.r4 = r4;
	}

	public Date getL4() {
		return l4;
	}

	public void setL4(Date l4) {
		this.l4 = l4;
	}

	public String getG4() {
		return g4;
	}

	public void setG4(String g4) {
		this.g4 = g4;
	}

	public String getR5() {
		return r5;
	}

	public void setR5(String r5) {
		this.r5 = r5;
	}

	public Date getL5() {
		return l5;
	}

	public void setL5(Date l5) {
		this.l5 = l5;
	}

	public String getG5() {
		return g5;
	}

	public void setG5(String g5) {
		this.g5 = g5;
	}

	public String getR6() {
		return r6;
	}

	public void setR6(String r6) {
		this.r6 = r6;
	}

	public Date getL6() {
		return l6;
	}

	public void setL6(Date l6) {
		this.l6 = l6;
	}

	public String getG6() {
		return g6;
	}

	public void setG6(String g6) {
		this.g6 = g6;
	}

	public String getR7() {
		return r7;
	}

	public void setR7(String r7) {
		this.r7 = r7;
	}

	public Date getL7() {
		return l7;
	}

	public void setL7(Date l7) {
		this.l7 = l7;
	}

	public String getG7() {
		return g7;
	}

	public void setG7(String g7) {
		this.g7 = g7;
	}

	public String getR8() {
		return r8;
	}

	public void setR8(String r8) {
		this.r8 = r8;
	}

	public Date getL8() {
		return l8;
	}

	public void setL8(Date l8) {
		this.l8 = l8;
	}

	public String getG8() {
		return g8;
	}

	public void setG8(String g8) {
		this.g8 = g8;
	}

	public String getR9() {
		return r9;
	}

	public void setR9(String r9) {
		this.r9 = r9;
	}

	public Date getL9() {
		return l9;
	}

	public void setL9(Date l9) {
		this.l9 = l9;
	}

	public String getG9() {
		return g9;
	}

	public void setG9(String g9) {
		this.g9 = g9;
	}

	public String getR10() {
		return r10;
	}

	public void setR10(String r10) {
		this.r10 = r10;
	}

	public Date getL10() {
		return l10;
	}

	public void setL10(Date l10) {
		this.l10 = l10;
	}

	public String getG10() {
		return g10;
	}

	public void setG10(String g10) {
		this.g10 = g10;
	}

	public String getR11() {
		return r11;
	}

	public void setR11(String r11) {
		this.r11 = r11;
	}

	public Date getL11() {
		return l11;
	}

	public void setL11(Date l11) {
		this.l11 = l11;
	}

	public String getG11() {
		return g11;
	}

	public void setG11(String g11) {
		this.g11 = g11;
	}

	public String getR12() {
		return r12;
	}

	public void setR12(String r12) {
		this.r12 = r12;
	}

	public Date getL12() {
		return l12;
	}

	public void setL12(Date l12) {
		this.l12 = l12;
	}

	public String getG12() {
		return g12;
	}

	public void setG12(String g12) {
		this.g12 = g12;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.gregorianDate + " " + this.tithi + " " + this.tithiTime;
	}

}
