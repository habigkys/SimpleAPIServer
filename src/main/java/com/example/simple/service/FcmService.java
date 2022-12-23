package com.example.simple.service;

import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FcmService {
    private final FirebaseMessaging firebaseMessaging;

    public String singleSend(String token, String title, String body) throws FirebaseMessagingException {
        // 단일 발송
        Message msg = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build())
                .build();
        return firebaseMessaging.send(msg);
    }

    public BatchResponse multiSend(List<String> tokens, String title, String body) throws FirebaseMessagingException {
        MulticastMessage multiMsg = MulticastMessage.builder()
                .addAllTokens(tokens)
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build())
                .build();
        return firebaseMessaging.sendMulticast(multiMsg);
    }
}
