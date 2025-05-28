import java.lang.reflect.Field;

public class BandProxy extends BandComponent {
    Band targetBand;

    public BandProxy (Band targetBand) {
        this.targetBand = targetBand;
    }

    @Override
    public String getName () {
        return "";
    }

    @Override
    public void perform () {
        int count = 0;
        System.out.println("🎭 공연 점검");

        for (BandComponent member : targetBand.members) {
            Class<?> clazz = member.getClass();

            try {
                Field energyLevelField = clazz.getDeclaredField("energyLevel");
                energyLevelField.setAccessible(true);
                int energyLevel = (int) energyLevelField.get(member);

                if (energyLevel < 30) count += 1;

            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (count >= 2) {
            System.out.println("❌ 컨디션 불량 멤버가 2명 이상입니다. 공연을 취소합니다.");
        } else if (count >= 1) {
            System.out.println("⚠\uFE0F 일부 멤버의 컨디션이 좋지 않지만 공연을 강행합니다...");
        } else {
            System.out.println("✅ 멤버 컨디션 양호! 공연을 시작합니다!");
            targetBand.perform();
        }
    }

    @Override
    public void printStructure (String prefix) {
        targetBand.printStructure(prefix);
    }
}
