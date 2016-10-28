package com.atlassian.extras.common.org.springframework.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.util.StringUtils;


public class DefaultPropertiesPersister
{
    public void load(Properties props, InputStream is)
            throws IOException
    {
        props.load(is);
    }

    public void load(Properties props, Reader reader)
            throws IOException
    {
        BufferedReader in = new BufferedReader(reader);
        for (;;)
        {
            String line = in.readLine();
            if (line == null) {
                return;
            }
            line = StringUtils.trimLeadingWhitespace(line);
            if (line.length() > 0)
            {
                char firstChar = line.charAt(0);
                if ((firstChar != '#') && (firstChar != '!'))
                {
                    while (endsWithContinuationMarker(line))
                    {
                        String nextLine = in.readLine();
                        line = line.substring(0, line.length() - 1);
                        if (nextLine != null) {
                            line = line + StringUtils.trimLeadingWhitespace(nextLine);
                        }
                    }
                    int separatorIndex = line.indexOf("=");
                    if (separatorIndex == -1) {
                        separatorIndex = line.indexOf(":");
                    }
                    String key = separatorIndex != -1 ? line.substring(0, separatorIndex) : line;
                    String value = separatorIndex != -1 ? line.substring(separatorIndex + 1) : "";
                    key = StringUtils.trimTrailingWhitespace(key);
                    value = StringUtils.trimLeadingWhitespace(value);
                    props.put(unescape(key), unescape(value));
                }
            }
        }
    }

    protected boolean endsWithContinuationMarker(String line)
    {
        boolean evenSlashCount = true;
        int index = line.length() - 1;
        while ((index >= 0) && (line.charAt(index) == '\\'))
        {
            evenSlashCount = !evenSlashCount;
            index--;
        }
        return !evenSlashCount;
    }

    protected String unescape(String str)
    {
        StringBuffer outBuffer = new StringBuffer(str.length());
        for (int index = 0; index < str.length();)
        {
            char c = str.charAt(index++);
            if (c == '\\')
            {
                c = str.charAt(index++);
                if (c == 't') {
                    c = '\t';
                } else if (c == 'r') {
                    c = '\r';
                } else if (c == 'n') {
                    c = '\n';
                } else if (c == 'f') {
                    c = '\f';
                }
            }
            outBuffer.append(c);
        }
        return outBuffer.toString();
    }

    public void store(Properties props, OutputStream os, String header)
            throws IOException
    {
        props.store(os, header);
    }

    public void store(Properties props, Writer writer, String header)
            throws IOException
    {
        BufferedWriter out = new BufferedWriter(writer);
        if (header != null)
        {
            out.write("#" + header);
            out.newLine();
        }
        out.write("#" + new Date());
        out.newLine();
        for (Enumeration keys = props.keys(); keys.hasMoreElements();)
        {
            String key = (String)keys.nextElement();
            String val = props.getProperty(key);
            out.write(escape(key, true) + "=" + escape(val, false));
            out.newLine();
        }
        out.flush();
    }

    protected String escape(String str, boolean isKey)
    {
        int len = str.length();
        StringBuffer outBuffer = new StringBuffer(len * 2);
        for (int index = 0; index < len; index++)
        {
            char c = str.charAt(index);
            switch (c)
            {
                case ' ':
                    if ((index == 0) || (isKey)) {
                        outBuffer.append('\\');
                    }
                    outBuffer.append(' ');
                    break;
                case '\\':
                    outBuffer.append("\\\\");
                    break;
                case '\t':
                    outBuffer.append("\\t");
                    break;
                case '\n':
                    outBuffer.append("\\n");
                    break;
                case '\r':
                    outBuffer.append("\\r");
                    break;
                case '\f':
                    outBuffer.append("\\f");
                    break;
                default:
                    if ("=: \t\r\n\f#!".indexOf(c) != -1) {
                        outBuffer.append('\\');
                    }
                    outBuffer.append(c);
            }
        }
        return outBuffer.toString();
    }
}
