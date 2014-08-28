package javaapplication48;
//@lospelaosyelheber
import javax.swing.JOptionPane;

public class JavaApplication48 {

    public static void main(String[] args) {
        inicio();
    }
    public static void inicio(){
        
        String password = contraseña();
        switch (password) {
            case "1234":
                int saldo= 1000000;
                usuario(saldo);
                break;
            case "0987":  
                admin();
                break;
            default:
                JOptionPane.showMessageDialog(null, "¡Contraseña incorrecta!");
                
                inicio();
                break;
        }
    }
      public static String contraseña() {
          String password = JOptionPane.showInputDialog("Ingrese su Contraseña");
            if (null==password) {//esto hace que si se presiona cancel vuelve al metodo principal  
                inicio();//Maravilloso no creen :D?
            }
        return password; 
    }
      public static void usuario(int saldo){
          
          int elección = dato("ESTIMADO USUARIO - SELECCIONE UNA OPCION,(1) Girar Dinero,(2) Depositar Dinero,(3)Consultar Saldo,(4) Cerrar Sesión");
          switch (elección) {
              case 1:
                    int segundaelección = dato("Realizar un giro, Montos Disponibles:,1.- $ 200.000,2.- $ 100.000,3.- $ 50.000,4.- $ 25.000,5.- $ 10.000,6.- $ 5.000,7.- Otro Monto,8.- Volver al menu principal,9 .- Cerrar Sesión.");
                    switch (segundaelección) {
                    case 1:
                        int docien = 200000;
                        saldo = CalcularSaldoGiro(saldo,docien);
                        preguntar(saldo);
                        break;
                    case 2:
                        int cien = 100000;
                        saldo = CalcularSaldoGiro(saldo,cien);
                        preguntar(saldo);
                        break;                        
                    case 3:
                        int ciencuen = 50000;
                        saldo = CalcularSaldoGiro(saldo,ciencuen);
                        preguntar(saldo);
                        break;
                    case 4:
                        int veci = 25000;
                        saldo = CalcularSaldoGiro(saldo,veci);
                        preguntar(saldo);
                        break;
                    case 5:
                        int diez = 10000;
                        saldo = CalcularSaldoGiro(saldo,diez);
                        preguntar(saldo);
                         break;
                    case 6:
                        int cin = 5000;
                        saldo = CalcularSaldoGiro(saldo,cin);
                        preguntar(saldo);
                         break;
                    case 7:
                        int otro = dato("Ingrese monto deseado");
                        saldo = CalcularSaldoGiro(saldo,otro);
                        preguntar(saldo);
                        break;
                    case 8:
                         usuario(saldo);
                        break;   
                    case 9:
                         inicio();
                         break; 
                     default:
                        JOptionPane.showMessageDialog(null, "Opción invalida!");
                         usuario(saldo);
                         break;
                    }
                  break;
              case 2:
                  int terceraelección = dato("Realizar un deposito,Montos Disponibles:,1.- $ 200.000,2.- $ 100.000,3.- $ 50.000,4.- $ 25.000,5.- $ 10.000,6.- $ 5.000,7.- Otro Monto,8.- Volver al menu principal,9 .- Cerrar Sesión.");
                    switch (terceraelección) {
                    case 1:
                        int dociens = 200000;
                        saldo = CalcularSaldoDeposito(saldo,dociens);
                        preguntar(saldo);
                        break;
                    case 2:
                        int ciens = 100000;
                        saldo = CalcularSaldoDeposito(saldo,ciens);
                        preguntar(saldo);
                        break;                        
                    case 3:
                        int ciencuens = 50000;
                        saldo = CalcularSaldoDeposito(saldo,ciencuens);
                        preguntar(saldo);
                        break;
                    case 4:
                        int vecis = 25000;
                        saldo = CalcularSaldoDeposito(saldo,vecis);
                        preguntar(saldo);
                        break;
                    case 5:
                        int diezs = 10000;
                        saldo = CalcularSaldoDeposito(saldo,diezs);
                        preguntar(saldo);
                         break;
                    case 6:
                        int cins = 5000;
                        saldo = CalcularSaldoDeposito(saldo,cins);
                        preguntar(saldo);
                         break;
                    case 7:
                        int otro = dato("Ingrese monto deseado");
                        saldo = CalcularSaldoDeposito(saldo,otro);
                        preguntar(saldo);
                        break;
                    case 8:
                         usuario(saldo);
                        break;   
                    case 9:
                         inicio();
                         break; 
                     default:
                        JOptionPane.showMessageDialog(null, "Opción invalida!");
                         usuario(saldo);
                         break;
                    }
                  break;
              case 3:
                  JOptionPane.showMessageDialog(null, "Tu saldo es: " + MostrarSaldo(saldo));
                  usuario(saldo);
                  break;
              case 4:
                  inicio();
                  break;
              default:
                  JOptionPane.showMessageDialog(null, "Opción invalida!");
                  usuario(saldo);
                  break;
          }
 }
       public static void admin (){
           int elección = dato("MODO ADMINISTRADOR - SELECCIONE UNA OPCION,(1) Salir,(2) Apagar");
           switch (elección) {
               case 1:
                   inicio();
                   break;
               case 2:
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Opción invalida!");
                   admin();
                   break;
           }
       }
    
        public static int dato(String texto) {
        int op=0;
        boolean comprobar = false;
        String cadena="";
        String lista = texto;
        String menu[] = lista.split(",");
        for (String menu1 : menu) {
            cadena = cadena + menu1 + "\n";
        }
        while (!comprobar) {
                    try {
                        String operacion = JOptionPane.showInputDialog(cadena);
                        op = Integer.parseInt(operacion);
                        if (op > 0) {
                            comprobar = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese numero válido");
                        }

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Ingrese numero válido");
                    }
                }
            return op;    
    }
        public static void preguntar(int saldo){
            int elección = dato("Desea realizar otra operación?,(1) Si,(2) No");
            switch (elección){
                case 1:
                    usuario(saldo);
                    break;
                case 2:
                    inicio();
                    break;
                default:
                    break;
            }
        }
         public static int CalcularSaldoGiro(int saldo, int opcion) {
        int newsaldo = 0;
        if (saldo > 0) {
            newsaldo = saldo - opcion;
            JOptionPane.showMessageDialog(null, "Su nuevo saldo es " + newsaldo);
        } else {
            JOptionPane.showMessageDialog(null, "Sin saldo suficiente ");
        }
        return newsaldo;
    }
         public static int CalcularSaldoDeposito(int saldo, int opcion) {
        int newsaldo = 0;
        if (saldo > 0) {
            newsaldo = saldo + opcion;
            JOptionPane.showMessageDialog(null, "Su nuevo saldo es " + newsaldo);
        } else {
            JOptionPane.showMessageDialog(null, "Sin saldo suficiente ");
        }
        return newsaldo;
    }
        public static int MostrarSaldo(int saldo) {
        int newsaldo;
        newsaldo = saldo; 
        return newsaldo;
    }
         
}
