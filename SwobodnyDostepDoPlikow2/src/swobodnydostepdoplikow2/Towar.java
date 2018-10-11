
package swobodnydostepdoplikow2;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
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
    
    public static void SaveToFile(Towar[] towar, DataOutput outS) throws IOException{
        
        for (int i=0; i < towar.length; i++) {
          towar[i].zapiszDane(outS);
        
        }
    }
    
    public static Towar[] ReadFromFile(RandomAccessFile RAF) throws IOException{
        int dl = (int)RAF.length()/Towar.DLUGOSC_LINII;
        Towar[] towar = new Towar[dl];
        
        for (int i = 0; i < dl; i++){
            towar[i] = new Towar();
            towar[i].czytajDane(RAF);
            
        }
        
        return towar;
    }
    
    public void zapiszDane(DataOutput outS) throws IOException {
        outS.writeDouble(this.cena);
        StringBuffer stringB = new StringBuffer(Towar.DLUGOSC_NAZWY); //StringBuffer pobiero do bufforu String i cos z nim robi
        stringB.append(this.nazwa); //dodaje do buforu nazwe
        stringB.setLength(Towar.DLUGOSC_NAZWY); //ustawiamy długość do jakiej ma powiekszac dlugosc tekstu pustymmi polami
        outS.writeChars(stringB.toString()); //zapisujemy z bufora do pliku.
        //robimy to poto aby moc sie poruszac po pliku. Wszystkie nazwy maja ta sama dlugosc
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        outS.writeInt(kalendarz.get(Calendar.YEAR));
        outS.writeInt(kalendarz.get(Calendar.MONTH)+1);
        outS.writeInt(kalendarz.get(Calendar.DAY_OF_MONTH));
    
    }
    
    public void czytajDane(DataInput inS) throws IOException{
        this.cena = inS.readDouble();
        
        StringBuffer tString = new StringBuffer(Towar.DLUGOSC_NAZWY);
        for(int i=0; i<Towar.DLUGOSC_NAZWY;i++){
            char tCh = inS.readChar();
            if(tCh != '\0')
                tString.append(tCh);
        }
        
        this.nazwa = tString.toString();
        int rok = inS.readInt();
        int m = inS.readInt();
        int dz = inS.readInt();
        
        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.set(rok, m-1, dz);
        this.dataWydania = kalendarz.getTime();
    }
    
    public void czytajWskazanyRekord(RandomAccessFile RAF, int n) throws IOException, BrakRekordu{
        if(n<=RAF.length()/Towar.DLUGOSC_LINII){
        RAF.seek((n-1)*Towar.DLUGOSC_LINII);
        this.czytajDane(RAF);
        }
        else
            throw new BrakRekordu("Nie ma takiego rekordu");
        
    }
    
    public static final int DLUGOSC_NAZWY = 30;
    public static final int DLUGOSC_LINII = (Character.SIZE*DLUGOSC_NAZWY+Double.SIZE+3*Integer.SIZE)/8;
    private double cena;
    private String nazwa;
    private Date dataWydania;
    
}
