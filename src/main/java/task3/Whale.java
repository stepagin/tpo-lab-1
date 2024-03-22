package task3;

public class Whale extends Creature{

    public void realizeWhale() {
        System.out.println("Кит осознаёт себя как кит.");
        this.setMind("Я кит.");
    }

    public void realizeNotWhale() {
        System.out.println("Кит осознаёт, что он не кит.");
        this.setMind("Я не кит.");
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
        System.out.println("Кит меняет позицию: " + position);
    }
}
