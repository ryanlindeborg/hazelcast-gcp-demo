package com.example.demo;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // Hazelcast Getting Started Code
            Config cfg = new Config();
            HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
            Map<Integer, String> mapCustomers = instance.getMap("customers");
            mapCustomers.put(1, "Joe");
            mapCustomers.put(2, "Ali");
            mapCustomers.put(3, "Avi");

            System.out.println("Customer with key 1: "+ mapCustomers.get(1));
            System.out.println("Map Size:" + mapCustomers.size());

            // Blog Post Starting Code
//            final Set<HazelcastInstance> allHazelcastInstances = Hazelcast.getAllHazelcastInstances();
//            final HazelcastInstance hazelcastInstance = (HazelcastInstance)allHazelcastInstances.toArray()[0];
//            final IMap<String, Integer> map = hazelcastInstance.getMap("example-map");
//            map.put("one", 1);
//            map.put("two", 2);
//            map.put("three", 3);
//            map.put("four", 4);
//            map.put("five", 5);
        };
    }

}
