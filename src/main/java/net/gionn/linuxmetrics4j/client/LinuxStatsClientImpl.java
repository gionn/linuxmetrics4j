package net.gionn.linuxmetrics4j.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.gionn.linuxmetrics4j.entity.CpuSample;
import net.gionn.linuxmetrics4j.entity.CpuUsage;
import net.gionn.linuxmetrics4j.entity.LoadAverage;
import net.gionn.linuxmetrics4j.entity.MemoryUsage;
import net.gionn.linuxmetrics4j.entity.NetworkUsage;
import net.gionn.linuxmetrics4j.readers.ProcReaderException;
import net.gionn.linuxmetrics4j.readers.ReaderFactory;

public class LinuxStatsClientImpl implements LinuxStatsClient
{
    @Override
    public LoadAverage getLoadAverage () throws ProcReaderException
    {
        Map<String, List<String>> data = ReaderFactory.buildLoadAverageReader().getRawData();
        List<String> load = data.get("load");
        LoadAverage la = new LoadAverage(load.get(0), load.get(1), load.get(2));
        return la;
    }

    @Override
    public MemoryUsage getMemoryInfo () throws ProcReaderException
    {
        Map<String, List<String>> data = ReaderFactory.buildMeminfoReader().getRawData();
        MemoryUsage memory = new MemoryUsage(data);
        return memory;
    }

    @Override
    public CpuUsage getCpuUsage () throws ProcReaderException
    {
        return getCpuUsage(1);
    }

    @Override
    public CpuUsage getCpuUsage ( Integer interval ) throws ProcReaderException
    {
        // FIXME most kernels are 100 hz, but not everyone
        Integer hz = 100;

        Map<String, List<String>> firstData = ReaderFactory.buildStatReader().getRawData();
        CpuSample cpuSample1 = new CpuSample(firstData.get("cpu"));

        try
        {
            Thread.sleep(interval * 1000);
        } catch (InterruptedException e)
        {
            return null;
        }

        Map<String, List<String>> secondData = ReaderFactory.buildStatReader().getRawData();
        CpuSample cpuSample2 = new CpuSample(secondData.get("cpu"));

        return new CpuUsage(cpuSample1, cpuSample2, hz, interval, detectCores(firstData));
    }

    private Integer detectCores ( Map<String, List<String>> data )
    {
        Integer count = 0;
        final String regexp = "cpu([0-9]+)";

        Set<Entry<String, List<String>>> keys = data.entrySet();
        for (Entry<String, List<String>> entry : keys)
        {
            if (entry.getKey().matches(regexp))
            {
                Integer cpuId = Integer.parseInt(entry.getKey().replaceFirst(regexp, "$1"));
                if (cpuId > count)
                {
                    count = cpuId;
                }
            }
        }
        return count + 1;
    }

    @Override
    public List<NetworkUsage> getNetworkUsage () throws ProcReaderException
    {
        List<NetworkUsage> result = new ArrayList<NetworkUsage>();

        Map<String, List<String>> data = ReaderFactory.buildNetDevReader().getRawData();
        Set<Entry<String, List<String>>> devices = data.entrySet();

        for (Entry<String, List<String>> entry : devices)
        {
            List<String> stats = entry.getValue();

            NetworkUsage n = new NetworkUsage(entry.getKey(), stats);
            result.add(n);
        }

        return result;
    }

    public static void main ( String[] args ) throws ProcReaderException
    {
        LinuxStatsClient client = new LinuxStatsClientImpl();

        CpuUsage cpuUsage = client.getCpuUsage();
        Integer count = cpuUsage.getCoreCount();
        BigDecimal idle = cpuUsage.getIdle();
        BigDecimal user = cpuUsage.getUser();

        MemoryUsage memory = client.getMemoryInfo();
        memory.getMemTotal();

        LoadAverage loadAverage = client.getLoadAverage();
        double five = loadAverage.getFiveMinutes();

        List<NetworkUsage> networks = client.getNetworkUsage();
        for (NetworkUsage network : networks)
        {
            String device = network.getDevice();
            Integer received = network.getBytesReceived();
            Integer sent = network.getBytesTransmitted();
        }
    }
}
