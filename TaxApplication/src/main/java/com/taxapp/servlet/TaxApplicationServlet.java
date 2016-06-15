package com.taxapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.taxapp.bo.TaxAppBO;
import com.taxapp.bo.TaxAppBOImpl;
import com.taxapp.common.CommonConstants;
import com.taxapp.dto.TaxDetailDTO;
import com.taxapp.exception.ApplicationException;
import com.taxapp.util.ValidationUtil;

/**
 * Servlet implementation class TaxApplication
 */
public class TaxApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(TaxApplicationServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaxApplicationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Entering doPost");
		
		TaxDetailDTO taxDetail = new TaxDetailDTO();

		taxDetail.setAddress(request.getParameter(CommonConstants.ADDRESS));
		log.info(request.getParameter(CommonConstants.ADDRESS));
		taxDetail.setName(request.getParameter(CommonConstants.USERNAME));
		log.info(request.getParameter(CommonConstants.USERNAME));
		taxDetail.setDob(request.getParameter(CommonConstants.DATEOFBIRTH));
		log.info(request.getParameter(CommonConstants.DATEOFBIRTH));
		taxDetail.setIncome(request.getParameter(CommonConstants.INCOME));
		log.info(request.getParameter(CommonConstants.INCOME));
		taxDetail.setAssess_year(request.getParameter(CommonConstants.ASSESSYEAR));
		log.info(request.getParameter(CommonConstants.ASSESSYEAR));
		taxDetail.setPan(request.getParameter(CommonConstants.PAN));
		log.info(request.getParameter(CommonConstants.PAN));
		taxDetail.setTax_deduct(request.getParameter(CommonConstants.TAXDEDUCT));
		log.info(request.getParameter(CommonConstants.TAXDEDUCT));
		taxDetail.setTds(request.getParameter(CommonConstants.TDS));
		log.info(request.getParameter(CommonConstants.TDS));

		boolean status=false;

		TaxAppBO taxAppBO = new TaxAppBOImpl();
		try {
			status = ValidationUtil.checkBlanks(taxDetail);
			if (status) {
				status = taxAppBO.createXML(taxDetail);
				if (status)
					request.getRequestDispatcher(CommonConstants.WELCOME_PAGE_URL).forward(request, response);
			}
		} catch (ApplicationException e) {
			log.fatal(e.getMessage());
		}
		
		
	}
}
