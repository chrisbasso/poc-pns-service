package com.pnsservice.pnsservice;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireBaseConfig
{
    @Bean
    FirebaseApp createFireBaseApp() throws IOException
    {
        FileInputStream serviceAccount =
                new FileInputStream("galeno-pns-firebase-adminsdk-tz8m0-dbdc1f489e.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://galeno-pns.firebaseio.com")
                .build();

        return  FirebaseApp.initializeApp(options);
    }

}
