package com.companyname.theatre.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheatreUtilTest {

    private TheatreUtil theatreUtil;

    @Test
    public void getLayout() {
        theatreUtil=new TheatreUtil();
        theatreUtil.getLayout();
    }
}