package betting.main.infrastructure;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import betting.main.config.WebSecurityConfig;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(WebSecurityConfig.class);

		root.setServletContext(servletContext);
		root.scan("betting.main");
		root.scan("db");

		servletContext.addListener(new ContextLoaderListener(root));
		servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForUrlPatterns(null, false, "/*");

		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(root));
		registration.setLoadOnStartup(1);
		registration.addMapping("/*");
	}
}