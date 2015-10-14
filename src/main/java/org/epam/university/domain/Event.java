package org.epam.university.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Andrei Kuzniatsou
 */
public class Event {

    private int id = (int) (System.currentTimeMillis() & 0xfffffff);
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static boolean isDay() {
        DateTime dateTime = DateTime.now(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+3")));
        int hourOfDay = dateTime.getHourOfDay();
        return hourOfDay > 8 && hourOfDay < 17;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("msg", msg)
                .append("date", date)
                .append("dateFormat", dateFormat.format(date))
                .toString();
    }
}
