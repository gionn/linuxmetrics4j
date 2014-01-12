package net.gionn.linuxmetrics4j.entity;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import net.gionn.linuxmetrics4j.utils.StringUtils;

public class MemoryUsage
{
    // measures are in kB
    private Integer memTotal;
    private Integer memFree;
    private Integer buffers;
    private Integer cached;
    private Integer swapCached;
    private Integer active;
    private Integer Inactive;

    public MemoryUsage(Map<String, List<String>> data)
    {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields)
        {
            field.setAccessible(true);
            try
            {
                String fieldName = StringUtils.ucFirst(field.getName());

                String value = data.get(fieldName).get(0);
                // String unit = data.get(fieldName).get(1);

                field.set(this, Integer.parseInt(value));
            } catch (Exception e)
            {
                continue;
            }
        }
    }

    @Override
    public String toString ()
    {
        return "total: " + memTotal + " cached: " + cached + " buffers: " + buffers + " free: " + memFree;
    }

    public Integer getMemTotal ()
    {
        return memTotal;
    }

    public void setMemTotal ( Integer memTotal )
    {
        this.memTotal = memTotal;
    }

    public Integer getMemFree ()
    {
        return memFree;
    }

    public void setMemFree ( Integer memFree )
    {
        this.memFree = memFree;
    }

    public Integer getBuffers ()
    {
        return buffers;
    }

    public void setBuffers ( Integer buffers )
    {
        this.buffers = buffers;
    }

    public Integer getCached ()
    {
        return cached;
    }

    public void setCached ( Integer cached )
    {
        this.cached = cached;
    }

    public Integer getSwapCached ()
    {
        return swapCached;
    }

    public void setSwapCached ( Integer swapCached )
    {
        this.swapCached = swapCached;
    }

    public Integer getActive ()
    {
        return active;
    }

    public void setActive ( Integer active )
    {
        this.active = active;
    }

    public Integer getInactive ()
    {
        return Inactive;
    }

    public void setInactive ( Integer inactive )
    {
        Inactive = inactive;
    }
}
