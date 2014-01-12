package net.gionn.linuxmetrics4j.test;

import java.util.List;

import net.gionn.linuxmetrics4j.client.LinuxMetricsClient;
import net.gionn.linuxmetrics4j.client.LinuxMetricsClientImpl;
import net.gionn.linuxmetrics4j.entity.CpuUsage;
import net.gionn.linuxmetrics4j.entity.LoadAverage;
import net.gionn.linuxmetrics4j.entity.MemoryUsage;
import net.gionn.linuxmetrics4j.entity.NetworkUsage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinuxStatsClientTest
{

    private LinuxMetricsClient client;

    @Before
    public void setup ()
    {
        client = new LinuxMetricsClientImpl();
    }

    @Test
    public void loadAverageTest () throws Exception
    {
        LoadAverage load = client.getLoadAverage();
        assertTrue(load.getOneMinute() >= 0.0);
        assertTrue(load.getFiveMinutes() >= 0.0);
        assertTrue(load.getFifteenMinutes() >= 0.0);
    }

    @Test
    public void memoryInfoTest () throws Exception
    {
        MemoryUsage mem = client.getMemoryInfo();
        assertTrue(mem.getMemFree() > 0.0);
        assertTrue(mem.getMemTotal() > 0.0);
    }

    @Test
    public void networkUsageTest () throws Exception
    {
        List<NetworkUsage> nets = client.getNetworkUsage();
        for (NetworkUsage net : nets)
        {
            assertTrue(net.getDevice() != null);
            assertTrue(net.getBytesTransmitted() >= 0);
            assertTrue(net.getBytesReceived() >= 0);
        }
    }

    @Test
    public void cpuStatsTest () throws Exception
    {
        int i = 0;
        while (i < 3)
        {
            CpuUsage cpu = client.getCpuUsage();

            assertTrue(cpu.getIdle().intValue() >= 0);
            assertTrue(cpu.getUser().intValue() >= 0);
            assertTrue(cpu.getIowait().intValue() >= 0);
            assertTrue(cpu.getIrq().intValue() >= 0);

            int total = cpu.getIdle().intValue() + cpu.getIowait().intValue() + cpu.getIrq().intValue()
                    + cpu.getNice().intValue() + cpu.getSoftirq().intValue() + cpu.getSystem().intValue()
                    + cpu.getUser().intValue();

            assertTrue("total=" + total + "\n" + cpu,
                    total >= (95 * cpu.getCoreCount()) && total <= (105 * cpu.getCoreCount()));

            i++;
        }
    }
}
