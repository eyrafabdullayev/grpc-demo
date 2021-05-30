package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String... args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse response = stub.greet(HelloRequest.newBuilder()
                .setFirstName("Eyraf")
                .setLastName("Abdullayev")
                .setSentiment(Sentiment.SLEEPY)
                .build()
        );
        System.out.println("Response from server side: " + response.getGreeting());
    }
}
