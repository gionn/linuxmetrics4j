package net.gionn.linuxmetrics4j.entity;

import java.text.DecimalFormat;

public class LoadAverage
{

    private Double oneMinute;
    private Double fiveMinutes;
    private Double fifteenMinutes;

    public LoadAverage()
    {
    }

    public LoadAverage(Double one, Double five, Double fifteen)
    {
        this.oneMinute = one;
        this.fiveMinutes = five;
        this.fifteenMinutes = fifteen;
    }

    public LoadAverage(String one, String five, String fifteen)
    {
        this(Double.parseDouble(one), Double.parseDouble(five), Double.parseDouble(fifteen));
    }

    public LoadAverage(Object object, Object object2, Object object3)
    {
        this(object.toString(), object2.toString(), object3.toString());
    }

    @Override
    public String toString ()
    {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return "" + df.format(this.oneMinute) + " " + df.format(this.fiveMinutes) + " "
                + df.format(this.fifteenMinutes);
    }

    public Double getOneMinute ()
    {
        return oneMinute;
    }

    public void setOneMinute ( Double oneMinute )
    {
        this.oneMinute = oneMinute;
    }

    public Double getFiveMinutes ()
    {
        return fiveMinutes;
    }

    public void setFiveMinutes ( Double fiveMinutes )
    {
        this.fiveMinutes = fiveMinutes;
    }

    public Double getFifteenMinutes ()
    {
        return fifteenMinutes;
    }

    public void setFifteenMinutes ( Double fifteenMinutes )
    {
        this.fifteenMinutes = fifteenMinutes;
    }
}
