package Demo015;
//1 erfboom van 3 klassen

//1 erfboom van 2 klassen
//1 interface
//1 abstracte klasse
//1 field per klasse
//1 methode per klasse
//1 abstracte methode in abstracte klasse
//1 abstracte methode in interface
//verschillende override
//1 maal interface als parameter
//1 maal abstracte klasse als returntype

class Demo015 {
	public static void main(String[] args) {

		Touchscreen b = new Boek();
		Touchscreen t1 = new Telefoon("Blauw", false, 600);
		Samsung s9 = new Samsung("Geel", true, 1100, "Galaxy S10");


		Apple x = new Apple("Wit", false, 1500, "X");


		s9.model();
		s9.kleur();
		s9.toString();

		x.model();
		x.kleur();
		s9.toString();

		Reparateur r = new Reparateur();
		Telefoon t2 = new Telefoon("Rood", true, 500);
		Stofzuiger s = new Stofzuiger("Grijs", true, 200);
		Laptop l = new Laptop("Zwart", true, 750);
		r.rol();
		r.repareren(t2);
		t2.aanZetten();
		b.aanraakInput();
		l.prijs();
		t2.kleur();
		s.kleur();
		System.out.println(s9);
		System.out.println(x);

	}
}

abstract class Persoon {
	abstract void rol();
}

class Reparateur {

	void rol() {
		System.out.println("Dit is de reparateur");
	}

	void repareren(Apparaat apparaat) {
		System.out.println("Ik ga repareren");
	}
}

class Gebruiker {

	void rol() {
		System.out.println("Dit is de gebruiker");
	}

	void gebruiken(Touchscreen touch) {
		touch.aanraakInput();
		{
			System.out.println("Ik heb het apparaat touch input gegeven");
		}
	}

}

abstract class Apparaat {
	String kleur;
	boolean kanAan;
	int prijs;

	public Apparaat(String kleur, boolean kanAan, int prijs) {
		super();
		this.kleur = kleur;
		this.kanAan = kanAan;
		this.prijs = prijs;
	}

	abstract void aanZetten();

	{
	}

}

class Telefoon extends Apparaat implements Touchscreen {

	public Telefoon(String kleur, boolean kanAan, int prijs) {
		super(kleur, kanAan, prijs);
	}

	void aanZetten() {
		System.out.println("Telefoon is aan");
	}

	void kleur() {
		System.out.println("Deze telefoon is " + kleur);
	}

	public void aanraakInput() {
	}
}

class Samsung extends Telefoon implements Touchscreen {
	String model;

	public Samsung(String kleur, boolean kanAan, int prijs, String model) {
		super(kleur, kanAan, prijs);
		this.model = model;
	}

	void model() {
		System.out.println("Dit is een Samsung " + model);
	}

	@Override
	public String toString() {

		return "Dit is een Samsung " + this.model + " met de kleur " + this.kleur + " en kost €" + this.prijs;

	}
}

class Apple extends Telefoon implements Touchscreen {
	String model;

	public Apple(String kleur, boolean kanAan, int prijs, String model) {
		super(kleur, kanAan, prijs);
		this.model = model;
	}

	void model() {
		System.out.println("Dit is een Iphone " + model);
	}
	
	@Override
	public String toString() {

		return "Dit is een iPhone " + this.model + " met de kleur " + this.kleur + " en kost €" + this.prijs;

	}
}

class Stofzuiger extends Apparaat {

	public Stofzuiger(String kleur, boolean kanAan, int prijs) {
	        super(kleur, kanAan, prijs);
	    }

	void aanZetten() {
		System.out.println("Stofzuiger is aan");
	}

	void kleur() {
		System.out.println("Deze stofzuiger is " + kleur);
	}
}

class Laptop extends Apparaat {
	
	public Laptop(String kleur, boolean kanAan, int prijs) {
        super(kleur, kanAan, prijs);
    }
	void aanZetten() {
		System.out.println("Laptop is aan");
	}

	void prijs() {
		System.out.println("Deze laptop kost €" + prijs);
	}
}

class Boek implements Touchscreen {
	public void aanraakInput() {
		System.out.println("Dit is een boek, deze heeft geen touchscreen");
	}
}

interface Touchscreen {
	abstract void aanraakInput();
}
