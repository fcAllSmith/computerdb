package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.util.List;

/**
 *  Contract of DAO classes
 * @author excilys
 *
 * @param <T>
 */
public interface IDao <T> {
	public List<T> getItems();
	public T getItemById(int id);
}
