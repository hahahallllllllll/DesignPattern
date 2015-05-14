package strageMode;


import com.qingyang.factorypattern.HangZhouIngredientFactory;
import com.qingyang.factorypattern.PizzIngredientFactory;
import com.qingyang.factorypattern.ShanghaiIngredientFactory;
import com.qingyang.observerpattern.ObserverOne;
import com.qingyang.observerpattern.ObserverTwo;
import com.qingyang.observerpattern.Observerable;
import com.qingyang.strategypattern.Duck;
import com.qingyang.strategypattern.MuteDuck;
import com.qingyang.wrappattern.Beverage;
import com.qingyang.wrappattern.Espresso;
import com.qingyang.wrappattern.IceCream;
import com.qingyang.wrappattern.Milk;

public class Main {
    public static void main(String[] args){
    	    System.out.println("����ģʽ");
    	    Duck duck = new MuteDuck();
    	    duck.fly();
    	    duck.swim();
    	    duck.quack();
    	    
    	    System.out.println("�۲���ģʽ");
    	    Observerable observer = new Observerable();
    	    ObserverOne observerOne = new ObserverOne();
    	    ObserverTwo observerTwo = new ObserverTwo();
    	   
    	    observer.addObserver(observerOne);
    	    observer.addObserver(observerTwo);
       
    	    observer.notifyObservers();
       
        observer.deleteObserver(observerOne);
        observer.deleteObserver(observerTwo);

	    System.out.println("װ��ģʽ");
        
	    Beverage espresso = new Espresso();
        System.out.println("original price "+ espresso.cost());  

        espresso = new Milk(espresso);
        espresso = new IceCream(espresso);
        
        System.out.println("price with condiment "+espresso.cost());  
        System.out.println(espresso.getDescription());  
        
	    System.out.println("���󹤳�");
	    PizzIngredientFactory factory;
	    factory = new HangZhouIngredientFactory();
	    factory.createCheese().getCheese();
	    factory.createDough().getDough();
	    factory.createSauce().getSauce();
	   
	    factory = new ShanghaiIngredientFactory();
	    factory.createCheese().getCheese();
	    factory.createDough().getDough();
	    factory.createSauce().getSauce();
    }
}