package net.gionn.linuxmetrics4j.utils;

public class StringUtils
{
    public static String ucFirst ( String text )
    {
        String first = text.substring(0, 1);
        first = first.toUpperCase();
        return first + text.substring(1);
    }
}
