package net.gionn.linuxmetrics4j.readers;

import java.util.ArrayList;

public class NetDevReader extends ProcfileReader
{
    @Override
    public String getEntryName ()
    {
        return "net/dev";
    }

    @Override
    public String[] parseLine ( String line )
    {
        return line.split("(:\\s+)|(\\s+)");
    }

    @Override
    public void populateData ( String[] lineToken )
    {
        String key = lineToken[1];

        if (!key.matches("eth[0-9]|lo|wlan[0-9]|tun[0-99]|tap[0-99]")) return;

        ArrayList<String> result = new ArrayList<String>();

        for (int i = 2; i < lineToken.length; i++)
        {
            result.add(lineToken[i]);
        }
        rawData.put(key, result);
    }
}
