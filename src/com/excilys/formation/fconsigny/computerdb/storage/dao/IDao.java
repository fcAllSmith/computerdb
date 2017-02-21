package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.util.List;

public interface IDao <T> {

	public List<T> getItems();
	public T getItemById(int id);

}
