package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.entity.AssociateInfo;
import com.example.demo.repository.AssociateInfoRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class SkillServiceTest {
	
	@Mock
	private AssociateInfoRepository associateInfoRepository;
	
	@InjectMocks
	private SkillsService service;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllAssociate(){
		List<AssociateInfo> associateList = new ArrayList<AssociateInfo>();
		associateList.add(new AssociateInfo(1, "Divya", "Amin", "divya@gmail.com", "1234", 9887677898L,
				"29-01-2002", "female", "bangalore", "india"));
		when(associateInfoRepository.findAll()).thenReturn(associateList);
		
		List<AssociateInfo> result = (List<AssociateInfo>) service.getAllAssociates();
		assertEquals(8, result.size());
	}
	
	@Test
	public void testGetAssociateById(){
		AssociateInfo associateInfo = new AssociateInfo(8, "Divya", "Amin", "divya@gmail.com", "1234", 9887677898L,
				"29-01-2002", "female", "bangalore", "india");
		when(associateInfoRepository.findById(8)).thenReturn(associateInfo);
		AssociateInfo result = service.findByUserId(1);
		assertEquals(1, result.getAssociateId());
		assertEquals("Bhavana", result.getAssociateFirstName());
		assertEquals("Shetty", result.getAssociateLastName());
		assertEquals("bhavanabs3@gmail.com", result.getAssociateEmail());
	}
	
	@Test
	public void saveToDo(){
		AssociateInfo associateInfo = new AssociateInfo(9, "Divya", "Amin", "divyaamin@gmail.com", "1234", 9887677898L,
				"29-01-2002", "female", "bangalore", "india");
		when(associateInfoRepository.save(associateInfo)).thenReturn(associateInfo);
		AssociateInfo result = service.saveAssociate(associateInfo);
		assertEquals(9, result.getAssociateId());
		assertEquals("Divya", result.getAssociateFirstName());
		assertEquals("Amin", result.getAssociateLastName());
		assertEquals("divyaamin@gmail.com", result.getAssociateEmail());
	}
	
	
	

}

