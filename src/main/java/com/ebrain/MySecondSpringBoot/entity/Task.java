package com.ebrain.MySecondSpringBoot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ebrain.MySecondSpringBoot.enumeration.TaskPriority;
import com.ebrain.MySecondSpringBoot.enumeration.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "task")

public class Task {

	@Id
	@Column(name = "task_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;

	@Column(name = "task_name")
	private String taskName;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "due_date")
	private Date dueDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "start_date")
	private Date startDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TaskStatus status;

	@Enumerated(EnumType.STRING)
	@Column(name = "priority")
	private TaskPriority priority;

}
