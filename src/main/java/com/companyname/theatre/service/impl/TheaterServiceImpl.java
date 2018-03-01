package com.companyname.theatre.service.impl;

import com.companyname.theatre.model.FinalInputRequest;
import com.companyname.theatre.model.TicketRequest;
import com.companyname.theatre.service.TheaterService;

import java.util.Collection;
import java.util.List;

public class TheaterServiceImpl implements TheaterService {

    @Override
    public int totalCapacity(FinalInputRequest finalInputRequest) {
        List<List<Integer>> layOut = finalInputRequest.getLayOut();
        int sum = layOut.stream().flatMap(Collection::stream).mapToInt(i -> i).sum();
        return sum;
    }
    @Override
    public void allowSeating(FinalInputRequest finalInputRequest, int totalCapacity) {
        List<List<Integer>> layOut = finalInputRequest.getLayOut();
        List<TicketRequest> request = finalInputRequest.getRequest();
        for(TicketRequest ticketRequest : request)
        {
            if (ticketRequest.getNumTicketsReq() > totalCapacity) {
                System.out.println(ticketRequest.getName() + " Sorry, we cannot handle your party");

            } else {
                int rowTemp = 0;
                int section = 0;
                boolean match = false;
                for (List<Integer> row : layOut) {
                    section = 0;
                    for (Integer sectionValue : row) {
                        if ((sectionValue - ticketRequest.getNumTicketsReq()) > 1 || (sectionValue - ticketRequest.getNumTicketsReq()) == 0  ) {
                            layOut.get(rowTemp).set(section,
                                    (layOut.get(rowTemp).get(section)) - ticketRequest.getNumTicketsReq());
                            System.out.println(ticketRequest.getName() + " Row " + (rowTemp + 1) + " Section " + (section + 1));
                            totalCapacity -= ticketRequest.getNumTicketsReq();
                            match = true;
                            break;
                        }
                        section++;
                    }
                    if (match)
                        break;
                    rowTemp++;
                }
                if (!match) {
                    System.out.println(ticketRequest.getName() + " Call to split party.");
                }
            }
        }
    }
}
