package com.company.web.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("blacklistDao")
public class BlacklistDAOImpl implements BlacklistDAO<String> {

    List<String> blacklistRepo;


    public BlacklistDAOImpl() {
        blacklistRepo = new ArrayList<>();
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
        String ip = blacklistRepo.stream()
                .filter(ipInList -> ipToFind.equals(ipInList))
                .findAny()
                .orElse(null);
        return ip;
    }

    @Override
    public boolean delete(String ipToRemove) {
        List<String> toBeRemoved = new ArrayList<>();
        blacklistRepo.forEach(ip -> {
            if(ipToRemove.equals(ip)){
                toBeRemoved.add(ip);
            }
        });

        return  blacklistRepo.removeAll(toBeRemoved);
    }

    @Override
    public List<String> findAll(){
        return blacklistRepo;
    }
}
