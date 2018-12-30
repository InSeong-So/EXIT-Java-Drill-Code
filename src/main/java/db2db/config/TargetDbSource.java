package db2db.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "targetDbEntityManagerFactory", transactionManagerRef = "targetDbTransactionManager", basePackages = "db2db.targetdb.repository")
public class TargetDbSource {

	@Bean(name = "smsDataSource")
	@ConfigurationProperties(prefix = "spring.targetdb.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "smsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean smsEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("smsDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("db2db.targetdb.domain").build();
	}

	@Bean(name = "smsTransactionManager")
	public PlatformTransactionManager smsTransactionManager(
			@Qualifier("smsEntityManagerFactory") EntityManagerFactory smsEntityManagerFactory) {
		return new JpaTransactionManager(smsEntityManagerFactory);
	}
}
