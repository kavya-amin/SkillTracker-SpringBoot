package com.example.demo.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.example.demo.entity.AssociateInfo;

public class PayloadValidatorTest {

	@Test
	public void validatePayLoad() {
		AssociateInfo associateInfo = new AssociateInfo(1, "Divya", "Amin", "divya@gmail.com", "1234", 9887677898L,
				"29-01-2002", "female", "bangalore", "india");
		assertEquals(false, PayloadValidator.validateCreatePayload(associateInfo));
	}

	@Test
	public void validateInvalidPayLoad() {
		AssociateInfo associateInfo = new AssociateInfo(0, "Divya", "Amin", "divya@gmail.com", "1234", 9887677898L,
				"29-01-2002", "female", "bangalore", "india");
		assertEquals(true, PayloadValidator.validateCreatePayload(associateInfo));
	}

}