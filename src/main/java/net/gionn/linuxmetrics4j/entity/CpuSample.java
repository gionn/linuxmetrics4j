package net.gionn.linuxmetrics4j.entity;

import java.util.Date;
import java.util.List;

public class CpuSample
{
    private Integer user;
    private Integer nice;
    private Integer system;
    private Integer idle;
    private Integer iowait;
    private Integer irq;
    private Integer softirq;
    private Date date;

    public CpuSample(String[] values)
    {
        this.user = Integer.parseInt(values[0]);
        this.nice = Integer.parseInt(values[1]);
        this.system = Integer.parseInt(values[2]);
        this.idle = Integer.parseInt(values[3]);
        this.iowait = Integer.parseInt(values[4]);
        this.irq = Integer.parseInt(values[5]);
        this.softirq = Integer.parseInt(values[6]);
        this.date = new Date();
    }

    public CpuSample(List<String> values)
    {
        this(values.toArray(new String[0]));
    }

    public Integer getUser ()
    {
        return user;
    }

    public void setUser ( Integer user )
    {
        this.user = user;
    }

    public Integer getNice ()
    {
        return nice;
    }

    public void setNice ( Integer nice )
    {
        this.nice = nice;
    }

    public Integer getSystem ()
    {
        return system;
    }

    public void setSystem ( Integer system )
    {
        this.system = system;
    }

    public Integer getIdle ()
    {
        return idle;
    }

    public void setIdle ( Integer idle )
    {
        this.idle = idle;
    }

    public Integer getIowait ()
    {
        return iowait;
    }

    public void setIowait ( Integer iowait )
    {
        this.iowait = iowait;
    }

    public Integer getIrq ()
    {
        return irq;
    }

    public void setIrq ( Integer irq )
    {
        this.irq = irq;
    }

    public Integer getSoftirq ()
    {
        return softirq;
    }

    public void setSoftirq ( Integer softirq )
    {
        this.softirq = softirq;
    }

    public Date getDate ()
    {
        return date;
    }

    public void setDate ( Date date )
    {
        this.date = date;
    }

}
