package com.aop.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficServiceImpl implements TrafficService {

    @Override
    public String getStatusTraffic() {

        // simulate a delay

        try {
            TimeUnit.SECONDS.sleep(5); // get input secound time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Expect heavy traffic this morning";
    }
    
}
