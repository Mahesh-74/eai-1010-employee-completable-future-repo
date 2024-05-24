package com.krishna.prabha.mahe.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.krishna.prabha.mahe.entity.Employee;
import com.krishna.prabha.mahe.repo.EmployeeDatabase;

public class EmployeeSupplyAync {
	
	public List<Employee> employeeSupplyAync() throws InterruptedException, ExecutionException{
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		CompletableFuture<List<Employee>> employeeAsync = CompletableFuture.supplyAsync(()->{
			return EmployeeDatabase.fetchEmployees();
		}, newFixedThreadPool);
		return employeeAsync.get();
	}

}
