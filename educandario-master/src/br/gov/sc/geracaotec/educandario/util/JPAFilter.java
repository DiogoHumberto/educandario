package br.gov.sc.geracaotec.educandario.util;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames={"Faces Servlet"})
public class JPAFilter implements Filter {
	
	private EntityManagerFactory factory;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("educandario-master");
	}
	
	@Override
	public void destroy() {
		this.factory.close();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		EntityManager manager = this.factory.createEntityManager();
		req.setAttribute("EntityManager", manager);
		
		chain.doFilter(req, res);
	}

	
	

}