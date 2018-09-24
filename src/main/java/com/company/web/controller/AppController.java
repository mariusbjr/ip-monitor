package com.company.web.controller;

import com.company.web.dao.BlacklistDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * API entry point.
 * @RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
 */
@RestController
@RequestMapping("/blacklist")
public class AppController {
    @Autowired
    private BlacklistDAO<String> blacklistDao;


    @GetMapping("/ip/{ip}")
    public String get(@PathVariable("ip") String ip) {
        if (blacklistDao.get(ip) != null) {
            return "Ip blacklisted!";
        } else {
            return "Clean IP, proceed with the workflow!";
        }
    }

    @RequestMapping(value = "/ip", method = RequestMethod.POST)
    public String add(@PathVariable("ip") String ip) {
        blacklistDao.add(ip);
        return "Ip added to blacklist!";
    }

    @DeleteMapping("/ip/{ip}")
    public String remove(@PathVariable("ip") String ip) {
        if (blacklistDao.delete(ip)) {
            return "Ip " + ip + " removed from the blacklist";
        } else {
            return "Can't find the ip " + ip + " in the blacklist";
        }
    }

    @RequestMapping(value = "/ips", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> findAll() {
        return blacklistDao.findAll();
    }

}
