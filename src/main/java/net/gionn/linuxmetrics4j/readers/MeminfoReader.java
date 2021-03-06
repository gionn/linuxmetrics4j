package net.gionn.linuxmetrics4j.readers;

import java.util.ArrayList;

public class MeminfoReader extends ProcfileReader
{
    @Override
    public String getEntryName ()
    {
        return "meminfo";
    }

    @Override
    public String[] parseLine ( String line )
    {
        return line.split(":\\s+|\\s");
    }

    @Override
    public void populateData ( String[] lineToken )
    {
        String key = lineToken[0];
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 1; i < lineToken.length; i++)
        {
            result.add(lineToken[i]);
        }
        rawData.put(key, result);
    }
}
