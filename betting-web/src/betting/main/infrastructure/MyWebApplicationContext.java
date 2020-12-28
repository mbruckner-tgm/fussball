package betting.main.infrastructure;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MyWebApplicationContext extends AnnotationConfigWebApplicationContext {
	private static final String CONFIG_FILES_LOCATION = "betting.main.config;db.config";

	public MyWebApplicationContext() {
		super();
		setConfigLocation(CONFIG_FILES_LOCATION);
	}

}