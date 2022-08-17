package com.ebrain.MySecondSpringBoot.repository;




import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ebrain.MySecondSpringBoot.configure.WriteableRepository;
import com.ebrain.MySecondSpringBoot.entity.Task;
import com.ebrain.MySecondSpringBoot.enumeration.TaskStatus;


public interface TaskRepository extends  WriteableRepository<Task, Integer>  {

	List<Task> findByStatus(TaskStatus open);

//	Optional<Task> findByTodayTask(Date dueDate);

	

}
