package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.PaymentDto;
import com.example.Hostel.entity.Payment;

public interface PayementService {
	
	
	public void savePayment(PaymentDto dto);
	
	public Payment getPayment(int id);
	
	public List<Payment> getPayments();
	
	
}
