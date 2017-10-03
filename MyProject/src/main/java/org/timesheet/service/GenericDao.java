package org.timesheet.service;

import java.util.List;

import org.timesheet.domain.Employee;

public interface GenericDao<E, K> {

	void update(E entity);

	void add(E entity);

	void remove(E entity);

	List<E> list();

	Employee preparedst(K key);

	E find(K key);

	E load(K key);



}
