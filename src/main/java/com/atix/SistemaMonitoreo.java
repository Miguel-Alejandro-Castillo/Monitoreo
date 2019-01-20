package com.atix;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class SistemaMonitoreo  {

    private Integer M = 8888;
    private Integer S = 9999;
    private Integer max = Integer.MIN_VALUE;
    private Integer min = Integer.MAX_VALUE;
    private Integer cant = 0;
    private Integer sum = 0;
    private Integer promedio;

    private Queue<Integer> meditions = new LinkedList<>();

    public Integer getM() {
        return M;
    }

    public void setM(Integer m) {
        M = m;
    }

    public Integer getS() {
        return S;
    }

    public void setS(Integer s) {
        S = s;
    }

    public Queue<Integer> getMeditions() {
        return meditions;
    }

    @Scheduled(fixedRate = 60000)
    public void reportMedition(){
       for(int i = 0; i < 2 ; i++){
           if(!this.getMeditions().isEmpty()) {
               Integer firstMedition = this.getMeditions().remove();
               this.max = Math.max(this.max, firstMedition);
               this.min = Math.min(this.min, firstMedition);
               this.cant++;
               this.sum += firstMedition;
               this.promedio = this.sum / this.cant;

               if((this.min - this.max) > S){
                   System.out.println("El promedio supera al parametro S");
               }

               if(this.promedio > M ){
                   System.out.println("El promedio supera al parametro M");
               }

           }
       }
    }
}
