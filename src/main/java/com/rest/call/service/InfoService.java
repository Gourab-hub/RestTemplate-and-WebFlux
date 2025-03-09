package com.rest.call.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	// https://mockapi.io/ used
	String url = "https://67cd5a6fdd7651e464ee213d.mockapi.io/info/api/v1/Profile";

	public List<InfoResponse> fetchAllRecords() {
		InfoResponse[] infoArray = restTemplate.getForObject(url, InfoResponse[].class);
		List<InfoResponse> infoList = Arrays.asList(infoArray);
		return infoList;
	}

	public InfoResponse oneRecord(int id) {
		RestTemplate restTemplate = new RestTemplate();
		InfoResponse info = restTemplate.getForObject(url + "/" + id, InfoResponse.class);
		return info;
	}

	public Flux<InfoResponse> fetchAllRecordsByFlux() {
		Flux<InfoResponse> bodyToFlux = webClient.get().uri("/Profile").retrieve().bodyToFlux(InfoResponse.class);
		return bodyToFlux;
	}

	public Mono<InfoResponse> oneRecordByMono(int id) {
		Mono<InfoResponse> bodyToMono = webClient.get().uri("/Profile/{id}", id).retrieve().bodyToMono(InfoResponse.class);
		return bodyToMono;
	}
}