package com.atix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/SistemaMonitoreo")
public class MonitoreoController {

    private static final Logger logger = LoggerFactory.getLogger(MonitoreoController.class);


    @Autowired
    private SistemaMonitoreo sistemaMonitoreo;

    @PostMapping(value = "/getMedition")
    public void getMedition(@RequestBody Integer medition){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTimeString = format.format(new Date());
        logger.info(dateTimeString + ", Medicion: " + medition);
        this.sistemaMonitoreo.getMeditions().add(medition);
    }
}
