package com.orangetalents.lotteryAPI.ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LotteryTicket {

	Random random = new Random();

	public String GenerateTicket() {

		List<Integer> lotteryNumbers = new ArrayList<Integer>(60);
		for (int i = 1; i <= 60; i++)
			lotteryNumbers.add(i);

		int[] ticket = new int[6];

		for (int i = 0; i < 6; i++) {
			Collections.shuffle(lotteryNumbers);
			int index = random.nextInt(lotteryNumbers.size());
			ticket[i] = (int) lotteryNumbers.remove(index);
		}
		return Arrays.toString(ticket).replace("[", "").replace("]", "");
	}
}