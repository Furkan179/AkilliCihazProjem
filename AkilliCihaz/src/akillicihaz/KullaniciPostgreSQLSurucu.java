package akillicihaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class KullaniciPostgreSQLSurucu implements IKullaniciVeritabaniServisi{


      VeriTabaniBağlantısıBilgileri veriTabaniBağlantısıBilgileri = VeriTabaniBağlantısıBilgileri.baglanti();
      //Burada Singleton tasarım desenini kullandık 
      
      List<String>  user_names = new ArrayList<String>();
      List<String>  passwords = new ArrayList<String>();
      List<String>  names = new ArrayList<String>();
      List<String>  last_names = new ArrayList<String>();
      public  KullaniciPostgreSQLSurucu() {
        System.out.println("Veritabanına bağlanıyoruz...");        
        
        try {
                    
            
            String url = veriTabaniBağlantısıBilgileri.VeriTabaniBaglantiBilgileriniGetir();
            // bağlancağımız veritabanın adresini aldık
            
            Connection conn = DriverManager.getConnection(url,
                    "postgres", "179805");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");   
            
            
            String sorgu = "SELECT *  FROM kullanicilar";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sorgu);
            
            while(rs.next())//veri tabanindaki kullanıcı bilgilerini her sutunu ayrı listeye atıyorum
            {
                user_names.add(rs.getString("user_name"));//kullanıcı  adı listesi
                passwords.add(rs.getString("password"));//password listesi
                names.add(rs.getString("name"));//ad listesi
                last_names.add(rs.getString("last_name"));// soyad listesi
            }
            
            conn.close();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }          
    }
     
    public void KullaniciPostgreSQLSurucuKayit(String user_name, String sifre, String name, String last_name)
    {
        System.out.println("Veritabanına bağlanıyoruz...");       
        try {
            String url = veriTabaniBağlantısıBilgileri.VeriTabaniBaglantiBilgileriniGetir();
            // bağlancağımız veritabanın adresini aldık
            
            Connection conn = DriverManager.getConnection(url,
                    "postgres", "179805");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");   
            
            PreparedStatement statement = conn.prepareStatement("INSERT INTO \"kullanicilar\" (user_name,name,last_name,password)"+ "VALUES ( ?,?,?,?)");
            statement.setString( 1, user_name );
            statement.setString( 2, name );
            statement.setString( 3, last_name );
            statement.setString( 4, sifre );
            statement.executeUpdate();
        } 
        catch (Exception e) {   
            System.out.println(e.getMessage());
        }     
               
    }
      
    
    public List user_namesListesi()
    {
        return user_names;
    }
    public List passwordsListesi()
    {
        return passwords;
    }
    public List namesListesi()
    {
        return names;
    }
    public List last_nameListesi()
    {
        return last_names;
    }

    

            
    
    
}
