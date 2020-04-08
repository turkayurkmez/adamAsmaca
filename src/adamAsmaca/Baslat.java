package adamAsmaca;

import java.util.Random;
import java.util.Scanner;

public class Baslat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      /*
       * 1. Bir kelime grubundan rastgele bir kelime seçilir.
       *   //ayna 
       *   
       * 2. Seçilen kelimenin harf sayısı kadar * veya istenen bir işaret basar
       *   //****
       * 3. Kullanıcı harf tahmini yapar. 
       *    a. Harf varsa, harfin yerini girilen harfe dönüştürür.
       *    //a**a
       *    b. Harf yoksa deneme sayısı bir artar
       *    c. Eğer deneme sayısı 10 olursa oyun biter. Sonra 5. Adıma gider
       * 4. Kelimeyi tahmin hakkı verilir. 
       *    a. Bilirse "Bildiniz" der ve 5. Adıma gider
       *      a.1: Evet derse başa döner
       *      a.2: Hayır derse bitirir.
       *    b. Bilemezse, 3. adıma geri döner.
       * 5. tekrar edip etmeyeceğini sorar. 
       *      a.1: Evet derse başa döner
       *      a.2: Hayır derse bitirir.   
       *           
       * */
		
		double sonuc =  ussunuAl(9, 2);
		System.out.println(sonuc);
		
		Scanner scanner = new Scanner(System.in);
		//1.
		String[] bulmaca = {"kolay","telefon","deoksribonükleikasit","ankara"};
		boolean oyunaDevamEdilsinMi = true;
		do {
		
			int denemeSayisi = 0;
			boolean kelimeyiBildiMi = false;
			String secilenKelime = kelimeSec(bulmaca);
			char[] bilinmeyen = kelimeyiDonustur(secilenKelime, '?');
			System.out.println(bilinmeyen);
			//kelime bulunmadığı VE deneme sayısı 10'dan küçük olduğu SÜRECE
			denemeSayisi = harfDeneme(scanner, denemeSayisi, kelimeyiBildiMi, secilenKelime, bilinmeyen);
			if (denemeSayisi==10) {
				System.out.println("Adam Asıldı!!");				
			}
			
			System.out.println("Tekrar oynamak ister misiniz (E/H)?");	
			String cevap = scanner.next();
			if (cevap.toUpperCase().equals("H")) {
				oyunaDevamEdilsinMi = false;
			}
			
		}while(oyunaDevamEdilsinMi);
		
		
		
		
		
		
		
	
		
		
	}
	private static int harfDeneme(Scanner scanner, int denemeSayisi, boolean kelimeyiBildiMi, String secilenKelime,
			char[] bilinmeyen) {
		while (!kelimeyiBildiMi && denemeSayisi<10 ) {
			System.out.println("Harf giriniz:");
			String harf = scanner.next();
			boolean sonuc = harfVarMi(secilenKelime,harf);
			if (!sonuc) {
				System.out.println("Bu harf yok!");
				denemeSayisi++;
				System.out.println(denemeSayisi + ". Deneme");
			}
			bilinmeyen = harfAra(secilenKelime,harf,bilinmeyen);
			System.out.println(bilinmeyen);			
			System.out.println("Kelimeyi tahmin edin:");
			String tahmin = scanner.next();
			kelimeyiBildiMi = tahmin.equals(secilenKelime);
			if (kelimeyiBildiMi) {
				System.out.println("Tebrikler! Bildiniz");
			}
		}
		return denemeSayisi;
	}
	private static char[] harfAra(String secilenKelime, String harf, char[] bilinmeyen) {
		// TODO Auto-generated method stub
		//ayna a
		//0..3
		//????
		//a???
		//a??a
		int arananIndex = secilenKelime.indexOf(harf, 0);
		while (arananIndex != -1) {			
			bilinmeyen[arananIndex] = harf.charAt(0);
			arananIndex++;
			arananIndex = secilenKelime.indexOf(harf, arananIndex);
					
		}
		return bilinmeyen;
		
	}
	private static boolean harfVarMi(String secilenKelime, String harf) {
		// TODO Auto-generated method stub
		 return secilenKelime.contains(harf);
			
		
	}
	static String kelimeSec(String[] kelimeler) {
		Random uretici = new Random();
		int index = uretici.nextInt(kelimeler.length);
	 	return kelimeler[index];
		
	}
	
	static char[] kelimeyiDonustur(String kelime,char sembol) {
		//ayna
		//****
		char[] sonuc = new char[kelime.length()];
		//0. elemandan sonuncu elemana kadar hepsini sembol ile değiştir.
		for (int i=0;i<sonuc.length;i++) {
			sonuc[i]=sembol;
		}
		return sonuc;
		
	}
	
	static String sifrele(String metin, int sayi) {
		
	}
	static String sifreyiCoz(String sifreliMetin, int sayi) {
		
	}
	
 	static double ussunuAl(double x, double y) {
		/*
		 * 2 üssü 3 = 2 * 2 * 2
		 * 
		 * */
 		double sonuc=1;
 		for (int i = 1; i <= y; i++) {
			sonuc *= x;
		}
 		
 		return sonuc;
	}


}
