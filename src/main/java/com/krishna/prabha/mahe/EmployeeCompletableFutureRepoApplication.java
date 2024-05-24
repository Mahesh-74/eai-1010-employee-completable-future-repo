package com.krishna.prabha.mahe;

import java.io.File;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.krishna.prabha.mahe.service.RunAsyncDemo;

@SpringBootApplication
public class EmployeeCompletableFutureRepoApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
		runAsyncDemo.saveEmployees(new File("src\\main\\resources\\employees.json"));
		runAsyncDemo.saveEmployeesWithCustomExecutor(new File("src\\main\\resources\\employees.json"));
		SpringApplication.run(EmployeeCompletableFutureRepoApplication.class, args);
	}

}
