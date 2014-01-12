package net.gionn.linuxmetrics4j.readers;

import java.util.Arrays;

public class LoadAverageReader extends ProcfileReader
{
    @Override
    public String getEntryName ()
    {
        return "loadavg";
    }

    @Override
    public String[] parseLine ( String line )
    {
        return line.split(" ");
    }

    @Override
    public void populateData ( String[] lineToken )
    {
        rawData.put("load", Arrays.asList(lineToken));
    }
}
