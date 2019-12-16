package com.example.demo.util;

import com.example.demo.entity.AssociateInfo;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(AssociateInfo associateInfo){
		if (associateInfo.getAssociateId()> 0){
			return false;
		}
		return true;
	}

}
