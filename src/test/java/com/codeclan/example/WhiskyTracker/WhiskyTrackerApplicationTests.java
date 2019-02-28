package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  canFindWhiskyByYear(){
		List<Whisky> found = whiskyRepository.getWhiskyByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.getDistilleryByRegion("Speyside");
		assertEquals(2, found.size());
	}

	@Test
	public void findWhiskeyByRegion(){
		List<Whisky> found  = whiskyRepository.findWhiskyByRegion("Speyside");
//		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleriesForWhiskiesAged(){
		List<Distillery> found = distilleryRepository.getDistilleriesForWhiskiesAged(12);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetAllWhiskiesFromDistilleryAged(){
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryIdAndAge(1L, 15);
		assertEquals(1, found.size());
	}

}
