package cajerov01;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
public class CajeroV01 {

	public static void main(String[] args) {
		   principal();

    }
   
    public static void principal() {
        
        JOptionPane.showMessageDialog(null, "BIENVENIDOS AL BANCO LOS "
                + "PELADOS Inc.");
        String password = contraseña();
        menu(password);
    }

    public static void menu(String password) {

        boolean comprobar = true;
        int c = 1;

        while (comprobar) {
            if (c == 3) {
                JOptionPane.showMessageDialog(null, "Sonríe, te estamos grabando...");
                c = 1;

            }

            if (c > 1) {
                password = contraseña();

            }

            
            int saldo = 1000000;
            switch (password) {
                case "1234":

                    JOptionPane.showMessageDialog(null, "ESTIMADO USUARIO, SELECCIONE UNA "
                            + "OPCION" + "\n" + "(1) Girar Dinero" + "\n" + "(2) Depositar Dinero"
                            + "\n" + "(3) Consultar Saldo" + "\n" + "(4) Cerrar Sesión");
                    int op1 = validardatos("Ingrese operación que desea realizar: ", saldo, 1);
                    switch (op1) {
                        case 1:
                            giro(saldo);
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:
                            principal();

                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Debe acceder a una operación");
                            break;
                    }
                    break;
                case "0987":

                    JOptionPane.showMessageDialog(null, "BIENVENIDO(A) SEÑOR(A) ADMISNISTRADOR(A)");
                    int op2 = validardatos("ESTIMADO ADMIN, SELECCIONE UNA OPCI?N: "
                            + "\n" + "(1) Salir" + "\n" + "(2) Apagar", saldo, 1);
                    switch (op2) {
                        case 1:
                            principal();
                            break;
                        case 2:
                            // problema!!
                            comprobar = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Ingrese numero válido");
                            break;
                    }
                    break;
                default:
                    c++;
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    break;
            }

        }
    }

    public static String contraseña() {
        String password = JOptionPane.showInputDialog("Ingrese su Contraseña");
            if (null==password) {//esto hace que si se presiona cancel vuelve al metodo principal  
                principal();//Maravilloso no creen :D?
            }
        return password; 
    }

    public static int validardatos(String texto, int saldo, int com) {
        boolean comprobar = false;
        int op = 0;
        switch (com) {
            case 1:

                while (!comprobar) {
                    try {
                        String operacion = JOptionPane.showInputDialog(texto);
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
                break;
            case 2:
                boolean ver = true;
                int monto;
                // Aqu� se debe llamar al Allan
                while (ver) {
                    try {
                        monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del dinero para el giro"));
                        if ((monto > 0) && (monto < saldo)) {
                            ver = false;
                            int newsaldo = saldo - monto;
                            JOptionPane.showMessageDialog(null, "Su nuevo saldo es " + newsaldo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe girar un monto menor o igual a su saldo disponible");
                            giro(saldo);
                        }
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "DATO INVALIDO");
                    }

                }
                break;
        }

        return op;
    }

    public static int giro(int saldo) {
        String serie = "";
        int newsaldo = 0;
        String menu[] = new String[]{" Montos Disponibles: ", "1.- $ 200.000",
            "2.- $ 100.000", "3.- $ 50.000", "4.- $ 25.000", "5.- $ 10.000",
            "6.- $ 5.000", "7.- Otro Monto.", "8.- Volver al menu principal.", "9 .- Cerrar Sesión."};

        for (String menu1 : menu) {
            serie = serie + menu1 + "\n";
        }

        int opc;

        boolean ejecuta = true;

        while (ejecuta) {
            JOptionPane.showMessageDialog(null, "ESTIMADO USUARIO, SELECCIONE UNA "
                    + "OPCION" + "\n" + serie);
            opc = validardatos("Ingrese monto deseado", saldo, 1);
            switch (opc) {
                case 1:
                    int doc = 200000;
                    saldo = CalcularSaldo(saldo, doc);
                    preguntar();
                    break;
                case 2:
                    int cien = 100000;
                    saldo = CalcularSaldo(saldo, cien);
                    preguntar();
                    break;
                case 3:
                    int cincuenta = 50000;
                    saldo = CalcularSaldo(saldo, cincuenta);
                    preguntar();
                    
                    break;
                case 4:
                    int veinticinco = 25000;
                    saldo = CalcularSaldo(saldo, veinticinco);
                    break;
                case 5:
                    int diez = 10000;
                    saldo = CalcularSaldo(saldo, diez);
                            preguntar();

                    break;
                case 6:
                    int cinco = 5000;
                    saldo = CalcularSaldo(saldo, cinco);
                            preguntar();

                case 7:
                    validardatos("Ingrese monto deseado", saldo, 2);
                case 8:

                    menu("1234");
                    break;
                case 9:
                    principal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debe acceder a una operación");
            }
        }
        return newsaldo;
    }

    public static int CalcularSaldo(int saldo, int opcion) {
        int newsaldo = 0;
        if (saldo > 0) {
            newsaldo = saldo - opcion;
            JOptionPane.showMessageDialog(null, "Su nuevo saldo es " + newsaldo);
        } else {
            JOptionPane.showMessageDialog(null, "Sin saldo suficiente ");
        }
        return newsaldo;
    }

    public static void preguntar() {
        boolean siono = true;
        int preg = 0;
        while (siono) {
            boolean comprobar = true;

            while (comprobar) {
                try {
                    preg = Integer.parseInt(JOptionPane.showInputDialog("¿Desea"
                     + " realizar otra operación?"+"\n"+"1.- SI"+"\n"+"2.- NO"));
                    comprobar = false;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "No se ingreso opción válida");
                }
            }
            switch (preg) {
                case 1: // SI 
                    menu("1234");
                    break;
                case 2: // NO
                    principal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debes seleccionar la opcion 1 o 2");
            }
        }
    }
}

