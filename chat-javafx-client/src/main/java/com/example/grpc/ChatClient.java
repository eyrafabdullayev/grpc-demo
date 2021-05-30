package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChatClient extends Application {

    private ObservableList<String> messages = FXCollections.observableArrayList();
    private ListView<String> messagesView = new javafx.scene.control.ListView<>();
    private TextField name = new TextField("name");
    private TextField message = new TextField();
    private Button send = new Button("Send");

    public static void main(String[] args) {
        launch(args);
    }

    protected void init(Stage primaryStage) throws Exception {
        messagesView.setItems(messages);

        BorderPane pane = new BorderPane();
        pane.setLeft(name);
        pane.setCenter(message);
        pane.setRight(send);

        BorderPane root = new BorderPane();
        root.setCenter(messagesView);
        root.setBottom(pane);

        primaryStage.setTitle("gRPC Chat");
        primaryStage.setScene(new Scene(root, 400, 320));

        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        ChatServiceGrpc.ChatServiceStub stub = ChatServiceGrpc.newStub(channel);

        StreamObserver<Chat.ChatMessage> outgoing = stub.chat(new StreamObserver<Chat.ChatMessageFromServer>() {
            @Override
            public void onNext(Chat.ChatMessageFromServer value) {
                Platform.runLater(() -> {
                    messages.add(value.getMessage().getMessage());
                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });

        send.setOnAction(e -> {
            outgoing.onNext(Chat.ChatMessage.newBuilder().setMessage(message.getText()).build());
        });
    }
}
