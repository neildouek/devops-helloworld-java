package com.example;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@ManagedResource(objectName="com.example:name=CounterService", description="Simple request counter")
public class CounterService {

    private final AtomicLong counter = new AtomicLong(0);

    public void increment() {
        counter.incrementAndGet();
    }

    @ManagedAttribute(description="Current count")
    public long getCount() {
        return counter.get();
    }
}