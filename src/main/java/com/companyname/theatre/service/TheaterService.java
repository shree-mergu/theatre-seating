package com.companyname.theatre.service;

import com.companyname.theatre.model.FinalInputRequest;

public interface TheaterService {

    int totalCapacity(FinalInputRequest finalInputRequest);
    void allowSeating(FinalInputRequest finalInputRequest, int totalCapacity);
}
