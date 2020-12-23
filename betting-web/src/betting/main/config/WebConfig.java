package betting.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig {
	@Autowired
	@Qualifier("jstlViewResolver")
	private ViewResolver jstlViewResolver;

	@Bean
	@DependsOn({ "jstlViewResolver" })
	public ViewResolver viewResolver() {
		return jstlViewResolver;
	}

	@Bean(name = "jstlViewResolver")
	public ViewResolver jstlViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setViewClass(JstlView.class);
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
