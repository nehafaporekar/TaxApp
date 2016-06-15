package com.taxapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.taxapp.dto.TaxDetailDTO;
import com.taxapp.exception.ApplicationException;

public class ValidationUtil {

	private static Logger log = Logger.getLogger(ValidationUtil.class);

	public static boolean checkBlanks(TaxDetailDTO p) throws ApplicationException {
		if (p.getAddress() != " " || p.getAssess_year() != " " || p.getDob() != " " || p.getIncome() != " "
				|| p.getName() != " " || p.getPan() != " " || p.getTax_deduct() != " " || p.getTds() != "") {
			checkNumber(p);
			isValidDate(p.getDob());
			return true;
		} else
			return false;

	}

	private static void isValidDate(String dob) throws ApplicationException {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);

		try {
			dateFormat.parse(dob.trim());
		} catch (ParseException e) {
			log.fatal("ParseException occured");
			throw new ApplicationException(e.getMessage(), e.getCause());
		}

	}

	private static void checkNumber(TaxDetailDTO p) throws ApplicationException {
		try {
			Integer.parseInt(p.getIncome());
			Integer.parseInt(p.getTax_deduct());
			Integer.parseInt(p.getTds());
		} 	catch (NumberFormatException e) {
			log.fatal("NumberFormatException occured");
			throw new ApplicationException(e.getMessage(), e.getCause());
		} 
	}
}
