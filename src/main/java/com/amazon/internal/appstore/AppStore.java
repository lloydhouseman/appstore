package com.amazon.internal.appstore;

import java.beans.PropertyVetoException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
public class AppStore {
	
    @Bean(destroyMethod="close")
    public DataSource dataSource() throws URISyntaxException, PropertyVetoException {
//	    URI dbUri = new URI(System.getenv("DATABASE_URL"));
	    URI dbUri = new URI("postgres://cpvabakswzgrgb:iJ4hCl46p7dF-Xed9-3vrV_rNU@ec2-54-204-13-220.compute-1.amazonaws.com:5432/d3e21r7o9h5jok");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("org.postgresql.Driver");
        comboPooledDataSource.setJdbcUrl(dbUrl);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setMaxPoolSize(30);
        comboPooledDataSource.setMinPoolSize(10);
        comboPooledDataSource.setMaxStatements(50);
        comboPooledDataSource.setTestConnectionOnCheckout(true);

        return comboPooledDataSource;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(AppStore.class, args);
	}
	
}
