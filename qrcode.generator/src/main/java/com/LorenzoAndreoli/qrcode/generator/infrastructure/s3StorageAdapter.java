package com.LorenzoAndreoli.qrcode.generator.infrastructure;

import com.LorenzoAndreoli.qrcode.generator.ports.storagePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
public class s3StorageAdapter implements storagePort {

    private final S3Client s3Client;

    private final String bucketName;

    private final String region;

    public s3StorageAdapter(@Value("$aws.s3.region") String region,
                            @Value("$aws.s3.bucket-name") String bucketName,
                            S3Client s3Client){

        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .region(Region.of(this.region))
                .build();
    }

    @Override
    public String uploadFile(byte[] fileData, String fileName, String contentType){
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));

        return String.format("https://%s.s3.%s.amazonaws.com/%s",
                bucketName, region, fileName);
    }
}
