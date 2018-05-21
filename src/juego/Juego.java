package juego;
import javax.swing.JOptionPane;
public class Juego {

    public static void main(String[] args) {
        int opcion;
        String menu[] = {"Máquina","Jugador","Salir"};
        
        do{ opcion = JOptionPane.showOptionDialog(null,"Elije quién intenta adivinar","OPCIONES",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                menu,menu[1]);
        
            switch(opcion){
                case 0: Jugador j = new Jugador();
                        j.adivinar();
                    break;
                case 1: Maquina m = new Maquina();
                        m.adivinar();
                    break;
            }
        }while(opcion != 2);
    }
}
