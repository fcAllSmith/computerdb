package com.excilys.formation.fconsigny.computerdb.app.ui;

import java.io.IOException;
import java.util.List;

import com.excilys.formation.fconsigny.computerdb.app.AppView;
import com.excilys.formation.fconsigny.computerdb.app.IApp;
import com.excilys.formation.fconsigny.computerdb.app.controller.CompanyController;
import com.excilys.formation.fconsigny.computerdb.app.entity.CompanyEntity;

/**
 *  Call the CompanyController and use its methods
 * @author franc
 *
 */
public class UIViewCompany extends AppView implements IApp{

	AppView appParentView ;
	private static CompanyController companyController;

	@Override
	public void CreateView(AppView appParentView) {
		// TODO Auto-generated method stub*
		if(this.appParentView == null && companyController == null){
			this.appParentView = appParentView ;
			UIViewCompany.companyController = new CompanyController();
		}
		
		
		RefreshUi();
	}

	@Override
	public void RefreshUi() {
		// TODO Auto-generated method stub
		showText("------- Menu -------");
		showText("1 - Show list of companies") ;
		showText("2 - Show a company with an ID");
		String str_input;

		try {
			str_input = readInputText();
			onInputKey(str_input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void DestroyView() {
		UIViewCompany.companyController = null;
		((IApp) appParentView).RefreshUi();
	}

	public void onInputKey(String str_input) throws IOException{
		try{
			int cmd = Integer.parseInt(str_input);
			switch(cmd){
			case 1 : 
				loadListCompany();
				break;
			case 2:
				showText("Company id : "); 
				String str_companId = readInputText();
				loadCompanyById(Integer.parseInt(str_companId));
				break;
			default : 
				DestroyView();
				break;
			}
		}catch(NumberFormatException err){
			showText("This input cannot be used. Use numbers instead :" + err);
		}
	}
	
	/**
	 * 
	 * @param id
	 */
	private void loadCompanyById(int id){
		CompanyEntity ce = UIViewCompany.companyController.loadCompany(id);		
		if(ce != null){
			showText(ce.toString());
		}else{
			showText("No data");
		}
	}
	
	private void loadListCompany(){
		List<CompanyEntity> lCompanies = UIViewCompany.companyController.loadCompanies();
		for(CompanyEntity company : lCompanies){
			showText(company.toString());
		}
	}
}
