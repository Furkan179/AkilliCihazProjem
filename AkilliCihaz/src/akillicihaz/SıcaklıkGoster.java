package akillicihaz;

import java.util.Random;

public class SıcaklıkGoster implements IIslem{
    
    private IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi;
    private IEkran ekran;
    private IKlavye tusTakimi;
    private KullaniciHesabi kullaniciHesabi;
    //private IParaBolmesi paraBolmesi;
    
    public SıcaklıkGoster(IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi, IEkran ekran, IKlavye tusTakimi, KullaniciHesabi kullaniciHesabi) {
        this.akilliCihazBilgiSistemi = akilliCihazBilgiSistemi;
        this.ekran = ekran;
        this.tusTakimi = tusTakimi;
        this.kullaniciHesabi = kullaniciHesabi; //this.paraBolmesi = paraBolmesi;
    }
    
    @Override
    public void islemYap() {
        Random random =new Random(); //random sınıfı
        int sicaklik=random.nextInt(101);//Sıcaklık 0-100 arası random gelıyor
        ekran.mesajGoruntule("Sıcaklik : "+ sicaklik);
    }
    
}
