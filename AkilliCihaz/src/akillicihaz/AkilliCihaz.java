package akillicihaz;

public class AkilliCihaz {
        
        
        private IEkran ekran;
	private IKlavye tusTakimi;

        // ana menu secenekleri
        private static final int KAYIT_OL = 1;
        private static final int GIRIS_YAP = 2;
        private static final int _CIKIS = 3;
        

	//  menu seçenekleri
	private static final int SICAKLIK_GORUNTULE = 1;
	private static final int SOĞUTUCUYU_AÇ = 2;
	private static final int SOĞUTUCUYU_KAPAT = 3;
	private static final int CIKIS = 4;


	public AkilliCihaz() 
	{	
		ekran=new Ekran();
		tusTakimi=new Klavye();
	}

	public void basla() {
                //Giris_Kayit_Islem_Secimi();
                int secenek;
                
                do{
                secenek = Giris_Kayıt_Menusu_Goster();//Giris_Kayıt_Menusu_Goster() ve int bir değer geri döndürür.
                switch (secenek) {
                    case KAYIT_OL:
                            ekran.mesajGoruntule("KAYIT OLMA ISLEMINI SECTINIZ");
                            ekran.mesajGoruntule("Lütfen UserName inizi Giriniz...");
                            String user_nameee = tusTakimi.S_veriAl();
                            ekran.mesajGoruntule("Sifrenizi Giriniz...");
                            String sifreeee = tusTakimi.S_veriAl();
                            ekran.mesajGoruntule("Lütfen Name inizi Giriniz...");
                            String name = tusTakimi.S_veriAl();
                            ekran.mesajGoruntule("LastName Giriniz...");
                            String last_name = tusTakimi.S_veriAl();

                            KullaniciPostgreSQLSurucu kl = new KullaniciPostgreSQLSurucu();
                            //KullaniciPostgreSQLSurucu sınıfından a  nesnesi oluşturduk
                            
                            kl.KullaniciPostgreSQLSurucuKayit(user_nameee, sifreeee, name, last_name);
                            //KullaniciPostgreSQLSurucu sınıfının bir methodunu kullandık ve değerleri bu metoddaki değişkenlere atadık
                        break;
                    case GIRIS_YAP:
                            ekran.mesajGoruntule("GIRIS YAPMA ISLEMINI SECTINIZ");
                            ekran.mesajGoruntule("Lütfen UserName inizi Giriniz...");
                            String user_namee = tusTakimi.S_veriAl();
                            ekran.mesajGoruntule("Sifrenizi Giriniz...");
                            String sifreee = tusTakimi.S_veriAl();                   
			    IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi=new AkilliCihazBilgiSistemi();
			    KullaniciHesabi kullaniciHesabi= kullaniciDogrulama(user_namee, sifreee, akilliCihazBilgiSistemi);                     
                            if (kullaniciHesabi!=null){
                                ekran.mesajGoruntule("Başarili Bir Sekilde Giris Yapildi....");
				ekran.mesajGoruntule(kullaniciHesabi.toString());
				islemSecimi(akilliCihazBilgiSistemi, kullaniciHesabi);                                
			    }   
                            else 
                            {
				ekran.mesajGoruntule("Basarisiz Giris");
                            } 
                        break;
                    case _CIKIS:
                            ekran.mesajGoruntule("Çıkılıyor");
                        break;
                    default:
                            ekran.mesajGoruntule("1-3 arasında bir sayı girmelisiniz");                       
                    }
                }while(secenek!=3);
            }
	private KullaniciHesabi kullaniciDogrulama(String user_name, String sifre, IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi){
		return akilliCihazBilgiSistemi.kullaniciDogrula(user_name,sifre);

	}

	private void islemSecimi(IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi, KullaniciHesabi kullaniciHesabi){
		int secim;
		 do{
		 	secim=anaMenuyuGoster();
			switch (secim) {
				case SICAKLIK_GORUNTULE:
					ekran.mesajGoruntule("SICAKLIK GORUNTULEME ISLEMINI SECTINIZ");
					IIslem sıcaklıkGoruntuleme=new SıcaklıkGoster(akilliCihazBilgiSistemi, ekran, tusTakimi, kullaniciHesabi);
					sıcaklıkGoruntuleme.islemYap();
					break;
				case SOĞUTUCUYU_AÇ:
					ekran.mesajGoruntule("SOGUTUCU ACMA ISLEMINI SECTINIZ");
					IIslem sogutucuAcma=new SogutucuAcma(akilliCihazBilgiSistemi, ekran, tusTakimi, kullaniciHesabi);
					sogutucuAcma.islemYap();
					break;

				case SOĞUTUCUYU_KAPAT:
					ekran.mesajGoruntule("SOGUTUCU KAPATMA ISLEMINI SECTINIZ");
					IIslem sogutucuKapatma=new SogutucuKapatma(akilliCihazBilgiSistemi, ekran, tusTakimi, kullaniciHesabi);
					sogutucuKapatma.islemYap();
					break;

				case CIKIS:
					ekran.mesajGoruntule("Çıkılıyor");
					break;
				default:
					ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz");
			}
		}while(secim!=4);
	}        

	private int anaMenuyuGoster()
	{
		ekran.mesajGoruntule("******************************************");
		ekran.mesajGoruntule("Ana Menu");
		ekran.mesajGoruntule("1-Sıcaklık Görüntule");
		ekran.mesajGoruntule("2-Sogutucuyu Aç");
		ekran.mesajGoruntule("3-Sogutucuyu Kapat");
		ekran.mesajGoruntule("4-Cikis");
		ekran.mesajGoruntule("Seciminiz:");
		ekran.mesajGoruntule("******************************************");

		return tusTakimi.veriAl();
	}
        
        private int Giris_Kayıt_Menusu_Goster()
        {
            ekran.mesajGoruntule("******************************************");
            ekran.mesajGoruntule("Ana Menu");
            ekran.mesajGoruntule("1-KAYIT OL");
            ekran.mesajGoruntule("2-GIRIS YAP");
            ekran.mesajGoruntule("3-Cikis");
            return tusTakimi.veriAl();
        }
    
}
