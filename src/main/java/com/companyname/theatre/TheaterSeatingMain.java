package com.companyname.theatre;
import com.companyname.theatre.model.FinalInputRequest;
import com.companyname.theatre.service.TheaterService;
import com.companyname.theatre.service.impl.TheaterServiceImpl;
import com.companyname.theatre.util.TheatreUtil;

public class TheaterSeatingMain {
    public static void main(String args[]) {
        TheatreUtil theatreUtil=new TheatreUtil();
        TheaterService service= new TheaterServiceImpl();
        FinalInputRequest layout = theatreUtil.getLayout();
        int totalCapacity=service.totalCapacity(layout);
        service.allowSeating(layout,totalCapacity);
    }
}
