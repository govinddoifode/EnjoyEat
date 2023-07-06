package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Branch;
import com.app.repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	private BranchRepository branchRepo;

	public Optional<Branch> getById(Integer id)
	{
		return branchRepo.findById(id);
	}

	public List<Branch> viewBranches()
	{
		return branchRepo.viewBranches();	
	}

	public List<Branch> getBranchOrders()
	{
		return branchRepo.getBranchOrders();
	}


}

