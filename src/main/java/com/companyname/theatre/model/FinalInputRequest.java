package com.companyname.theatre.model;

import java.util.List;

public class FinalInputRequest {

    private List<List<Integer>> layOut;
    List<TicketRequest> request;

    public List<TicketRequest> getRequest() {
        return request;
    }

    public void setRequest(List<TicketRequest> request) {
        this.request = request;
    }

    public List<List<Integer>> getLayOut() {
        return layOut;
    }

    public void setLayOut(List<List<Integer>> layOut) {
        this.layOut = layOut;
    }

}
