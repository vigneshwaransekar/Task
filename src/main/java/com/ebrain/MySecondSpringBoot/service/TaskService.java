package com.ebrain.MySecondSpringBoot.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebrain.MySecondSpringBoot.entity.Task;
import com.ebrain.MySecondSpringBoot.enumeration.TaskStatus;
import com.ebrain.MySecondSpringBoot.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public void save(Task obj) {
		taskRepository.save(obj);
	}

	public Iterable<Task> findAll() {

		return taskRepository.findAll();

	}

	public Task update(Task obj) {
		return taskRepository.save(obj);
	}
	
	public void deleteTask(Integer taskId)
	{
		taskRepository.deleteById(taskId);
	}

	public Optional<Task> findById(Integer taskId) {
		return taskRepository.findById(taskId);
	}
//	public Optional<Task> findByTodayTask(Date dueDate) {
//		return taskRepository.findByTodayTask(dueDate);
//	}

	public List<Task> findByStatus(TaskStatus open) {
		// TODO Auto-generated method stub
		return taskRepository.findByStatus(open) ;
	}

}