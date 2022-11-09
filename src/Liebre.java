public class Liebre extends Thread{

    char[] pista;

    public Liebre(char[] a) {
        this.pista = a;
    }


    public void run() {
        boolean ganador = false;
        int posicion = 0;
        pista[posicion] = 'L';
        while (ganador == false) {
            System.out.println("");
            int pasos = (int) Math.floor(Math.random() * (100) + 1);

            //Inico si duerme
            if (pasos <= 20) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (pasos < 20 && pasos <= 40) {
                if((posicion + 9) > 69){
                    posicion = 69;
                } else {
                    pista[posicion] = 0;
                    posicion = posicion + 9;
                    pista[posicion] = 'L';
                }
                Posiciones(pista);
                ganador = win(posicion, ganador);
            }
            //Fin si da un gran salto
            //Inicio resbalón grande
            if (pasos > 40 && pasos <= 50) {
                pista[posicion] = 0;
                if ((posicion - 12) < 0) {
                    posicion = 0;
                } else {
                    posicion = posicion - 12;
                }
                Posiciones(pista);
            }
            //Fin rebalón grande
            //Inicio pequeño salto
            if (pasos > 50 && pasos <= 80) {
                if ((posicion + 1) > 69){
                    posicion = 69;
                } else {
                    pista[posicion] = 0;
                    posicion = posicion + 1;
                    pista[posicion] = 'L';
                }
                Posiciones(pista);
                ganador = win(posicion, ganador);
            }
            //Fin pequeño salto
            //Inicio resbalón pequeño
            if (pasos > 80 && pasos <= 100) {
                pista[posicion] = 0;
                if ((posicion - 12) < 0) {
                    posicion = 0;
                } else {
                    posicion = posicion - 2;
                }
                Posiciones(pista);
            }
        }
    }

    public static void Posiciones(char[] pista) {
        for (int i = 0; i < pista.length; i++) {
            if (pista[i] == 0) {
                System.out.print(" ");
            } else {
                System.out.print(pista[i]);
            }
        }
    }

    public static boolean win(int posicion, boolean ganador){
        if (posicion == 69){
            ganador = true;
            System.out.printf("Ganó la liebre ");

        }
        return ganador;
    }
}
