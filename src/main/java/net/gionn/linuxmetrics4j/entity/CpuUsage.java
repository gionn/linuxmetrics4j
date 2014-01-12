package net.gionn.linuxmetrics4j.entity;

import java.math.BigDecimal;

public class CpuUsage
{
    private BigDecimal user;
    private BigDecimal nice;
    private BigDecimal system;
    private BigDecimal idle;
    private BigDecimal iowait;
    private BigDecimal irq;
    private BigDecimal softirq;

    private Integer coreCount;

    public CpuUsage(CpuSample firstSample, CpuSample secondSample, Integer hz, long interval, Integer coreCount)
    {
        if (coreCount != null)
        {
            this.coreCount = coreCount;
        }
        else
        {
            this.coreCount = 1;
        }

        // FIXME improve cpu stats accuracy

        this.user = new BigDecimal(100 * (secondSample.getUser() - firstSample.getUser()) / hz / interval);
        this.nice = new BigDecimal(100 * (secondSample.getNice() - firstSample.getNice()) / hz / interval);
        this.system = new BigDecimal(100 * (secondSample.getSystem() - firstSample.getSystem()) / hz / interval);
        this.idle = new BigDecimal(100 * (secondSample.getIdle() - firstSample.getIdle()) / hz / interval);
        this.iowait = new BigDecimal(100 * (secondSample.getIowait() - firstSample.getIowait()) / hz / interval);
        this.irq = new BigDecimal(100 * (secondSample.getIrq() - firstSample.getIrq()) / hz / interval);
        this.softirq = new BigDecimal(100 * (secondSample.getSoftirq() - firstSample.getSoftirq()) / hz / interval);
    }

    @Override
    public String toString ()
    {
        return "user=" + user + " nice=" + nice + " system=" + system + " idle=" + idle + " iowait=" + iowait + " irq="
                + irq + " softirq=" + softirq;
    }

    public BigDecimal getUser ()
    {
        return user;
    }

    public void setUser ( BigDecimal user )
    {
        this.user = user;
    }

    public BigDecimal getNice ()
    {
        return nice;
    }

    public void setNice ( BigDecimal nice )
    {
        this.nice = nice;
    }

    public BigDecimal getSystem ()
    {
        return system;
    }

    public void setSystem ( BigDecimal system )
    {
        this.system = system;
    }

    public BigDecimal getIdle ()
    {
        return idle;
    }

    public void setIdle ( BigDecimal idle )
    {
        this.idle = idle;
    }

    public BigDecimal getIowait ()
    {
        return iowait;
    }

    public void setIowait ( BigDecimal iowait )
    {
        this.iowait = iowait;
    }

    public BigDecimal getIrq ()
    {
        return irq;
    }

    public void setIrq ( BigDecimal irq )
    {
        this.irq = irq;
    }

    public BigDecimal getSoftirq ()
    {
        return softirq;
    }

    public void setSoftirq ( BigDecimal softirq )
    {
        this.softirq = softirq;
    }

    public Integer getCoreCount ()
    {
        return coreCount;
    }

    public void setCoreCount ( Integer coreCount )
    {
        this.coreCount = coreCount;
    }

}
