package net.gionn.linuxmetrics4j.readers;

public class ProcReaderException extends Exception
{
    private static final long serialVersionUID = 1320626220726286362L;

    String message = "Error while processing proc file: ";

    public ProcReaderException(String message)
    {
        super();
        this.message.concat(message);
    }
}
