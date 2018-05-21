package juego;
import javax.swing.JOptionPane;

public class Maquina {
    private int numero, intento=0, contador = 1;
    private String cadena;
    public boolean bucle = true, control = false;
    
    public Maquina(){
        numero = (int) (Math.random() * 99 + 1);
    }
    public void adivinar(){
        do{
            while(control == false){
                cadena = JOptionPane.showInputDialog("Intenta adivinar el número").trim();
                control = true;
                control = validar(cadena);
                if(control == false)
                    JOptionPane.showMessageDialog(null,"No es un número válido.","ERROR",JOptionPane.ERROR_MESSAGE);
                else{
                    intento = Integer.parseInt(cadena);
                    if(intento<1 || intento>100){
                        control = false;
                        JOptionPane.showMessageDialog(null,"No es un número válido.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        control = true;
                    }
            }
            if(numero==intento){
                JOptionPane.showMessageDialog(null,"Felicidades!! Has adivinado el número en "+contador+" intentos.");
                bucle = false;
            }else if(numero<intento){
                JOptionPane.showMessageDialog(null,"Fallaste!! El número que has ingresado es mayor que el mío");
                contador++;
            }else if(numero>intento){
                JOptionPane.showMessageDialog(null,"Fallaste!! El número que has ingresado es menor que el mío");
                contador++;
            }
            control = false;
        }while(bucle);
    }
    public boolean validar(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
}
