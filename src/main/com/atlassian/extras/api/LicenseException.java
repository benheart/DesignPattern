package com.atlassian.extras.api;

public class LicenseException
        extends RuntimeException
{
    public LicenseException() {}

    public LicenseException(String message)
    {
        super(message);
    }

    public LicenseException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public LicenseException(Throwable cause)
    {
        super(cause);
    }
}
