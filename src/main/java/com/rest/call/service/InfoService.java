package com.rest.call.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.util.CommonUtil;
import com.rest.call.pojo.InfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InfoService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
    private WebClient webClient;

	@Value("${external.api.url}")
	private String apiUrl;

	public List<InfoResponse> fetchAllRecords() {
		CommonUtil.setAuditDetails(java.util.UUID.randomUUID().toString());
		InfoResponse[] infoArray = restTemplate.getForObject(apiUrl, InfoResponse[].class);
		List<InfoResponse> infoList = Arrays.asList(infoArray);
		return infoList;
	}

	public InfoResponse oneRecord(String id) {
		RestTemplate restTemplate = new RestTemplate();
		InfoResponse info = restTemplate.getForObject(apiUrl + "/" + id, InfoResponse.class);
		return info;
	}

	public Flux<InfoResponse> fetchAllRecordsByFlux() {
		Flux<InfoResponse> bodyToFlux = webClient.get().uri("/").retrieve().bodyToFlux(InfoResponse.class);
		return bodyToFlux;
	}

	public Mono<InfoResponse> oneRecordByMono(String id) {
		Mono<InfoResponse> bodyToMono = webClient.get().uri("/{id}", id).retrieve().bodyToMono(InfoResponse.class);
		return bodyToMono;
	}
}