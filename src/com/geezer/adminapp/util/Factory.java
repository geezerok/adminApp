package com.geezer.adminapp.util;



import com.geezer.adminapp.DAO.AssembleDAO;
import com.geezer.adminapp.DAO.ComputerDAO;
import com.geezer.adminapp.DAO.ComputerTypeDAO;
import com.geezer.adminapp.DAO.DepartmentDAO;
import com.geezer.adminapp.DAO.LoginDAO;
import com.geezer.adminapp.DAO.PartDAO;
import com.geezer.adminapp.DAO.PartTypeDAO;
import com.geezer.adminapp.DAO.StockDAO;
import com.geezer.adminapp.DAO.UserDAO;
import com.geezer.adminapp.DAO.Impl.AssembleDAOImpl;
import com.geezer.adminapp.DAO.Impl.ComputerDAOImpl;
import com.geezer.adminapp.DAO.Impl.ComputerTypeDAOImpl;
import com.geezer.adminapp.DAO.Impl.DepartmentDAOImpl;
import com.geezer.adminapp.DAO.Impl.LoginDAOImpl;
import com.geezer.adminapp.DAO.Impl.PartDAOImpl;
import com.geezer.adminapp.DAO.Impl.PartTypeDAOImpl;
import com.geezer.adminapp.DAO.Impl.StockDAOImpl;
import com.geezer.adminapp.DAO.Impl.UserDAOImpl;

public class Factory {
	
	 private static AssembleDAO assembleDAO = null;
	  private static ComputerDAO computerDAO = null;
	  private static ComputerTypeDAO computerTypeDAO = null;
	  private static DepartmentDAO departmentDAO = null;
	  private static LoginDAO loginDAO = null;
	  private static PartDAO partDAO = null;
	  private static PartTypeDAO partTypeDAO = null;
	  private static StockDAO stockDAO = null;
	  private static UserDAO userDAo = null;
	  private static Factory instance = null;

	  public static synchronized Factory getInstance(){
	    if (instance == null){
	      instance = new Factory();
	    }
	    return instance;
	  }

	  public UserDAO getUserDAO(){
		    if (userDAo == null){
		      userDAo = new UserDAOImpl();
		    }
		    return userDAo;
		  }
	  
	  public StockDAO getStockDAO(){
		    if (stockDAO == null){
		      stockDAO = new StockDAOImpl();
		    }
		    return stockDAO;
		  }
	  
	  public PartTypeDAO getPartTypeDAO(){
		    if (partTypeDAO == null){
		      partTypeDAO = new PartTypeDAOImpl();
		    }
		    return partTypeDAO;
		  }
	  
	  public PartDAO getPartDAO(){
		    if (partDAO == null){
		      partDAO = new PartDAOImpl();
		    }
		    return partDAO;
		  }
	  
	  public LoginDAO getLoginDAO(){
		    if (loginDAO == null){
		      loginDAO = new LoginDAOImpl();
		    }
		    return loginDAO;
		  }
	  
	  public DepartmentDAO getDepartmentDAO(){
		    if (departmentDAO == null){
		      departmentDAO = new DepartmentDAOImpl();
		    }
		    return departmentDAO;
		  }
	  
	  public AssembleDAO getAssembleDAO(){
	    if (assembleDAO == null){
	      assembleDAO = new AssembleDAOImpl();
	    }
	    return assembleDAO;
	  }

	  public ComputerDAO getComputerDAO(){
	    if (computerDAO == null){
	      computerDAO = new ComputerDAOImpl();
	    }
	    return computerDAO;
	  }

	   public ComputerTypeDAO getComputerTypeDAO(){
	    if (computerTypeDAO == null){
	      computerTypeDAO = new ComputerTypeDAOImpl();
	    }
	    return computerTypeDAO;
	  }

}
