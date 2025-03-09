package com.rest.call.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.call.pojo.InfoResponse;
import com.rest.call.service.InfoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class InfoController {
	@Autowired
	InfoService infoService;

	@GetMapping("/infoRest")
	public List<InfoResponse> fetchAllRecords() {
		List<InfoResponse> allRecords = infoService.fetchAllRecords();
		return allRecords;
	}
	
	@GetMapping("/infoRest/{id}") 
	public InfoResponse oneRecord(@PathVariable int id) { 
	    return infoService.oneRecord(id); 
	}

	@GetMapping("/infoWebFlux")
	public Flux<InfoResponse> fetchAllRecordsByFlux() {
		Flux<InfoResponse> fetchAllRecordsByFlux = infoService.fetchAllRecordsByFlux();
		return fetchAllRecordsByFlux;
	}
	
	@GetMapping("/infoWebMono/{id}") 
	public Mono<InfoResponse> oneRecordByMono(@PathVariable int id) { 
	    return infoService.oneRecordByMono(id); 
	}


}
