package spring.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:spring/db.properties")
@EnableTransactionManagement
@MapperScan("user.dao")
public class SpringConfiguration {
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
	}
	
	@Bean
	// DB Setting							// 원래 필드에서 Autowired 되어 있었다.
	public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext,
											DataSource dataSource) throws Exception{ // XML의 id 부분이 메서드명이 된다.
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("user.bean"); // 별칭 잡아줌
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*Mapper.xml"));
																// applicationContext 객체를 사용하지 않으면 와일드카드를 쓰지 못함
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean							// 이미 객체(Bean)가 선언되었기 때문에 매개변수로 줄 수 있다.
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransaction(DataSource dataSource){
		DataSourceTransactionManager dstm = new DataSourceTransactionManager(dataSource);
		
		return dstm;
	}
	
	
}
