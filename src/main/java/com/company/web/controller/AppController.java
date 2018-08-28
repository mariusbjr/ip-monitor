package com.company.web.controller;

import com.company.web.dao.BlacklistDAO;
import com.company.web.filter.BlacklistFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Application controller that handle HTTP requests for different ips. Another approach can be to use an object with
 * more properties instead of a simple String,
 * or we can read the ip from the HttpServletRequest object.
 */
@Controller
@RequestMapping("/blacklist")
public class AppController {

    @Autowired
    private BlacklistFilter blacklistFilter;
    @Autowired
    private BlacklistDAO<String> blacklistDao;


    @GetMapping("/check/{ip}")
    @ResponseBody
    public String checkIp(@PathVariable("ip") String ip) {
        if(blacklistFilter.ipInBlacklist(ip)){
            return "Ip blacklisted!";
        }else {
            return "Clean IP, proceed with the workflow!";
        }
    }

    @RequestMapping(value = "/add/{ip}", method = RequestMethod.POST)
    @ResponseBody
    public String addIp(@PathVariable("ip") String ip) {
        blacklistDao.add(ip);
       return "Ip added to blacklist!";
    }

    @DeleteMapping("/remove/{ip}")
    @ResponseBody
    public String removeIp(@PathVariable("ip") String ip) {
        if(blacklistDao.delete(ip)){
            return "Ip " + ip + " removed from the blacklist";
        }else {
            return "Can't find the ip " + ip + " in the blacklist";
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity findAll() {
        List<String> all = blacklistDao.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }


}
