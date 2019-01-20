package com.atix;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonitoreoApplicationTests {

	@Autowired
	private SistemaMonitoreo sistemaMonitoreo;

	@Test
	public void checkListadoMedicionesEnviado() {
		Queue<Integer> mediciones = new LinkedList<>();
		for (int i = 0 ; i < 10; i++){
			Integer medition = RandomUtils.nextInt();
			mediciones.add(medition);
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Integer> request =  new HttpEntity<>(medition);
			restTemplate.postForObject("http://localhost:8080/SistemaMonitoreo/getMedition", request, Integer.class);

		}
		Assert.assertTrue(this.sistemaMonitoreo.getMeditions().equals(mediciones));

	}

}

