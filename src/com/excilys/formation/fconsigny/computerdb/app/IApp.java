package com.excilys.formation.fconsigny.computerdb.app;

/**
 * Contract describes method need to the UIViews 
 * @author franc
 *
 */
public interface IApp {

	public void CreateView(AppView appParentView);
	public void RefreshUi();
	public void DestroyView();
}
