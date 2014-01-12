package net.gionn.linuxmetrics4j.entity;

import java.lang.reflect.Field;
import java.util.List;

public class NetworkUsage
{
    String device;

    Integer bytesReceived;
    Integer packetsReceived;
    Integer errorsReceived;
    Integer dropsReceived;
    Integer fifoReceived;
    Integer frameReceived;
    Integer compressedReceived;
    Integer multicastReceived;

    Integer bytesTransmitted;
    Integer packetsTransmitted;
    Integer errorsTransmitted;
    Integer dropsTransmitted;
    Integer fifoTransmitted;
    Integer frameTransmitted;
    Integer compressedTransmitted;
    Integer multicastTransmitted;

    public NetworkUsage(String key, List<String> stats)
    {
        this.device = key;

        Field[] fields = this.getClass().getDeclaredFields();

        for (int i = 1; i < fields.length; i++)
        {
            fields[i].setAccessible(true);
            try
            {
                fields[i].set(this, Integer.parseInt(stats.get(i - 1)));
            } catch (Exception e)
            {
                continue;
            }
        }
    }

    @Override
    public String toString ()
    {
        return device + ": received " + bytesReceived + " bytes, sent " + bytesTransmitted + " bytes";
    }

    public String getDevice ()
    {
        return device;
    }

    public void setDevice ( String device )
    {
        this.device = device;
    }

    public Integer getBytesReceived ()
    {
        return bytesReceived;
    }

    public void setBytesReceived ( Integer bytesReceived )
    {
        this.bytesReceived = bytesReceived;
    }

    public Integer getPacketsReceived ()
    {
        return packetsReceived;
    }

    public void setPacketsReceived ( Integer packetsReceived )
    {
        this.packetsReceived = packetsReceived;
    }

    public Integer getErrorsReceived ()
    {
        return errorsReceived;
    }

    public void setErrorsReceived ( Integer errorsReceived )
    {
        this.errorsReceived = errorsReceived;
    }

    public Integer getDropsReceived ()
    {
        return dropsReceived;
    }

    public void setDropsReceived ( Integer dropsReceived )
    {
        this.dropsReceived = dropsReceived;
    }

    public Integer getFifoReceived ()
    {
        return fifoReceived;
    }

    public void setFifoReceived ( Integer fifoReceived )
    {
        this.fifoReceived = fifoReceived;
    }

    public Integer getFrameReceived ()
    {
        return frameReceived;
    }

    public void setFrameReceived ( Integer frameReceived )
    {
        this.frameReceived = frameReceived;
    }

    public Integer getCompressedReceived ()
    {
        return compressedReceived;
    }

    public void setCompressedReceived ( Integer compressedReceived )
    {
        this.compressedReceived = compressedReceived;
    }

    public Integer getMulticastReceived ()
    {
        return multicastReceived;
    }

    public void setMulticastReceived ( Integer multicastReceived )
    {
        this.multicastReceived = multicastReceived;
    }

    public Integer getBytesTransmitted ()
    {
        return bytesTransmitted;
    }

    public void setBytesTransmitted ( Integer bytesTransmitted )
    {
        this.bytesTransmitted = bytesTransmitted;
    }

    public Integer getPacketsTransmitted ()
    {
        return packetsTransmitted;
    }

    public void setPacketsTransmitted ( Integer packetsTransmitted )
    {
        this.packetsTransmitted = packetsTransmitted;
    }

    public Integer getErrorsTransmitted ()
    {
        return errorsTransmitted;
    }

    public void setErrorsTransmitted ( Integer errorsTransmitted )
    {
        this.errorsTransmitted = errorsTransmitted;
    }

    public Integer getDropsTransmitted ()
    {
        return dropsTransmitted;
    }

    public void setDropsTransmitted ( Integer dropsTransmitted )
    {
        this.dropsTransmitted = dropsTransmitted;
    }

    public Integer getFifoTransmitted ()
    {
        return fifoTransmitted;
    }

    public void setFifoTransmitted ( Integer fifoTransmitted )
    {
        this.fifoTransmitted = fifoTransmitted;
    }

    public Integer getFrameTransmitted ()
    {
        return frameTransmitted;
    }

    public void setFrameTransmitted ( Integer frameTransmitted )
    {
        this.frameTransmitted = frameTransmitted;
    }

    public Integer getCompressedTransmitted ()
    {
        return compressedTransmitted;
    }

    public void setCompressedTransmitted ( Integer compressedTransmitted )
    {
        this.compressedTransmitted = compressedTransmitted;
    }

    public Integer getMulticastTransmitted ()
    {
        return multicastTransmitted;
    }

    public void setMulticastTransmitted ( Integer multicastTransmitted )
    {
        this.multicastTransmitted = multicastTransmitted;
    }
}
