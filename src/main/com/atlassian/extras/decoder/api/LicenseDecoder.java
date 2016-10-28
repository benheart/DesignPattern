package com.atlassian.extras.decoder.api;

import java.util.Properties;

public abstract interface LicenseDecoder
{
    public abstract Properties decode(String paramString);

    public abstract boolean canDecode(String paramString);
}
