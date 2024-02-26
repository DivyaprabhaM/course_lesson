package com.example.controller;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TransactionDetails;
//import com.example.service.TransactionService;
import com.example.service.TransactionServiceImpl;
//@Configuration
@RestController
public class TransactionController {
	
	TransactionServiceImpl transactionSerive=new TransactionServiceImpl();
	
	@GetMapping("/transactions/getAllDetails")
	public ResponseEntity<List<TransactionDetails>>getAllDetails(@RequestParam String category ) {
		 //String category="";
		List<TransactionDetails> transactionList = transactionSerive.getAllDetails(category);
        return new ResponseEntity<List<TransactionDetails>>(transactionList,HttpStatus.OK);
           
       }
	@GetMapping("/transactions/getTotalOutgoing")
	public ResponseEntity<List<TransactionDetails>> getTotalOutgoing() {
		List<TransactionDetails> totalOutgoing = transactionSerive.getTotalOutgoing();
        return new ResponseEntity<List<TransactionDetails>>(totalOutgoing,HttpStatus.OK);
           
       }
	@GetMapping("/transactions/getMonthlyAverage")
	public ResponseEntity<Map<String,String>> getMonthlyAverage(@RequestParam String category ) {
		Map<String,String> monthlyAverage = transactionSerive.getMonthlyAverage(category);
        return new ResponseEntity<Map<String,String>>(monthlyAverage,HttpStatus.OK);
           
       }
	@GetMapping("/transactions/getMaxSpend")
	public ResponseEntity<String> getMaxSpend(@RequestParam String category,String year ) {
		String maxSpend = transactionSerive.getMaxSpend(category,year);
        return new ResponseEntity<String>(maxSpend,HttpStatus.OK);
           
       }
	@GetMapping("/transactions/getMinSpend")
	public ResponseEntity<String> getMinSpend(@RequestParam String category,String year  ) {
		String minSpend = transactionSerive.getMinSpend(category,year);
        return new ResponseEntity<String>(minSpend,HttpStatus.OK);
           
       }
}
