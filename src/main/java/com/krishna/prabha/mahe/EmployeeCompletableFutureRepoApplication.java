package com.krishna.prabha.mahe;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.krishna.prabha.mahe.entity.Employee;
import com.krishna.prabha.mahe.service.EmployeeReminderService;
import com.krishna.prabha.mahe.service.EmployeeSupplyAync;
import com.krishna.prabha.mahe.service.RunAsyncDemo;

@SpringBootApplication
public class EmployeeCompletableFutureRepoApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
		runAsyncDemo.saveEmployees(new File("src\\main\\resources\\employees.json"));
		runAsyncDemo.saveEmployeesWithCustomExecutor(new File("src\\main\\resources\\employees.json"));
		
		EmployeeSupplyAync employeeSupplyAync = new EmployeeSupplyAync();
		List<Employee> employeeSupplyAync2 = employeeSupplyAync.employeeSupplyAync();
		employeeSupplyAync2.stream().forEach(System.out::println);
		
		EmployeeReminderService service = new EmployeeReminderService();
		service.sendReminderToEmployee().get();
		
		SpringApplication.run(EmployeeCompletableFutureRepoApplication.class, args);
	}

}
