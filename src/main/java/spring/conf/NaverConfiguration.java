package spring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:spring/naver.properties") // src/main/resources 기준
public class NaverConfiguration {
	private @Value("${ncp.accessKey}") String accessKey;
	private @Value("${ncp.secretKey}") String secretKey;
	private @Value("${ncp.regionName}") String regionName;
	private @Value("${ncp.endPoint}") String endPoint;
	
	public String getAccessKey() {
		return accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public String getRegionName() {
		return regionName;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	
}
