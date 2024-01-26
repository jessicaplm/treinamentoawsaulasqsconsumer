package com.treinamento.aws.treinamentoawsaulasqsconsumer.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
public class SqsConfig {

	@Value("${app.aws.key.id}")
	private String AccessKeyId;
	
	@Value("${app.aws.secret.access.key}")
	private String secretAccessKey;
	
    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                //para usar as configurações do aws config, apenas descomentar essa linha e comentar a de baixo
//        	    .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(AccessKeyId,secretAccessKey)))
        	    .build();
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }
}
