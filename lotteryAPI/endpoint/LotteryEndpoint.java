package com.orangetalents.lotteryAPI.endpoint;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orangetalents.lotteryAPI.model.Lottery;
import com.orangetalents.lotteryAPI.repository.LotteryRepository;

@RestController
@RequestMapping("lotteries")
public class LotteryEndpoint {

	private final LotteryRepository lotteryDAO;

	@Autowired
	public LotteryEndpoint(LotteryRepository lotteryDAO) {
		this.lotteryDAO = lotteryDAO;
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Lottery lottery) {
		return new ResponseEntity<>(lotteryDAO.save(lottery), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(lotteryDAO.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getLotteryById(@PathVariable("id") Long id) {
		Optional<Lottery> lottery = lotteryDAO.findById(id);
		if (lottery == null) {
			return new ResponseEntity<>("Lottery not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(lottery, HttpStatus.OK);
	}
	
	@GetMapping(path = "/find/{email}")
	public ResponseEntity<?> getLotteryByEmail(@PathVariable String email) {
		return new ResponseEntity<>(lotteryDAO.findByEmailIgnoreCaseContaining(email), HttpStatus.OK);
	}
}