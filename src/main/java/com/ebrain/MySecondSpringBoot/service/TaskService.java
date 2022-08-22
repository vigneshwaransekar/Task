package com.ebrain.MySecondSpringBoot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebrain.MySecondSpringBoot.entity.Task;
import com.ebrain.MySecondSpringBoot.enumeration.TaskPriority;
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

	public void deleteTask(Integer taskId) {
		taskRepository.deleteById(taskId);
	}

	public Optional<Task> findById(Integer taskId) {
		return taskRepository.findById(taskId);
	}

	public List<Task> findByStatus(TaskStatus status) {

		return taskRepository.findByStatus(status);
	}

	public List<Task> findByPriority(TaskPriority priority) {
		return taskRepository.findByPriority(priority);
	}

	public List<Task> findByDueDate(String dueDate) {
		return taskRepository.findByDueDate(dueDate);
	}

	public List<Task> findByDueDate(Task task) {
		return taskRepository.findByDueDate(task);
	}

}
