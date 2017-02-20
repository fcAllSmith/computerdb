package com.excilys.formation.fconsigny.computerdb.storage.dao;

import java.util.List;

public interface IDao <T> {

	public T[] getItems();
	public T getItemById(int id);

}
