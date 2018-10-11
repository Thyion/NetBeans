
package tokenizacja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar {
    
    public Towar() {
        this.cena = 0.0;
        this.nazwa = " ";
        this.dataWydania = new GregorianCalendar().getTime();
    }
    public Towar(double cena, String nazwa) {
        this();
        this.cena = cena;
        this.nazwa = nazwa;
    }
    public Towar(double cena, String nazwa, int rok, int m, int dz) {
        this(cena, nazwa);
        GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    
    }
    
    public double GetCena() {
        return this.cena;
    }
    
    public String GetNazwa() {
        return this.nazwa;
    }
    
    public Date GetDate(){
        return this.dataWydania;
    }
    
    public void SetCena(double cena){
        this.cena = cena;
    }
    public void SetNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    public void SetData(int r, int m, int dz){
        GregorianCalendar kalendarz = new GregorianCalendar(r, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }
    public void SetData(Date data){
        this.dataWydania = data;
    }
    @Override
    public String toString() {
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena + "zł: nazwa:"+this.nazwa+" "+kalendarz.get(Calendar.YEAR)+" rok "+(kalendarz.get(Calendar.MONTH)+1)+" miesiąc "+kalendarz.get(Calendar.DAY_OF_MONTH)+" dzień";
    }
    
    public static void SaveToFile(Towar[] towar, PrintWriter outS){
        outS.println(towar.length);
        GregorianCalendar kalendarz = new GregorianCalendar();
        for (int i=0; i < towar.length; i++) {
            kalendarz.setTime(towar[i].GetDate());
            outS.println(towar[i].GetCena()+"|"+towar[i].GetNazwa()+"|"+kalendarz.get(Calendar.YEAR)+"|"+(kalendarz.get(Calendar.MONTH)+1)+"|"+kalendarz.get(Calendar.DAY_OF_MONTH));
        
        }
    }
    
    public static Towar[] ReadFromFile(BufferedReader inS) throws IOException{
        int dl = Integer.parseInt(inS.readLine());
        Towar[] towar = new Towar[dl];
        
        for (int i = 0; i < dl; i++){
            
            String linia = inS.readLine();
            StringTokenizer tokeny = new StringTokenizer(linia, "|");                  
            double cena = Double.parseDouble(tokeny.nextToken());
            String nazwa = tokeny.nextToken();
            int rok = Integer.parseInt(tokeny.nextToken());
            int miesiac = Integer.parseInt(tokeny.nextToken());
            int dzien = Integer.parseInt(tokeny.nextToken());
            
            towar[i] = new Towar(cena, nazwa, rok, miesiac, dzien);
        }
        
        return towar;
    }
    
    private double cena;
    private String nazwa;
    private Date dataWydania;
    
}
