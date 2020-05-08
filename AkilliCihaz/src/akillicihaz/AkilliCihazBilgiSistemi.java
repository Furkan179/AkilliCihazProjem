package akillicihaz;

public class AkilliCihazBilgiSistemi implements IAkilliCihazBilgiSistemi{

    private String ad;
    private String soyad;
    
    private KullaniciHesabi kullaniciHesabi; //Kullanıcının çok sayıda hesabı olabilir.
    
    KullaniciPostgreSQLSurucu a = new KullaniciPostgreSQLSurucu();
    
    @Override
    public KullaniciHesabi kullaniciDogrula(String user_name, String sifre) {                     
             
        if(a.user_namesListesi().contains(user_name)){
                    if(a.passwordsListesi().contains(sifre)){
                        if(a.user_namesListesi().indexOf(user_name)==a.passwordsListesi().indexOf(sifre))//veri tabanında user_name girdikten sonra veritabanınndaki herhangi başkasının şifresi ile girmesini engelledik
                        {
			                             
                            System.out.println("banka bilgi sistemi kullanıcıyı doğruluyor...");
                            System.out.println("veritabanına bağlandı ve kullanıcı hesap bilgilerini aldı...");
                            int index = a.user_namesListesi().indexOf(user_name);
                            ad = (String) a.namesListesi().get(index);
                            soyad = (String) a.last_nameListesi().get(index);
                            Musteri musteri=new Musteri(ad,soyad);
                            kullaniciHesabi= new KullaniciHesabi(musteri);
                            return kullaniciHesabi;
                        }
                        else
                        {
                                return null;
                        }
                    }
                    else
                    {                       
                        return null;
                    }
		} 
                else {			
                        return null;
                }
         
        
    }

           
}
