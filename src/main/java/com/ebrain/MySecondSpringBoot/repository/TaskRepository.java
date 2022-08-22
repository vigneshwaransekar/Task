package com.ebrain.MySecondSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ebrain.MySecondSpringBoot.configure.WriteableRepository;
import com.ebrain.MySecondSpringBoot.entity.Task;
import com.ebrain.MySecondSpringBoot.enumeration.TaskPriority;
import com.ebrain.MySecondSpringBoot.enumeration.TaskStatus;

public interface TaskRepository extends WriteableRepository<Task, Integer> {

	List<Task> findByStatus(TaskStatus status);

	List<Task> findByPriority(TaskPriority priority);

	@Query(value = "SELECT t.task_id,t.due_date,t.task_name,t.start_date,t.priority,t.status  FROM vikkidb.task t where t.due_date= :dueDate", nativeQuery = true)
	List<Task> findByDueDate(String dueDate);

	List<Task> findByDueDate(Task task);

}
