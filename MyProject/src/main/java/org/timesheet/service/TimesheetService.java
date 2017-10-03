package org.timesheet.service;

import java.util.List;

import org.timesheet.domain.Employee;
import org.timesheet.domain.Manager;
import org.timesheet.domain.Task;

public interface TimesheetService {

	List<Task> tasksForEmployee(Employee employee);

	Task busiestTask();

	List<Task> tasksForManager(Manager manager);

}
