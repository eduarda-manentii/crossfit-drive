package com.br.crossfitdrive.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {

    private final S3Client s3Client;
    private final String bucketName;

    public S3Service(
            S3Client s3Client,
            @Value("${aws.bucket.name}")
            String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    public String uploadFile(MultipartFile file) {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        return uploadImage(fileName, file);
    }

    public String uploadImage(String fileName, MultipartFile file) {
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .contentType(file.getContentType())
                    .build();

            RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
            s3Client.putObject(putObjectRequest, requestBody);

            return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("Falha ao ler o arquivo da requisição: " + e.getMessage(), e);
        } catch (S3Exception e) {
            throw new RuntimeException("Erro na AWS S3 ao fazer upload: " + e.awsErrorDetails().errorMessage(), e);
        }
    }

    public void deleteImage(String fileUrlOrKey) {
        try {
            String key = fileUrlOrKey.contains("/")
                    ? fileUrlOrKey.substring(fileUrlOrKey.lastIndexOf("/") + 1)
                    : fileUrlOrKey;
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();
            s3Client.deleteObject(deleteObjectRequest);
        } catch (S3Exception e) {
            throw new RuntimeException("Erro na AWS S3 ao deletar arquivo: " + e.awsErrorDetails().errorMessage(), e);
        }
    }

}