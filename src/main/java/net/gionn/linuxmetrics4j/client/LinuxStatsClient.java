package net.gionn.linuxmetrics4j.client;

import java.util.List;

import net.gionn.linuxmetrics4j.entity.CpuUsage;
import net.gionn.linuxmetrics4j.entity.LoadAverage;
import net.gionn.linuxmetrics4j.entity.MemoryUsage;
import net.gionn.linuxmetrics4j.entity.NetworkUsage;
import net.gionn.linuxmetrics4j.readers.ProcReaderException;

public interface LinuxStatsClient
{
    LoadAverage getLoadAverage () throws ProcReaderException;

    MemoryUsage getMemoryInfo () throws ProcReaderException;

    CpuUsage getCpuUsage () throws ProcReaderException;

    CpuUsage getCpuUsage ( Integer interval ) throws ProcReaderException;

    List<NetworkUsage> getNetworkUsage () throws ProcReaderException;
}
