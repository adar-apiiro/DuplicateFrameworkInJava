
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.storage.GoogleStorageResource;
import org.springframework.stereotype.Service;

@Service
public class CloudService {

    @Autowired
    private SimpleFeignClient feignClient;

    @Autowired
    private GoogleStorageResource googleStorageResource;

    public void performOperations() {
        // Fetching a post using Feign Client
        Post post = feignClient.getPostById(1L);
        System.out.println("Post Title: " + post.getTitle());

        // Check if Google Cloud Storage bucket exists
        if (googleStorageResource.bucketExists()) {
            System.out.println("Bucket exists: " + googleStorageResource.getBucketName());
        } else {
            System.out.println("Bucket does not exist.");
        }
    }
}
