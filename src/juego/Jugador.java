package juego;
import javax.swing.JOptionPane;

public class Jugador {
    private int numero;
    public static int mayor=101, menor=-1;
    public static int contador = 0;
    public static final int[] vector = new int[100];
    
    public Jugador(){
        JOptionPane.showMessageDialog(null,"Piensa un número entre 1 y 100, y yo lo adivinaré");
    }
    public void adivinar(){
        String opcion[] = {"Si","No"};
        String rango[] = {"Mayor","Menor"};
        int intento, busqueda;
        boolean acertar=false;
        
        while(acertar == false){
            numero = aleatorio();
            intento = JOptionPane.showOptionDialog(null,"El número que has pensado es "+numero+"?",
                "Intento "+contador,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opcion,opcion[1]);
            if(intento == 0){
                JOptionPane.showMessageDialog(null,"Estupendo!! He Ganado luego de "+contador+" intentos!!");
                acertar = true;
            }else{
                busqueda = JOptionPane.showOptionDialog(null,"¿Cómo es el número que has pensado respecto a "+numero+"?",
                "Mensaje interrogativo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,rango,rango[1]);
                if(busqueda == 0){
                    menor = numero;
                }else{
                    mayor = numero;
                }
            }
        }
    }
    public static int aleatorio(){
        int control=1, numero=0;
        while (control != 0) {
            numero = (int) (Math.random() * 99 + 1);
            control = 0;
            for (int i = 0; i < vector.length; i++) {
                    if (vector[i] == numero) {
                        control+=1;
                }
            }
            if(numero>menor && numero<mayor){
                vector[contador] = numero;
            }else{
                control+=1;
            }
        }
        contador++;
        return numero;
    }
    
}
