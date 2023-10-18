package user.service;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageService {

	String uploadFile(String bucketName, String string, MultipartFile img);

}
