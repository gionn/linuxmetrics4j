package net.gionn.linuxmetrics4j.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ProcfileReader
{
    Map<String, List<String>> rawData = new HashMap<String, List<String>>();

    public void doRead () throws ProcReaderException
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/proc/" + getEntryName()));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] lineToken = parseLine(line);
                populateData(lineToken);
            }
            br.close();
        } catch (Exception e)
        {
            throw new ProcReaderException(e.getMessage());
        }
    }

    protected abstract String getEntryName ();

    protected abstract String[] parseLine ( String line );

    protected abstract void populateData ( String[] lineToken );

    public Map<String, List<String>> getRawData ()
    {
        return rawData;
    }
}
