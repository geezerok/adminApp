package com.geezer.adminapp.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.geezer.adminapp.orm.Stock;

public interface StockDAO {
	
	public void addStock(Stock stock) throws SQLException;

	public void updateStock(Long stock_id, Stock stock) throws SQLException;

	public Stock getStockById(Long stock_id) throws SQLException;
	
	

	public Collection<Stock> getAllStocks() throws SQLException;
		
	public void deleteStock(Stock stock) throws SQLException;

}
