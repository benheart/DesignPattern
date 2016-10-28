package com.atlassian.extras.common;

/**
 * @deprecated
 */
public class LicenseException extends com.atlassian.extras.api.LicenseException
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
