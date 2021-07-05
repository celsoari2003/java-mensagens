package br.com.atlantico.testProgramador.configuration;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
public class JPAConfiguration {

	//@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("password");
		dataSource.setUrl("jdbc:h2:mem:exemplo");

		return dataSource;
	}


	

}
