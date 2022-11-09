
    public class Tortuga extends Thread {
        char[] dato;

        public Tortuga(char[] a) {
            this.dato = a;
        }

        public void run() {
            boolean ganador = false;
            int posicion = 0;

            while (ganador == false) {
                System.out.println("");
                int pasos = (int) Math.floor(Math.random() * (100) + 1);

                if (pasos <= 50) {
                    if ((posicion + 6) > 69) {
                        posicion = 69;
                    } else {
                        dato[posicion] = 0;
                        posicion = posicion + 6;
                        dato[posicion] = 'T';
                    }
                    Posiciones(dato);
                    ganador = win(posicion, ganador);
                }

                if (pasos > 50 && pasos <= 70) {
                    dato[posicion] = 0;
                    if ((posicion - 6) < 0) {
                    } else {
                        posicion = posicion - 6;
                    }
                    Posiciones(dato);
                }

                if (pasos > 70 && pasos <= 100) {
                    if ((posicion + 1) > 69){
                        posicion = 69;
                    } else {
                        dato[posicion] = 0;
                        posicion = posicion + 1;
                        dato[posicion] = 'T';
                    }
                    Posiciones(dato);
                    ganador = win(posicion, ganador);
                }
            }
        }

        public static void Posiciones(char[] dato) {
            for (int i = 0; i < dato.length; i++) {
                if (dato[i] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(dato[i]);
                }
            }
        }

        public static boolean win(int posicion, boolean ganador) {
            if (posicion == 69) {
                ganador = true;
                System.out.printf("Ganó la tortuga ");
            }
            return ganador;
        }
    }

