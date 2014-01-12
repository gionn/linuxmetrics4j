package net.gionn.linuxmetrics4j.readers;

import java.util.ArrayList;

public class StatReader extends ProcfileReader
{
    @Override
    public String getEntryName ()
    {
        return "stat";
    }

    @Override
    public String[] parseLine ( String line )
    {
        return line.split("\\s+");
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
