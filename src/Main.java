import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nZadanie1------------------------------------");
        zadanie1();
        System.out.println("\nZadanie2------------------------------------");
       zadanie2();
        System.out.println("\nZadanie3------------------------------------");
        //Zadanie3
        String Wyrazenie = "+B+a+ł---+a+g+a---+n-+w-+l+i+t---+e-+r+k--+a+c+h---";
        Stos<Character> MojStos = new Stos<>();

        for (int i = 0; i < Wyrazenie.length(); i++) {
            if (Wyrazenie.charAt(i) == '+') {

            } else if (Wyrazenie.charAt(i) == '-') {

                System.out.print(MojStos.pop());
            }
            else MojStos.push(Wyrazenie.charAt(i));
        }
        System.out.println("\nZadanie4------------------------------------");

        zadanie4();
        System.out.println("\nZadanie5------------------------------------");
        zadanie5();


    }



    public static void zadanie1() {
        ArrayList<Kangur> kangury = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            kangury.add(new Kangur(i));
        }
        for (int i = 0; i < kangury.size(); i++) {
            Kangur kangur = kangury.get(i);
            kangur.skok();
        }
        System.out.println("----------------------------------------");

        Iterator<Kangur> iterator = kangury.iterator();

        while (iterator.hasNext()) {
            Kangur kangur = iterator.next();
            kangur.skok();
        }
        System.out.println("----------------------------------------");
        HashMap<String, Kangur> MapaKangurow = new HashMap<>();
        int index = 0;
        MapaKangurow.put("Michal", kangury.get(index++));
        MapaKangurow.put("Bartek", kangury.get(index++));
        MapaKangurow.put("Jan", kangury.get(index++));
        MapaKangurow.put("Antek", kangury.get(index++));
        Iterator<String> iterator2 = MapaKangurow.keySet().iterator();
        while (iterator2.hasNext()) {
            String key = iterator2.next();
            Kangur kangur = MapaKangurow.get(key);
            System.out.println("Imię: " + key + ", Numer: " + kangur.skok());
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Posortowne: ");

        SortedSet<String> Posortowane = new TreeSet<>(MapaKangurow.keySet());
        LinkedHashMap<String, Kangur> LinkedHashMapa = new LinkedHashMap<>();
        for (String item : Posortowane) {

            LinkedHashMapa.put( item,MapaKangurow.get(item));
        }
        Iterator<String> iterator3 = LinkedHashMapa.keySet().iterator();
        while (iterator3.hasNext()) {
            String key = iterator3.next();
            Kangur kangur = LinkedHashMapa.get(key);
            System.out.println("Imię: " + key + ", Numer: " + kangur.skok());
        }






    }

    static class Kangur {
        int nrKangura;

        public Kangur(int nrKangura) {
            this.nrKangura = nrKangura;
        }

        public int skok() {
            System.out.println("Podskok kangura nr: " + nrKangura);
            return nrKangura;
        }
    }



      public static class Stos<T> {


         private  LinkedList<T> stos;

        public Stos() {
            stos = new LinkedList<>();
        }



         public  void push(T v) {
            stos.push(v);
        }

        public T peek() {
            return stos.peek();
        }

        public  T pop() {
            return stos.pop();
        }

        public boolean empty() {
            return stos.isEmpty();
        }

        @Override
        public String toString() {
            return stos.toString();
        }
    }
    public static  void zadanie2(){
        Queue<Command> MojaKolejka = Wypelnienie.wypelniaj();
        Pobieranie.Pobierz(MojaKolejka);
    }
    public static  void zadanie4(){
        String[] produkty = {"Mleko","Masło","Ryby",
                "Ser","Mięso", "Kawa", "Czekolada","Pizza","Herbata","Sok"};
        Stos<String> MojKoszyk = new Stos<>();
        Random random = new Random();

        int iloscProduktow = random.nextInt(15)+1;
        for (int i = 0; i < iloscProduktow; i++) {
            int Randomowy = random.nextInt(produkty.length);
            String WylosowanyProdukt = produkty[Randomowy];
            MojKoszyk.push(WylosowanyProdukt);

        }

        int KolejkaOsob = random.nextInt(10)+1;
        int MojaPozycja = random.nextInt(KolejkaOsob)+1;
        Queue<String> Kolejka = new LinkedList<>();
        for (int i = 1; i <= KolejkaOsob; i++) {
            if(i == MojaPozycja){
                Kolejka.add("Ja");

            }
            else{
                Kolejka.add("Osoba nr."+i);
            }

        }
        while(!Kolejka.isEmpty()){
            if(Kolejka.peek()=="Ja"){
                System.out.println("Obsługa mnie: ");
                while(!MojKoszyk.empty()){
                    System.out.println(MojKoszyk.pop());
                }
            }
            else{
                System.out.println("Obsługa osoby: "+ Kolejka.peek());
            }
            Kolejka.remove();


            }
        }







    static class  Command {
        String CiagZnakow;

        public Command(String CiagZnakow) {
            this.CiagZnakow = CiagZnakow;
        }

        public void operation() {
            System.out.println(CiagZnakow);
        }
    }

    class Wypelnienie {
        public static Queue<Command> wypelniaj() {
            Queue<Command> commandQueue = new LinkedList<>();
            commandQueue.add(new Command("Command numer 1"));
            commandQueue.add(new Command("Command numer 2"));
            commandQueue.add(new Command("Command numer 3"));
            return commandQueue;
        }
    }
    class Pobieranie{
        public static void Pobierz(Queue<Command> cos){
            while(!cos.isEmpty()){
                System.out.println("Pobrałem "+cos.peek().CiagZnakow);
                cos.remove();
            }
        }
    }
    public static void zadanie5(){
        Map<Integer, Film> prywatnaKolekcja = new HashMap<Integer, Film>();

        Integer  MyKey = 123;
        prywatnaKolekcja.put(MyKey++, new Film("Harry Poter",111, false));
        prywatnaKolekcja.put(MyKey++, new Film("Top Gun",122, false));
        prywatnaKolekcja.put(MyKey++, new Film("Jurasic Word",124, true));
        prywatnaKolekcja.put(MyKey++, new Komedia("Chłopaki też płaczą",129, false));
        prywatnaKolekcja.put(MyKey++, new Horror("M3Gun",112, false));

        // Tworzenie  SET z Map
        Set<Map.Entry<Integer, Film>> Set_prywatnaKolekcja = prywatnaKolekcja.entrySet();
        // Tworzenie Inetatora z Set
        Iterator<Map.Entry<Integer, Film>> Iterator_prywatnaKolekcjar = Set_prywatnaKolekcja.iterator();

        while(Iterator_prywatnaKolekcjar.hasNext()) {
            Map.Entry<Integer, Film> Entry_prywatnaKolekcjar = Iterator_prywatnaKolekcjar.next();

            System.out.print("Nr w Kolekcji " + Entry_prywatnaKolekcjar.getKey() + ", "); Entry_prywatnaKolekcjar.getValue().Wypisz_dane();

        }

    }
    public static class Film{
        Integer czasTrwania ;
        boolean czyObejrzany;
        String tytul ;
        String typ;
        public  Film(String tytul, Integer czasTrwania, boolean czyObejrzany){
            this.czasTrwania =czasTrwania;
            this.czyObejrzany = czyObejrzany;
            this.tytul = tytul;
            this.typ = "nieokreślony";
        }



        public void Wypisz_dane(){
            System.out.println( " Tytul: " + tytul + ", Czas trwania: " + czasTrwania + ", Obejrzany: " + (czyObejrzany?"tak":"nie") +  ", Typ: " + typ);
        }

    }

    public static class Horror extends Film {
        public Horror(String tytul, Integer czasTrwania, boolean czyObejrzany){
            super(tytul,  czasTrwania, czyObejrzany);
            this.typ = "Horror";
        }


    }

    public static class Komedia extends Film {
        public Komedia(String tytul, Integer czasTrwania, boolean czyObejrzany){
            super(tytul,  czasTrwania, czyObejrzany);
            this.typ = "Komedia";
        }


    }

}

