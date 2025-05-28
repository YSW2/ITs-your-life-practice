import java.util.ArrayList;
import java.util.List;

public class Band extends BandComponent {
    String name;
    List<BandComponent> members = new ArrayList<>();

    public Band (String name) {
        this.name = name;
    }

    public void add (BandComponent component) {
        members.add(component);
    }

    public String getName () {
        return name;
    }

    @Override
    public void perform () {
        System.out.println("\"\uD83D\uDCA1 무대 조명 ON\"");
        System.out.println("관객: 와아아아아아!!!!");
        System.out.println("🎤 밴드 [" + name + "] 공연을 시작합니다!");
        for (BandComponent member : members) {
            member.perform();
        }
        System.out.println("밴드 [" + name + "] 공연 종료");
        System.out.println("무대 조명 OFF\n");
    }

    public void printStructure (String prefix) {
        System.out.println(prefix + " \uD83C\uDFA4 Band - " + name);
        for (BandComponent member : members) {
            member.printStructure(prefix + "  ");
        }
    }


}
