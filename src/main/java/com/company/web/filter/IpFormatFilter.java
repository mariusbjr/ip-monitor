package com.company.web.filter;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class IpFormatFilter {

    public boolean isFormatOk(String ip) {
        return Pattern.matches("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", ip);
    }
}
