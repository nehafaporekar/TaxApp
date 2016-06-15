package com.taxapp.bo;

import com.taxapp.dto.TaxDetailDTO;
import com.taxapp.exception.ApplicationException;

public interface TaxAppBO {

	Boolean createXML(TaxDetailDTO pojo) throws ApplicationException;

}
