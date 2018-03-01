package com.companyname.theatre.service.impl;

import com.companyname.theatre.model.FinalInputRequest;
import com.companyname.theatre.model.TicketRequest;
import com.companyname.theatre.service.TheaterService;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheaterServiceImplTest {

    private TheaterService theaterService;
    private FinalInputRequest finalInputRequest;

    @org.junit.Before
    public void setUp() throws Exception {
        finalInputRequest =new FinalInputRequest();
        List<TicketRequest> request=new ArrayList<TicketRequest>();
        TicketRequest request1=new TicketRequest("TestName",5);
        TicketRequest request2=new TicketRequest("TestName",100);
        TicketRequest request3=new TicketRequest("TestName",2);
        request.add(request1);
        request.add(request2);
        request.add(request3);
        finalInputRequest.setRequest(request);
        List<Integer> layOutRow= Arrays.asList(5,4);
        List<Integer> layOutRow1=Arrays.asList(6,8,8);
        List<List<Integer>> layOut=Arrays.asList(layOutRow,layOutRow1);
        finalInputRequest.setLayOut(layOut);
    }

    @org.junit.Test
    public void totalCapacity() {
        theaterService=new TheaterServiceImpl();
        int totalCapacity=theaterService.totalCapacity(finalInputRequest);
        Assert.assertNotNull(totalCapacity);
        Assert.assertEquals(totalCapacity,31);
    }

    @org.junit.Test
    public void allowSeating() {
        theaterService=new TheaterServiceImpl();
        theaterService.allowSeating(finalInputRequest,31);
    }
}