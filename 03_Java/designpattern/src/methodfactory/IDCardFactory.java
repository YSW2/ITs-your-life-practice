package methodfactory;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct (String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct (Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
