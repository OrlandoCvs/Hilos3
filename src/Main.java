public class Main {
    public static void main(String[] args) {

        char[] dato;
        dato = new char[70];


        Thread liebre = new Thread(new Tortuga(dato));
        Thread tortuga = new Thread(new Liebre(dato));

        liebre.setName("LiebreT");
        tortuga.setName("TortguaT");

        System.out.println("Carrera iniciada --->");
        liebre.start();
        tortuga.start();
    }
}


