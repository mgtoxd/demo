package com.example.demo;

import com.example.demo.service.ThreadPoolService;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class CaffineCaheTest {




    private ThreadPoolService threadPoolService;


    
    private static Cache<String,String> cache = Caffeine.newBuilder()
            .expireAfterWrite(20, TimeUnit.SECONDS)
            .maximumSize(5000)
            .build();


    public CaffineCaheTest() {

    }

    @Test
    public void cacheConcurrencyTest() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threadPoolService.setTask(()->{
//                cache.get("id",e->{
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                    System.out.println("id"+ finalI);
//                    return String.valueOf(finalI);
//                });

//                System.out.println("id"+ finalI);
//                cache.put("id", String.valueOf(finalI));
            });

        }
        Thread.sleep(2000);
        System.out.println(cache.getIfPresent("id"));

    }

    @Autowired
    public void setThreadPoolService(ThreadPoolService threadPoolService) {
        this.threadPoolService = threadPoolService;
    }
}
