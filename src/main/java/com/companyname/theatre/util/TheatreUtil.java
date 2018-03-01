package com.companyname.theatre.util;

import com.companyname.theatre.model.FinalInputRequest;
import com.companyname.theatre.model.TicketRequest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheatreUtil {
    private static final String SPACE = "\\s+";
    public FinalInputRequest getLayout(){
        List<List<Integer>> layOut = new ArrayList<List<Integer>>();
        List<TicketRequest> request=new ArrayList<TicketRequest>();
        FinalInputRequest finalInputRequest=new FinalInputRequest();
        try {
            Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()));
            lines.forEach( (String line) -> {
                if(!line.trim().isEmpty() && !line.matches(".*[a-z].*")){
                    List<Integer> strings=Stream.of(line.split(SPACE))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    layOut.add(strings);
                }
                else if(!line.trim().isEmpty() && line.matches(".*[a-z].*")){
                    String[] spaces = line.split(SPACE);
                    TicketRequest ticketRequest=new TicketRequest(spaces[0],Integer.valueOf(spaces[1]));
                    request.add(ticketRequest);
                }
            });
            lines.close();
            finalInputRequest.setRequest(request);
            finalInputRequest.setLayOut(layOut);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return  finalInputRequest;
    }
}
