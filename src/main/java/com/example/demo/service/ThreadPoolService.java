package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class ThreadPoolService {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public void setTask(Runnable task){
        executor.submit(task);
    }
}
