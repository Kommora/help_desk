package br.com.control;

public class Funcionalidades {
    
    public String horaData(String dt){
        String[] hr = dt.split(" ");
        return  hr[1].substring(0,5);
    }
}
