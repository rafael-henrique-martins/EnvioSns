package com.envio.sns.enviandoSns.service.serviceImpl;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.envio.sns.enviandoSns.service.SNSService;
import org.springframework.stereotype.Service;

@Service
public class SNSServiceimpl implements SNSService {

    private static final String TOPI = "arn:aws:sns:us-east-1-topic";

    private static final String EMAIL_SUB = "HELP";

    private static AmazonSNSClient snsClient = null;
    public String publishMessageToTopic(String email){
        snsClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
        snsClient.publish(TOPI, buildEmailBody(email), EMAIL_SUB);
        return "Email enviado com sucesso";
    }

    private String buildEmailBody(String email){
        return "Olá pessoal,\n" +
                "\n" +
                "\n" +
                "Um novo pedido de ajuda foi enviado do o email: " + email +
                "\n" +
                "\n" +
                "\n" +
                "\n";
    }
}
