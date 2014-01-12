package net.gionn.linuxmetrics4j.readers;

public class ReaderFactory
{
    private static <T extends ProcfileReader> T doBuild ( Class<T> clazz ) throws ProcReaderException
    {
        T reader;
        try
        {
            reader = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e)
        {
            throw new ProcReaderException("Missing reader class?");
        }
        reader.doRead();
        return reader;
    }

    public static LoadAverageReader buildLoadAverageReader () throws ProcReaderException
    {
        return doBuild(LoadAverageReader.class);
    }

    public static MeminfoReader buildMeminfoReader () throws ProcReaderException
    {
        return doBuild(MeminfoReader.class);
    }

    public static NetDevReader buildNetDevReader () throws ProcReaderException
    {
        return doBuild(NetDevReader.class);
    }

    public static StatReader buildStatReader () throws ProcReaderException
    {
        return doBuild(StatReader.class);
    }
}
