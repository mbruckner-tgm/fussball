package db.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConnectionManager {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceUnitName("betting-db");
		em.setDataSource(configureDataSource());
		em.setPackagesToScan(new String[] { "db" });
		em.setJtaDataSource(configureDataSource());
		em.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		em.setJpaPropertyMap(getVendorProperties());
		em.setPersistenceXmlLocation("classpath*:persistence.xml");
		return em;
	}

	@Bean
	public DataSource configureDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/betting_db");
		dataSource.setUsername("michl");
		dataSource.setPassword("michl");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> map = new HashMap<>();
		map.put(PersistenceUnitProperties.WEAVING, "false");
		map.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.NONE);
		return map;
	}

}
