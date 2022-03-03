package com.bootcamp.credit.utils;

import com.bootcamp.credit.model.dto.Credit;

import java.time.LocalDate;

public class DataCredit {

    public static Credit getDataCredit(){
        Credit c=new Credit();
        c.set_id("_0123123123asd");
        c.setNumDocument("589966526");
        c.setCode("CD002");
        c.setAmortization(10.5);
        c.setTotal(155);
        c.setDateLapsed(LocalDate.now());

        return c;
    }
}
