package top.hugongzi.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;

public class StaticEntity {
    private byte valuebyte;
    private short valueshort;
    private float valuefloat;
    private long valuelong;
    private int valueint;
    private double valuedouble;
    private String valueString;
    private char valuechar;
    private boolean valueboolean;
    private java.sql.Timestamp valueTimestamp;
    private java.sql.Date valueDate;
    private java.sql.Time valueTime;
    private java.util.Date valueUtilDate;
    private java.util.Calendar valueCalendar;
    private java.util.Locale valueLocale;
    private java.util.TimeZone valueTimeZone;
    private java.util.Currency valueCurrency;

    public byte getValuebyte() {
        return valuebyte;
    }

    public void setValuebyte(byte valuebyte) {
        this.valuebyte = valuebyte;
    }

    public short getValueshort() {
        return valueshort;
    }

    public void setValueshort(short valueshort) {
        this.valueshort = valueshort;
    }

    public float getValuefloat() {
        return valuefloat;
    }

    public void setValuefloat(float valuefloat) {
        this.valuefloat = valuefloat;
    }

    public long getValuelong() {
        return valuelong;
    }

    public void setValuelong(long valuelong) {
        this.valuelong = valuelong;
    }

    public int getValueint() {
        return valueint;
    }

    public void setValueint(int valueint) {
        this.valueint = valueint;
    }

    public double getValuedouble() {
        return valuedouble;
    }

    public void setValuedouble(double valuedouble) {
        this.valuedouble = valuedouble;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public char getValuechar() {
        return valuechar;
    }

    public void setValuechar(char valuechar) {
        this.valuechar = valuechar;
    }

    public boolean isValueboolean() {
        return valueboolean;
    }

    public void setValueboolean(boolean valueboolean) {
        this.valueboolean = valueboolean;
    }

    public Timestamp getValueTimestamp() {
        return valueTimestamp;
    }

    public void setValueTimestamp(Timestamp valueTimestamp) {
        this.valueTimestamp = valueTimestamp;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Time getValueTime() {
        return valueTime;
    }

    public void setValueTime(Time valueTime) {
        this.valueTime = valueTime;
    }

    public java.util.Date getValueUtilDate() {
        return valueUtilDate;
    }

    public void setValueUtilDate(java.util.Date valueUtilDate) {
        this.valueUtilDate = valueUtilDate;
    }

    public Calendar getValueCalendar() {
        return valueCalendar;
    }

    public void setValueCalendar(Calendar valueCalendar) {
        this.valueCalendar = valueCalendar;
    }

    public Locale getValueLocale() {
        return valueLocale;
    }

    public void setValueLocale(Locale valueLocale) {
        this.valueLocale = valueLocale;
    }

    public TimeZone getValueTimeZone() {
        return valueTimeZone;
    }

    public void setValueTimeZone(TimeZone valueTimeZone) {
        this.valueTimeZone = valueTimeZone;
    }

    public Currency getValueCurrency() {
        return valueCurrency;
    }

    public void setValueCurrency(Currency valueCurrency) {
        this.valueCurrency = valueCurrency;
    }
}
