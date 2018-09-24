package com.company.web.dao;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("blacklistDao")
public class BlacklistDAOImpl implements BlacklistDAO<String> {

    Set<String> blacklistRepo;

    public BlacklistDAOImpl() {
        blacklistRepo = new HashSet<>();
        blacklistRepo.add("111.32.4.5");
        blacklistRepo.add("222.22.43.5");
        blacklistRepo.add("193.12.0.1");
    }

    @Override
    public void add(String ip) {
        blacklistRepo.add(ip);
    }

    @Override
    public String get(String ipToFind) {
        if(blacklistRepo.contains(ipToFind)) return ipToFind;
        return null;
    }

    @Override
    public boolean delete(String ipToRemove) {
        return blacklistRepo.remove(ipToRemove);
    }

    @Override
    public Set<String> findAll(){
        return blacklistRepo;
    }
}
