package com.orangetalents.lotteryAPI.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.orangetalents.lotteryAPI.model.Lottery;

@Repository
public interface LotteryRepository extends CrudRepository<Lottery, Long>{
	List<Lottery> findByEmailIgnoreCaseContaining(String email);
}