package akillicihaz;

public class KullaniciHesabi
{
	private Musteri musteri;

	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	public KullaniciHesabi(Musteri musteri) {		
		this.musteri=musteri;
	} 
        
	@Override
	public String toString() {
		return "Hoşgeldiniz ... : " + " "+ musteri.getAd()+" "+musteri.getSoyad();
	}
}
