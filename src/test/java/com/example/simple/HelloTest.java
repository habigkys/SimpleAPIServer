package com.example.simple;

import com.example.SimpleBootTest;
import com.example.simple.service.FcmService;
import com.google.api.client.util.Lists;
import com.google.firebase.messaging.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SimpleBootTest
class HelloTest {

    @Autowired
    FcmService fcmService;

    @Test
    void fcmTest() throws FirebaseMessagingException {
        String token = "eNTY2lzwRESScAPRIcFhjv:APA91bFe95HfYupF-QqJwpEuPfssF6xtco3I8-lDmfmnTVp0iseGpYOA1YOyQ6DHH4pLItW_kmA46Tz4aV1t5v_XTuw8vFPnq_3xvEi7xB8enJMKF9qwaP4gR3Udhb7-gJ69vMevfegG";

        // 단일 발송
        String id = fcmService.singleSend(token, "연봉 동결", "연봉 동결");

        // 잔뜩 발송: 최대 500개 앱까지 동시에
//        List<String> tokens = Lists.newArrayList();
//        tokens.add("eNTY2lzwRESScAPRIcFhjv:APA91bFe95HfYupF-QqJwpEuPfssF6xtco3I8-lDmfmnTVp0iseGpYOA1YOyQ6DHH4pLItW_kmA46Tz4aV1t5v_XTuw8vFPnq_3xvEi7xB8enJMKF9qwaP4gR3Udhb7-gJ69vMevfegG");
//
//        BatchResponse response = fcmService.multiSend(tokens, "연봉 동결", "연봉 동결");
    }
}
