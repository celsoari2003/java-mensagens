package br.com.atlantico.testProgramador.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

//@Configuration
public class PersistenceContext {

	
	//@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("br.com.atlantico.testProgramador.model");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProperties.put("spring.jpa.database-platform", "org.hibernate.dialect.H2Dialect");

		jpaProperties.put("spring.jpa.hibernate.ddl-auto", "update");

		jpaProperties.put("spring.jpa.generate-ddl", "true");

		jpaProperties.put("spring.h2.console.enabled", "true");

		jpaProperties.put("spring.h2.console.path", "/h2-console");

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
}
