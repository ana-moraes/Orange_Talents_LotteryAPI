package com.orangetalents.lotteryAPI.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import com.orangetalents.lotteryAPI.ticket.LotteryTicket;

@Entity
public class Lottery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;

	private String ticket = new LotteryTicket().GenerateTicket();
	
	@CreationTimestamp
	private Instant creationDate;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Métodos get e set
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lottery other = (Lottery) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTicket() {
		return ticket;
	}

	public String getCreationDate() {
		String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
			    .withZone(ZoneId.of("America/Sao_Paulo"))
			    .format(creationDate);		
		return formattedDate;
	}
}