package com.app.estore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.estore.model.WaffleOrder;

public interface WaffleOrderRepository extends CrudRepository<WaffleOrder, Long>{
	WaffleOrder findByOrderId(Long OrderId);
}
