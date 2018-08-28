package com.company.web.filter;

import com.company.web.dao.BlacklistDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlacklistFilter {

    @Autowired
    private BlacklistDAO<String> blacklistDao;

    public boolean ipInBlacklist(String ip) {
        if (blacklistDao.get(ip) != null) return true;
        return false;
    }
}
