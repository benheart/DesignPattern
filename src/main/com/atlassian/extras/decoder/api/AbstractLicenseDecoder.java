package com.atlassian.extras.decoder.api;

import java.util.Properties;

import com.atlassian.extras.common.LicenseException;

public abstract class AbstractLicenseDecoder implements LicenseDecoder
{
    public final Properties decode(String licenseString)
    {
        Properties licenseProperties = doDecode(licenseString);
        if (licenseProperties == null) {
            throw new LicenseException("Invalid License - an error occurred when decoding the license");
        }
        licenseProperties.setProperty("licenseVersion", String.valueOf(getLicenseVersion()));
        return licenseProperties;
    }

    protected abstract Properties doDecode(String paramString);

    protected abstract int getLicenseVersion();
}
