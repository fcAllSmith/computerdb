package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.util.List;

/**
 * 
 * @author excilys
 *
 * @param <T>
 */
public interface IDao <T> {
	public List<T> getItems();
	public T getItemById(int id);
	public boolean deleteItemById(int id);
	public boolean updateItem(T object);
}
