public class OOPS {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Cat();
        a.print();
        b.print();
    }
}

class Animal {
    void print(){
        System.out.println("Animal class");
    }
}

class Cat extends Animal{
    void print(){
        System.out.println("Cat Class");
    }
    void walk(){
        System.out.println("Cat walks");
    }
    
}