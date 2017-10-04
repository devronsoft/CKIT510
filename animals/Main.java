public class Main {

    public static void main(String[] args) {
        
   JAnimal.input();
    }


public static void fetchproperties(String anitype)
{
   String aniType = anitype; 
   
    Animal[] animals = new Animal[1];
    
    if(aniType == "Cat"){
        animals[0] = new Cat();
    }
    if(aniType == "Dog"){
        animals[0] = new Dog();
    }
    if(aniType == "Wolf"){
    animals[0] = new Wolf();
    }
    if(aniType == "Lion"){
    animals[0] = new Lion();
    }
        

        ShowPetSounds(animals);
        ShowPetMovements(animals);
     
        
    }
    

    
    public static void ShowPetSounds(IMakesSound[] petNoises) {
        for (int i = 0; i < petNoises.length; i++) {
            petNoises[i].callSound();
        }
    }
    
            
    public static void ShowPetMovements(ICanMove[] petNoises) {
        for (int i = 0; i < petNoises.length; i++) {
            petNoises[i].move();
        }
    }
    
    
        

    public static void ShowPetTemp(IWarmBlooded[] petNoises) {
        for (int i = 0; i < petNoises.length; i++) {
            petNoises[i].currentBodyTemperature();
        }
    }

}