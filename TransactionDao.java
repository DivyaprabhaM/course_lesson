package com.example.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.TransactionDetails;
//@Component
public interface TransactionDao {

	public List<TransactionDetails> getAllDetails(String category);

	public List<TransactionDetails> getTotalOutgoing();

	public double getMinSpend(String category,String year);

	public double getMaxSpend(String category,String year);

	public Map<String,String> getMonthlyAverage(String category);

}
