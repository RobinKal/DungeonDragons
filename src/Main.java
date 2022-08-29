public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int n = 100;
        System.out.println("La somme de tous les nombres de 1 à " + n + " est " + sumIter(n));

        int m = 100;
        System.out.println("La factorielle de " + m + " est " + fact(m));

    }

    public static int sumIter(int n){
        if (n <= 0){
            throw new Error("Entrez un nombre strictement supérieur à 0 !");
        } else {
            return n==1 ? 1 : n + sumIter(n-1);
        }
    }

    public static double fact(int m){
        if (m <= 0){
            throw new Error("Entrez un nombre strictement supérieur à 0 !");
        } else {
            return m == 1 ? 1 : m * fact(m-1);
        }
    }
}