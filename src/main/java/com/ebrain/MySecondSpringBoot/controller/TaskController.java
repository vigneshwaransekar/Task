package com.ebrain.MySecondSpringBoot.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ebrain.MySecondSpringBoot.entity.Task;
import com.ebrain.MySecondSpringBoot.enumeration.TaskStatus;
import com.ebrain.MySecondSpringBoot.service.TaskService;

@RestController
@RequestMapping("api/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@PostMapping("/create")
	public String create(@RequestBody Task request) {

		Task taskObject = new Task();
		taskObject.setTaskName(request.getTaskName());
		taskObject.setDueDate(request.getDueDate());
		taskObject.setStartDate(request.getStartDate());
		taskObject.setPriority(request.getPriority());
		taskObject.setPriority(request.getPriority());
		taskObject.setStatus(request.getStatus());
		taskService.save(taskObject);

		return "Created successfully";

	}

	@GetMapping("/get")
	public Iterable<Task> get() {

		return taskService.findAll();

	}

	@PutMapping("/update")
	public Task update(@RequestBody Task request) {

		return taskService.update(request);

	}

	@DeleteMapping("/delete/{taskId}")
	public void deleteTask(@PathVariable("taskId") Integer taskId) {
		taskService.deleteTask(taskId);

	}

	@GetMapping("/get/{taskId}")
	public Task getTask(@PathVariable("taskId") Integer taskId) {
		Optional<Task> task = taskService.findById(taskId);
		return task.get();
	}
	

	@GetMapping("/get/{status}")
	public void getTaskStatus(@PathVariable("status") TaskStatus status,@RequestBody Task request) {
		List<Task> statusList = taskService
				.findByStatus(TaskStatus.open);
	
	}
	
	
	

//	@GetMapping("/get/{dueDate}")
//	public Task getTodayTask(@PathVariable("dueDate") Date dueDate) {
//		Optional<Task> task = taskService.findByTodayTask(dueDate);
//		return task.get();
//	}
}
