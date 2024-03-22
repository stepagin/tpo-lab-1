package task3;

public class Creature {
    private String position;
    private String mind;
    public void realize() {
        System.out.println("Существо осознает себя");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMind() {
        return mind;
    }

    public void setMind(String mind) {
        this.mind = mind;
    }

    public void getUsedToThoughts() {
        if (this.getMind().equals("")) {
            System.out.println("У существа нет мыслей.");
            return;
        }
        System.out.println("Существо свыкается с мыслью: " + this.getMind());
        this.setMind("");
    }
}
