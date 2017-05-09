package pSystem;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.heroku.api.HerokuAPI;

/**
 * pom:
 *
 * <dependency>
    <groupId>com.heroku.api</groupId>
    <artifactId>heroku-api</artifactId>
    <version>0.18</version>
</dependency>
<dependency>
    <groupId>com.heroku.api</groupId>
    <artifactId>heroku-json-jackson</artifactId>
    <version>0.18</version>
</dependency>
<dependency>
    <groupId>com.heroku.api</groupId>
    <artifactId>heroku-http-apache</artifactId>
    <version>0.18</version>
</dependency>
 * @author Fer
 *
 */
@Configuration
@Component
public class DataSourceBean {
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		ConnectionData conData = getDbUrl();
		return DataSourceBuilder
				.create()
				.url(conData.getUrl() + "?sslmode=require")
				.username(conData.getUser())
				.password(conData.getPassword())
				.driverClassName("org.postgresql.Driver")
				.build();
	}

	private ConnectionData getDbUrl() {
		HerokuAPI api = new HerokuAPI("fa5714d3-e510-4958-9378-ac0d8d5cb742");
		Map<String, String> config = api.listConfig("parti3a");

		String dbUrl = config.get("DATABASE_URL");

		if (dbUrl != null) {
			Pattern p = Pattern.compile("(postgres)://([^:]+):([^@]+)@(.*)");
			Matcher m = p.matcher(dbUrl);
			m.find();

			String user = m.group(2);
			String password = m.group(3);
			return new ConnectionData(user, password, "jdbc:" + m.group(1) + "ql://" + m.group(4));
		} else {
			//Usamos lo estático
			return new ConnectionData("vrazyywfrgjhmh",
									  "1b66edebf4bb1532c83b8c12fd7ec88610e3b13e06999cbc073310088f3c9bd3",
									  "jdbc:postgresql://ec2-54-247-99-159.eu-west-1.compute.amazonaws.com:5432/da7d90ojckgaab");
		}
	}

	private class ConnectionData {
		private String user;
		private String password;
		private String url;

		public ConnectionData(String user, String password, String url) {
			this.user = user;
			this.password = password;
			this.url = url;
		}

		public String getUser() {
			return user;
		}

		public String getPassword() {
			return password;
		}

		public String getUrl() {
			return url;
		}
	}
}
