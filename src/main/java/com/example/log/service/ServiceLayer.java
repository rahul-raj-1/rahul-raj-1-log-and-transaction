package com.example.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.log.RepositoryOne;
import com.example.log.RepositoryTwo;
import com.example.log.exception.FirstInsertException;

@Service
public class ServiceLayer {

	@Autowired
	private RepositoryOne repositoryOne;
	@Autowired
	private RepositoryTwo repositoryTwo;
	
	@Autowired
	private PlatformTransactionManager transactionManage;


	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {FirstInsertException.class})
	public void call(String id) {
		
		System.out.println(" transactionManage  ---  " + transactionManage);
		

		try {

			repositoryOne.insertFirstNewTrans(id);

		} catch (FirstInsertException e) {

			System.err.println("FirstInsertException : " );

		}
		
		String status = "0";
		if (status.equals("1")) {
			
			repositoryTwo.insertSecondNewTrans(id);


			throw new FirstInsertException("FirstInsertException : rollback first exception !");

		}


		repositoryTwo.insertSecondNewTrans(id);
		
		System.out.println("End call  --------------  ---- ");


	}
}
