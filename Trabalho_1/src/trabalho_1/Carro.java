package trabalho_1;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Evandro Duarte
 */
public class Carro extends Thread {

    private Integer id;
    private Integer probAbastecimento;
    private Integer probQuebra;
    Integer avarias;
    private JTextArea jTextArea1;
    private Corrida corrida;
    private long tempoCorrida;
    private ArrayList<Long> podium;

    public Carro(Integer id, Integer probAbastecimento, Integer probQuebra, Integer avarias, Corrida corrida, JTextArea jTextArea1, ArrayList<Long> podium) {
        this.id = id;
        this.probAbastecimento = probAbastecimento;
        this.probQuebra = probQuebra;
        this.avarias = avarias;
        this.jTextArea1 = jTextArea1;
        this.corrida = corrida;
        this.podium = podium;
        
        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

//    @Override
//    public String toString() {
//        return "{" + "id='" + id + '\''
//                + ", avarias=" + avarias + '}';
//    }
//
//    @Override
//    public int compareTo(Carro c) {
//        if (this.avarias != c.getAvarias()) {
//            return this.avarias - c.getAvarias();
//        }
//        return this.avarias.compareTo(c.getAvarias());
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAbs(Integer probAbastecimento) {
        this.probAbastecimento = probAbastecimento;
    }

    public void setQuebra(Integer probQuebra) {
        this.probQuebra = probQuebra;
    }
    
    public void setTextArea(javax.swing.JTextArea jTextArea1){
        this.jTextArea1 = jTextArea1;
    }
    
    public void setCorrida(Corrida corrida){
        this.corrida = corrida;
    }
    
    public void setTempoCorrida(long tempoCorrida){
        this.tempoCorrida = tempoCorrida;
    }
    
    public void setPodium(ArrayList<Long> podium){
        this.podium = podium;
    }

    public int getCarId() {
        return id;
    }
    
    public int getProbAbs() {
        return probAbastecimento;
    }

    public int getProbQuebra() {
        return probQuebra;
    }

    public void setAvarias(Integer avarias) {
        this.avarias = avarias;
    }

    public int getAvarias() {
        return avarias;
    }
    
    public long getTempoCorrida(){
        return tempoCorrida;
    }
    
    public void run(){
        int min = 1;
        int max = 100;
        long start = System.currentTimeMillis();
        // i deve ser igual ao numero de voltas
        for(int i=0; i< corrida.getVoltas();i++){
            try{
                int abastecer = (int) (Math.random() * (max - min + 1) + min);
                int quebrar = (int) (Math.random() * (max - min + 1) + min);
                
                if (abastecer >= 1 && abastecer <= getProbAbs() && quebrar >= 1 && quebrar <= getProbQuebra()){
                   //System.out.println("Carro " + getCarId() + " precisou de reparos e abastecimento!");
                    jTextArea1.append(String.format("Carro " + getCarId() + ": Abastecimento e Conserto \n"));
                    Thread.sleep(2000);
                } else if (abastecer >= 1 && abastecer <= getProbAbs()) {
                    //System.out.println("Carro " + getCarId() + " Precisou abastecer!");
                    jTextArea1.append(String.format("Carro " + getCarId() + ": Abastecimento \n"));
                    Thread.sleep(1500);
                } else if (quebrar >= 1 && quebrar <= getProbQuebra()) {
                    //System.out.println("Carro " + getCarId() + " precisou de reparo!");
                    jTextArea1.append(String.format("Carro " + getCarId() + ": Conserto \n"));
                    Thread.sleep(1000);
                }else {
                    jTextArea1.append(String.format("Carro " + getCarId() + ": Continuou corrida \n"));
                    //System.out.println("Carro " + getCarId() + " continuou a corrida!");
                }
            }catch(InterruptedException err){
                err.printStackTrace();
            }
        }
        //System.out.println("Carro " + getCarId() + " terminou a corrida!");
        jTextArea1.append(String.format("Carro " + getCarId() + ": Terminou a corrida \n"));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        //System.out.println("Carro: "+ id + "Tempo: " + timeElapsed);
        // Seta o tempo que o carro demooru para terminar a prova
        setTempoCorrida(timeElapsed);
        podium.add(timeElapsed);
    }

}