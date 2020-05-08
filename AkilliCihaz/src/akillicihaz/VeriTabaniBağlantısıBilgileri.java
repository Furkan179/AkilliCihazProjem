package akillicihaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeriTabaniBağlantısıBilgileri {
    
    private static VeriTabaniBağlantısıBilgileri Baglanti;
    
    public static VeriTabaniBağlantısıBilgileri baglanti()
    {   
        Baglanti = new VeriTabaniBağlantısıBilgileri();
        return Baglanti;
    }
    
    public String VeriTabaniBaglantiBilgileriniGetir()
    {
          String url = "jdbc:postgresql://localhost:5432/Kullanici";
          return url;       
    }
}
