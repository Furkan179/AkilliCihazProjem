package akillicihaz;

public class SogutucuAcma implements IIslem{
    
    private IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi;
    private IEkran ekran;
    private IKlavye tusTakimi;
    private KullaniciHesabi kullaniciHesabi;
    //private IParaBolmesi paraBolmesi;

    public SogutucuAcma(IAkilliCihazBilgiSistemi akilliCihazBilgiSistemi, IEkran ekran, IKlavye tusTakimi, KullaniciHesabi kullaniciHesabi) {
        this.akilliCihazBilgiSistemi = akilliCihazBilgiSistemi;
        this.ekran = ekran;
        this.tusTakimi = tusTakimi;
        this.kullaniciHesabi = kullaniciHesabi;
        //this.paraBolmesi = paraBolmesi;
    }
    
    @Override
    public void islemYap() {
        
        ekran.mesajGoruntule("SOGUTUCU CALISTIRILDI");       
        
    }
}
