package com.taxapp.bo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.taxapp.common.CommonConstants;
import com.taxapp.dto.TaxDetailDTO;
import com.taxapp.exception.ApplicationException;

public class TaxAppBOImpl implements TaxAppBO {

	private Logger log = Logger.getLogger(TaxAppBOImpl.class);
	
	@Override
	public Boolean createXML(TaxDetailDTO pojo) throws ApplicationException {
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            
            Element rootElement = doc.createElement(CommonConstants.ROOTELEMENT);
    		doc.appendChild(rootElement);
    		
    		// staff elements
    		Element application = doc.createElement(CommonConstants.APPELEMENT);
    		rootElement.appendChild(application);

    		
    		// name elements
    		Element x_name = doc.createElement(CommonConstants.NAME);
    		x_name.appendChild(doc.createTextNode(pojo.getName()));
    		application.appendChild(x_name);

    		// name elements
    		Element x_address = doc.createElement(CommonConstants.ADDRESS);
    		x_address.appendChild(doc.createTextNode(pojo.getAddress()));
    		application.appendChild(x_address);
    		
    		// name elements
    		Element x_pan = doc.createElement(CommonConstants.PAN);
    		x_pan.appendChild(doc.createTextNode(pojo.getPan()));
    		application.appendChild(x_pan);
    		
    		// name elements
    		Element x_dob = doc.createElement(CommonConstants.DATEOFBIRTH);
    		x_dob.appendChild(doc.createTextNode(pojo.getDob()));
    		application.appendChild(x_dob);
    		
    		// name elements
    		Element x_assess_year = doc.createElement(CommonConstants.ASSESSYEAR);
    		x_assess_year.appendChild(doc.createTextNode(pojo.getAssess_year()));
    		application.appendChild(x_assess_year);
    		
    		// name elements
    		Element x_income = doc.createElement(CommonConstants.INCOME);
    		x_income.appendChild(doc.createTextNode(pojo.getIncome()));
    		application.appendChild(x_income);
    		
    		// name elements
    		Element x_tds = doc.createElement(CommonConstants.TDS);
    		x_tds.appendChild(doc.createTextNode(pojo.getTds()));
    		application.appendChild(x_tds);
    		
    		// name elements
    		Element x_tax_deduct = doc.createElement(CommonConstants.TAXDEDUCT);
    		x_tax_deduct.appendChild(doc.createTextNode(pojo.getTax_deduct()));
    		application.appendChild(x_tax_deduct);
    		
 
            // output DOM XML to console 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
           // File file = new File("D:\\"+pan+"_"+assess_year+".xml");
            //boolean b = file.createNewFile();
            StreamResult file = new StreamResult(new File(CommonConstants.SOURCEFOLDER+pojo.getPan()+CommonConstants.UNDERSCORE+pojo.getAssess_year()+CommonConstants.FILEEXTENSION));
            transformer.transform(source, console);
            transformer.transform(source, file);
 
            
            return true;
        } catch(ParserConfigurationException e) {
        	log.fatal("ParserConfigurationException occured");
        	throw new ApplicationException(e.getMessage(), e.getCause());
        } catch(TransformerConfigurationException e) {
        	log.fatal("TransformerConfigurationException occured");
        	throw new ApplicationException(e.getMessage(), e.getCause());
        } catch(TransformerException e) {
        	log.fatal("TransformerException occured");
        	throw new ApplicationException(e.getMessage(), e.getCause());
        } catch(Exception e) {
        	log.fatal("other Exception occured");
        	throw new ApplicationException(e.getMessage(), e.getCause());
        }

	}

}
